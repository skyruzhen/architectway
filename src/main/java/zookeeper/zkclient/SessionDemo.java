package zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/1911:15
 */
public class SessionDemo {
    private final static String CONNECT_STRING = "192.168.134.128:2181,192.168.134.129:2181,192.168.134.130:2181,192.168.134.131:2181,";
    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(CONNECT_STRING, 10000);
        zkClient.createEphemeral("/zkClient2/node01/node02"); //不知道子节点
        List<String> children = zkClient.getChildren("/zkClient1");
        System.out.println(children);
    }
}
