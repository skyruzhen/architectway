package design_pattern.proxy.jdk.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RzProxy {
    private static String line = "\r\n";

    public static Object newProxyInstance(RzClassLoader loader,
                                          Class<?>[] interfaces,
                                          RzInvocationHandler h) {
        //1. 生成源代码
        String proxySrc = generateSrc(interfaces[0]);

        //2. 将生成的源代码输出到磁盘,保存为.java文件
        String filePath = RzProxy.class.getResource("").getPath();
        try {
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.close();

            //3. 编译源代码, 并且生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null, null, null,javaFileObjects);
            task.call();
            manager.close();
            f.delete();
            //4. 将class文件中的内容,动态加载到JVM中来

            //5, 返回被代理后的代理对象
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(RzInvocationHandler.class);
            return c.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBufferWithLine src = new StringBufferWithLine();
        src.append("package design_pattern.proxy.jdk.custom;");
        src.append("import java.lang.reflect.Method;");
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{");
        src.append("RzInvocationHandler h;");
        src.append("public $Proxy0(RzInvocationHandler h){");
        src.append("this.h=h;");
        src.append("}");
        for (Method method :
                interfaces.getMethods()) {
            src.append("public " + method.getReturnType().getName() + " " + method.getName() + "(){");
            src.append("try{");
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});");
            src.append("this.h.invoke(this,m,null);");
            src.append("}catch(Throwable throwable){ throwable.printStackTrace();}");
            src.append("}");
        }
        src.append("}");
        return src.toString();
    }

}
