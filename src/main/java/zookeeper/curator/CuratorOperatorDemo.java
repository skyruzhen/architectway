package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/1914:43
 */
public class CuratorOperatorDemo {
    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorCreateUtils.getInstance();
        System.out.println("连接成功");
        try {
            curatorFramework.create().forPath("/curator", "123".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
