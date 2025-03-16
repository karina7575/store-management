import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        createListInfo(client);
        changeShopStatus(client);
    }

    public static String checkSeven(OkHttpClient client) throws IOException {
        Request request1 = new Request.Builder().get().url("http://localhost:8081/application/status").build();
        String responseBody1= client.newCall(request1).execute().body().string();
        return responseBody1;
    }

    public static String checkNine(OkHttpClient client) throws IOException {
        Request request2 = new Request.Builder().get().url("http://localhost:8082/application/status").build();
        String responseBody2 = client.newCall(request2).execute().body().string();
        return responseBody2;
    }

    public static List<String> createListInfo(OkHttpClient client) throws IOException {
        List<String> infoList = new ArrayList<>();
        infoList.add(checkSeven(client));
        infoList.add(checkNine(client));
        return infoList;
    }

    public static void changeShopStatus(OkHttpClient client) throws IOException {
        byte[] bytes = "{\"name\": \"хлеб\", \"new_price\": \"400\"}".getBytes(StandardCharsets.UTF_8);
        Request request = new Request.Builder()
                .patch(RequestBody.create(bytes))
                .url("http://localhost:8081/shop/good")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        if(response.isSuccessful()){
            System.out.println("изменили цену хлеба");
        }

    }
}
