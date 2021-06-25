package Webtech.Projekt;

import Webtech.Projekt.CoinMarketCap_API.CmcApi;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CmcApiTests {

    @Test
    @DisplayName("Tests if coin data list is correct")
    void testCmcApiList() throws JSONException, IOException, InterruptedException {
        CmcApi cmcApi = new CmcApi();
        cmcApi.getCoinData();
        String firstName= cmcApi.getAllData().get(0).getName();

        assertEquals("Bitcoin", firstName);
    }
}
