package example.weisente.top.myretrofit.retrofit;

import okhttp3.HttpUrl;
import okhttp3.Request;

/**
 * Created by san on 2017/12/27.
 */

public class RequestBuilder {


    ParameterHandler<Object>[] parameterHandlers;
    Object[] args;
    HttpUrl.Builder httpUrl;

    public RequestBuilder(String baseUrl, String relativeUrl, String httpMethod, ParameterHandler<?>[] parameterHandlers, Object[] args){
        this.parameterHandlers = (ParameterHandler<Object>[]) parameterHandlers;
        this.args = args;
        //
        httpUrl = HttpUrl.parse(baseUrl+relativeUrl).newBuilder();
    }
    public Request build(){
        //看一下参数的个数
        int count = args.length;
        for (int i=0;i < count;i++){
            parameterHandlers[i].apply(this,args[i]);
        }
        Request request = new Request.Builder().url(httpUrl.build()).build();
        return request;
    }

    public void addQueryName(String key, String value) {
        // userName = Darren&password = 940223
        httpUrl.addQueryParameter(key,value);
    }
}
