package design_pattern.prototype.simple;

import java.util.ArrayList;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/5/20 002014:21
 */
public class Prototype implements Cloneable{
    private ArrayList list = new ArrayList();
    protected Prototype clone(){
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
            prototype.list = (ArrayList) list.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
