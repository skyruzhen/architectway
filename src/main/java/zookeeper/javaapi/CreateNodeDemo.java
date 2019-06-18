package zookeeper.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/1817:32
 */
public class CreateNodeDemo {
    private final static String CONNECT_STRING="192.168.134.128:2181,192.168.134.129:2181,192.168.134.130:2181,192.168.134.131:2181,";
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_STRING, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                switch (watchedEvent.getState()){
                }
                System.out.println(watchedEvent.getType());
            }
        });
        System.out.println(zooKeeper.getState());

        String result = zooKeeper.create("/mic", "123".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zooKeeper.getData("/mic", true, stat);
        System.out.println("创建成功"+result);
    }
}
