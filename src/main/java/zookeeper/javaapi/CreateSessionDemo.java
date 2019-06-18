package zookeeper.javaapi;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/1817:05
 */
public class CreateSessionDemo {
    private final static String CONNECT_STRING="192.168.134.128:2181,192.168.134.129:2181,192.168.134.130:2181,192.168.134.131:2181,";
    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_STRING, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
        System.out.println(zooKeeper.getState());
    }
}
