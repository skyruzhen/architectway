package zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/1910:53
 */
public class AuthControlDemo implements Watcher {
    private final static String CONNECT_STRING = "192.168.134.128:2181,192.168.134.129:2181,192.168.134.130:2181,192.168.134.131:2181,";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static Stat stat = new Stat();
    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        zooKeeper = new ZooKeeper(CONNECT_STRING, 5000, new AuthControlDemo());
        countDownLatch.await();
        System.out.println(zooKeeper.getState());

        //acl  (create / delete/ admin/ read/write)
        //权限模式： ip/Digest
//        zooKeeper.addAuthInfo("digest", "root:root".getBytes());
        ACL acl = new ACL(ZooDefs.Perms.CREATE, new Id("digest", "root:root"));
        List<ACL> aclList = new ArrayList<ACL>();
        aclList.add(acl);
        zooKeeper.create("/auth", "123".getBytes(),aclList,CreateMode.PERSISTENT);
       
        ZooKeeper zooKeeper1 = new ZooKeeper(CONNECT_STRING, 5000, new AuthControlDemo());
        zooKeeper1.delete("/auth", -1);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        {
            //如果当前的连接状态是连接成功的，那么通过计数器去控制
            if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                countDownLatch.countDown();
                if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                    System.out.println(watchedEvent.getState() + "-->" + watchedEvent.getType());
                } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                    try {
                        System.out.println("数据变更触发路径：" + watchedEvent.getPath() + "->节点的值：" + zooKeeper.getData(watchedEvent.getPath(), true, stat));
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                    System.out.println(watchedEvent.getState() + "-->" + watchedEvent.getType());
                } else if (watchedEvent.getType() == Event.EventType.NodeCreated) {  //创建子节点会触发
                    System.out.println(watchedEvent.getState() + "-->" + watchedEvent.getType());
                }
            }
        }
    }
}
