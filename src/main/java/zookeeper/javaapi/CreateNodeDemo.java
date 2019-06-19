package zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/1817:32
 */
public class CreateNodeDemo implements Watcher {
    private final static String CONNECT_STRING = "192.168.134.128:2181,192.168.134.129:2181,192.168.134.130:2181,192.168.134.131:2181,";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static Stat stat = new Stat();
    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        zooKeeper = new ZooKeeper(CONNECT_STRING, 5000, new CreateNodeDemo());
        countDownLatch.await();
        System.out.println(zooKeeper.getState());

/*        //创建临时节点
        String result = zooKeeper.create("/mic", "123".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zooKeeper.getData("/mic", true, stat);
        System.out.println("创建成功"+result);

        //修改数据
        zooKeeper.setData("/mic", "456".getBytes(), -1);
        Thread.sleep(2000);

        //删除数据
        zooKeeper.delete("/mic", -1);
        Thread.sleep(2000);*/

        //创建持久节点和子节点
         String path = "/node2";
 /*        zooKeeper.create(path, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        TimeUnit.SECONDS.sleep(1);

        Stat stat = zooKeeper.exists(path + "/node11", true);
        if (stat == null) {
            zooKeeper.create(path + "/node1", "1123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            TimeUnit.SECONDS.sleep(1);
        }

        //修改子路径
        zooKeeper.setData(path + "/node1", "mic123".getBytes(), -1);
        TimeUnit.SECONDS.sleep(1);*/

        List<String> childrens = zooKeeper.getChildren(path, true);
        System.out.println(childrens);

        //权限控制


    }

    @Override
    public void process(WatchedEvent watchedEvent) {
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
