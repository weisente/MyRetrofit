package example.weisente.top.myretrofit.retrofit;

/**
 * Created by san on 2017/12/27.
 */

public interface ParameterHandler<T> {
    public void apply(RequestBuilder requestBuilder,T value);

    class Query<T> implements ParameterHandler<T>{
        private String key; // 保存 就是参数的 key = userName ,password
        public Query(String key){
            this.key = key;
        }

        @Override
        public void apply(RequestBuilder requestBuilder,T value) {
            // 添加到request中 // value -> String 要经过一个工厂
            requestBuilder.addQueryName(key,value.toString());
        }
    }
}
