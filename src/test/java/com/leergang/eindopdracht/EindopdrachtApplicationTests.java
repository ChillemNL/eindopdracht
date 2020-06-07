package com.leergang.eindopdracht;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EindopdrachtApplicationTests {

		@LocalServerPort
		private int port;

		@Autowired
		private TestRestTemplate restTemplate;

		@Test //controleert of index.html terugkomt door de titel op de pagina te zoeken
		public void greetingShouldReturnDefaultMessage() throws Exception {
			assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
					String.class)).contains("ActiviteitenTip");
		}


}


