package zookeeper.master;

import java.io.Serializable;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/1916:37
 */
public class UserCenter implements Serializable {
    private static final long serialVersionUID = 792683485180872288L;
    private int rz_id;
    private String rz_name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getRz_id() {
        return rz_id;
    }

    public void setRz_id(int rz_id) {
        this.rz_id = rz_id;
    }

    public String getRz_name() {
        return rz_name;
    }

    public void setRz_name(String rz_name) {
        this.rz_name = rz_name;
    }
}
