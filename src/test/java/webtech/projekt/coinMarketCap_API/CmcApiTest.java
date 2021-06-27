package webtech.projekt.coinMarketCap_API;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import webtech.projekt.entities.CoinData;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@EnableScheduling
class CmcApiTest {

//    @Autowired
//    private CmcApi cmcApi;

    @Test
    @DisplayName("Tests if coin data list is correct")
    void testCmcApiList() throws IOException, InterruptedException {
        CmcApi cmcApi = new CmcApi();
        cmcApi.getCoinData();
        Thread.sleep(10000);
        List<CoinData> data = cmcApi.getAllData();

        assertEquals("Bitcoin", data.get(0).getName());
    }
}