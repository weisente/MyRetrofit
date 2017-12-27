package example.weisente.top.myretrofit.retrofit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import okhttp3.OkHttpClient;

/**
 * Created by san on 2017/12/27.
 */

public class Retrofit {
    //基本的参数
    final String baseUrl;
    final okhttp3.Call.Factory callFactory;

    public Retrofit(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.callFactory = builder.callFactory;
    }


    public <T> T create(Class<T> service){
        //动态代理接口
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if(method.getDeclaringClass() == Object.class){
                    return method.invoke(this,args);
                }
//                ServiceMethod serviceMethod = loadServiceMethod(method);
                return null;
            }
        });
    }

    private class Builder {
        String baseUrl;
        okhttp3.Call.Factory callFactory;

        public Builder baseUrl(String baseUrl){
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder client(okhttp3.Call.Factory callFactory){
            this.callFactory = callFactory;
            return this;
        }

        public Retrofit build() {
            if(callFactory == null){
                callFactory = new OkHttpClient();
            }
            return new Retrofit(this);
        }

    }
}
