package Webtech.Projekt.CoinMarketCap_API;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import okhttp3.OkHttpClient;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CmcApi {

    private static HttpURLConnection connection;
    final static String apiKey = "9e15cd91-22c8-4f39-b9a5-7050286a806a";
    final static String apiKeyHeader= "X-CMC_PRO_API_KEY";
    //https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1

    public String testRequestMethodOne(){

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        String response="";
        try {
           URL url = new URL("https://www.ecb.europa.eu/stats/policy_and_exchange_rates/euro_reference_exchange_rates/html/jpy.xml");
           connection = (HttpURLConnection) url.openConnection();

           //Request Setup.
            //connection.setRequestProperty("X-CMC_PRO_API_KEY", apiKey);
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            int statusCode = connection.getResponseCode();

            if(statusCode>299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }
            else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
            response = responseContent.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            connection.disconnect();
        }
        return response;
    }

    //Methode 2

    public String requestMethodTwo(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.ecb.europa.eu/stats/policy_and_exchange_rates/euro_reference_exchange_rates/html/jpy.xml")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
        return String.valueOf(client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join());
    }

    public void requestMethodThree(){
        String response = "nichts";
        try {
            URL url = new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            String apiKey = "9e15cd91-22c8-4f39-b9a5-7050286a806a";
            connection.setRequestProperty("X-CMC_PRO_API_KEY", apiKey);
            System.out.println(connection.getResponseCode());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void requestMethodFour() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = (HttpResponse<String>) Unirest.get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1")
                .header("X-CMC_PRO_API_KEY", "9e15cd91-22c8-4f39-b9a5-7050286a806a").asString();
        System.out.println(response);
    }
}