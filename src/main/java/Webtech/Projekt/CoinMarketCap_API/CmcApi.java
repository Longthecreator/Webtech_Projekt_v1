package Webtech.Projekt.CoinMarketCap_API;

import Webtech.Projekt.Entities.CoinData;
import Webtech.Projekt.Entities.Product;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.JsonContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CmcApi {

    final static String apiKey = "9e15cd91-22c8-4f39-b9a5-7050286a806a";
    final static String apiKeyHeader= "X-CMC_PRO_API_KEY";
    private List<CoinData> allData = new ArrayList<>();
    public List<CoinData> getAllData(){ return allData;};

    @PostConstruct
    //.@Scheduled(cron = "*/5 * * * * *")
    public void getCoinData() throws IOException, InterruptedException, JSONException {
        List<CoinData> newData = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1,2,3"))
                .header("X-CMC_PRO_API_KEY","9e15cd91-22c8-4f39-b9a5-7050286a806a").build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
                .join();
        //Response handling
        HttpResponse<String> httpResponse=client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject objectAll = new JSONObject(httpResponse.body());

        DocumentContext jsonResponse = JsonPath.parse(httpResponse.body());
        List<Integer> idList = new ArrayList<Integer>();
        for(int i = 1; i <4; i++){
            idList.add(i);
        }
        for(Integer id : idList){
            CoinData coinData = new CoinData();
            coinData.setName(jsonResponse.read("$['data']['"+id+"']['name']\""));
            coinData.setCurrentPrice(jsonResponse.read("$['data']['"+id+"']['quote']['USD']['price']"));
            newData.add(coinData);
        }
        for(CoinData cd : allData){
            System.out.println(cd.getName());
            System.out.println(cd.getCurrentPrice());
        }
        System.out.println("-----------------------------------------------------");

        this.allData =newData;

    }

}