package example.com.daggersample.data;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader( "X-App-Id", "c70a6f00-cf91-4756-9df5-47628850002b")
                .addHeader("X-App-Token", "3266b9f8-e246-4f79-bdf0-833929b1380c")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = chain.proceed(request);
        return response;
    }
}
