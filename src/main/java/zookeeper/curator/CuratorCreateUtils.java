package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/1914:17
 */
public class CuratorCreateUtils {
    private final static String CONNECT_STRING = "192.168.134.128:2181,192.168.134.129:2181,192.168.134.130:2181,192.168.134.131:2181,";

    public static CuratorFramework getInstance() {
        //创建会话的了两种方式
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONNECT_STRING, 5000,5000, new ExponentialBackoffRetry(1000,3));
        curatorFramework.start();
        return curatorFramework;
    }
}
