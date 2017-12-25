package example.weisente.top.myretrofit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by san on 2017/12/25.
 */

public class client {


    public static  void main(String[] args){
        System.out.println("测试");
        Proxy target = new Proxy();
        Method method = null;
        try {
            method =Proxy.class.getDeclaredMethod("run",Integer.class);
            method.setAccessible(true);
            method.invoke(target,44);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
