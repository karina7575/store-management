import okhttp3.OkHttpClient;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        ShopManagementControllerClient service = new ShopManagementControllerClient();
        OkHttpClient client = new OkHttpClient();
        service.createListInfo(client);
        service.changeShopSevenStatus(client);
        service.changeShopNineStatus(client);
    }

}
