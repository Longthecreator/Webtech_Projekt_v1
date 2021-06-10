package Webtech.Projekt;

import Webtech.Projekt.CoinMarketCap_API.CmcApi;
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
	void testResonse(){
		cmcApi.requestMethodTwo();
	}

}
