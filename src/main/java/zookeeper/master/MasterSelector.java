package zookeeper.master;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/1916:45
 */
public class MasterSelector {
    private ZkClient zkClient;
    private final static String MASTER_PATH = "/master"; //需要争抢的节点
    private IZkDataListener dataListener;
    private UserCenter server; //其他服务器
    private UserCenter master; //master节点

    public MasterSelector(UserCenter server) {
        this.server = server;
        this.dataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                //如果节点被删除，发起选主操作
            }
        };

    }
    public void start(){
        //开始选举
    }
    public void stop(){
        //停止
    }

    //具体选master的
    private void chooseMaster(){

    }
}
