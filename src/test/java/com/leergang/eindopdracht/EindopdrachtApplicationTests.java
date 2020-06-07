package com.leergang.eindopdracht;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.leergang.eindopdracht.models.Activiteit;
import com.leergang.eindopdracht.models.Categorie;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

	@Autowired
	private CategorieController categorieController;

	@Test //controleert of de api /categorie/all resultaat terug geeft.
	public void categories_test() {
		Iterable<Categorie> result = categorieController.getAllCategories();
		assertNotNull(result);
		assertNotNull(result.iterator().next());
	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	List<String> mockedList;

	@Test
	public void whenUseMockAnnotation_thenMockIsInjected() {
		mockedList.add("one");
		Mockito.verify(mockedList).add("one");
		assertEquals(0, mockedList.size());

		Mockito.when(mockedList.size()).thenReturn(100);
		assertEquals(100, mockedList.size());
	}

}


