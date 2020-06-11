package com.leergang.eindopdracht;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import com.leergang.eindopdracht.models.Categorie;
import com.leergang.eindopdracht.repositories.CategorieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


@ExtendWith(MockitoExtension.class)
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

	@Test //test class Categorie
	public void addCategorieTest(){
		Categorie categorie = new Categorie();
		categorie.setNaamCategorie("Test1");
		categorie.setBeschrijvingCategorie("Test1_omschrijving");
		assertEquals("Test1",categorie.getNaamCategorie());
		assertEquals("Test1_omschrijving",categorie.getBeschrijvingCategorie());
	}

	@Autowired
	private CategorieController categorieController;

	@Test //controleert of de api /categorie/all resultaat terug geeft.
	public void categories_test() {
		Iterable<Categorie> result = categorieController.getAllCategories();
		assertNotNull(result);
		assertNotNull(result.iterator().next());
	}


}


