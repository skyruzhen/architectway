package design_pattern.proxy.jdk.custom;

//1 继承失败
//2 使用包装类
public class StringBufferWithLine{

    private StringBuffer stringBuffer;
    private String line = "\r\n";  //换行符

    StringBufferWithLine() {
        stringBuffer = new StringBuffer(16);
    }

    public void append(Object o){
        stringBuffer.append(o).append(line);
    }

    public String toString() {
        return stringBuffer.toString();
    }
}
