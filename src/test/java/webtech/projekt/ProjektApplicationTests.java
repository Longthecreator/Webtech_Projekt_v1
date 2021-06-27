package webtech.projekt;

import webtech.projekt.coinMarketCap_API.CmcApi;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProjektApplicationTests {

	@Autowired
	private CmcApi cmcApi;
	@Test
	void contextLoads() {
	}

	@Test
	void testCmcApiList() throws JSONException, IOException, InterruptedException {
		String firstName= cmcApi.getAllData().get(0).getName();

		assertEquals("Bitcoin", firstName);
	}
	//Tests für CmcApi auf https://www.baeldung.com/guide-to-jayway-jsonpath zu finden
}
