package design_pattern.proxy.jdk.custom;

import java.io.*;

public class RzClassLoader extends ClassLoader{

    private File baseDir;

    public RzClassLoader(){
        String baseDir = RzClassLoader.class.getResource("").getPath();
        this.baseDir = new File(baseDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = RzClassLoader.class.getPackage().getName()+"."+name;
        if(baseDir != null){
            File classFile = new File(baseDir, name.replace("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while((len = in.read(buff)) != -1){
                        out.write(buff, 0, len);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(null != in){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(null != out){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    classFile.delete();
                }

            }

        }
        return null;
    }
}
