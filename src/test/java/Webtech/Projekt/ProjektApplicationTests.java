package Webtech.Projekt;

import Webtech.Projekt.CoinMarketCap_API.CmcApi;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ProjektApplicationTests {

	private CmcApi cmcApi;
	@Test
	void contextLoads() {
	}

	@Test
	void testResonse() throws JSONException, IOException, InterruptedException {
		cmcApi.getCoinData();
	}
	//Tests für CmcApi auf https://www.baeldung.com/guide-to-jayway-jsonpath zu finden
}
