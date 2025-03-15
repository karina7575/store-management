import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request1 = new Request.Builder().get().url("http://localhost:8082/application/status").build();
        String responseBody1 = client.newCall(request1).execute().body().string();
        System.out.println(responseBody1);

        Request request2 = new Request.Builder().get().url("http://localhost:8081/application/status").build();
        String responseBody2 = client.newCall(request2).execute().body().string();
        System.out.println(responseBody2);



    }
}
