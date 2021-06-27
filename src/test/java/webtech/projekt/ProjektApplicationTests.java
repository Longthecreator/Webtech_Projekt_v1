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


	@Test
	void contextLoads() {
	}

	//Tests für CmcApi auf https://www.baeldung.com/guide-to-jayway-jsonpath zu finden
}
