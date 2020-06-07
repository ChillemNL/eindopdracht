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

		@Test //controleert of index terugkomt door de titel van de header op de pagina te zoeken
		public void indexTitelMoetGevondenWorden() throws Exception {
			assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
					String.class)).contains("ActiviteitenTip");
		}

		@Test //controleert of beheer_portaal terugkomt door een koptekst op de pagina te zoeken
		public void beheerPortaalTekstMoetGevondenWorden() throws Exception {
			assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/beheer_portaal",
					String.class)).contains("Voeg een nieuwe activiteit toe");
		}


}


