package Webtech.Projekt.CoinMarketCap_API;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import okhttp3.OkHttpClient;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CmcApi {

    private static HttpURLConnection connection;
    final static String apiKey = "9e15cd91-22c8-4f39-b9a5-7050286a806a";
    final static String apiKeyHeader= "X-CMC_PRO_API_KEY";


    public String requestMethodTwo(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1")).header("X-CMC_PRO_API_KEY","9e15cd91-22c8-4f39-b9a5-7050286a806a").build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
        return String.valueOf(client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join());
    }

}