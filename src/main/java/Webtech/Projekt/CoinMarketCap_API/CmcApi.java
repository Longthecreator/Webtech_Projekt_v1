package Webtech.Projekt.CoinMarketCap_API;

import Webtech.Projekt.Entities.CoinData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CmcApi {

    private static HttpURLConnection connection;
    final static String apiKey = "9e15cd91-22c8-4f39-b9a5-7050286a806a";
    final static String apiKeyHeader= "X-CMC_PRO_API_KEY";
    private List<CoinData> allData = new ArrayList<>();
    public List<CoinData> getAllData(){ return allData;};


    public String requestMethodTwo(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1"))
                .header("X-CMC_PRO_API_KEY","9e15cd91-22c8-4f39-b9a5-7050286a806a").build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
        return String.valueOf(client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join());
    }

    public String getCoinData() throws IOException, InterruptedException, JSONException {
        List<CoinData> newData = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1,2"))
                .header("X-CMC_PRO_API_KEY","9e15cd91-22c8-4f39-b9a5-7050286a806a").build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
        //Response handling
        HttpResponse<String> httpResponse=client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject objectAll = new JSONObject(httpResponse.body());
        //test
        List<Integer> idList = new ArrayList<Integer>();
        for(int i = 1; i <3; i++){
            idList.add(i);
        }
        JSONObject objectData = objectAll.getJSONObject("data");
        JSONObject objectSpecificData = new JSONObject(String.valueOf(objectData));
        for(Integer i : idList){
            JSONArray array1 =  objectSpecificData.getJSONArray(String.valueOf(i));
            for (int e = 0; e < array1.length(); e++) {
                JSONObject data = array1.getJSONObject(e);
                CoinData coinData = new CoinData();
                String coinName = data.getString("name");
//                double coinPrice = arr2.getJSONObject(i).getDouble("price");
                coinData.setName(coinName);
//                coinData.setCurrentPrice(coinPrice);
                allData.add(coinData);
            }
            System.out.println(allData);
        }
        this.allData =newData;

        return String.valueOf(client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join());
    }

}