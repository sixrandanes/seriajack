package it.textereglementaire;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.seriajack.Application;
import com.seriajack.textereglementaire.TexteReglementaireController;
import com.seriajack.textereglementaire.TexteType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TexteReglementaireControllerTestIT {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void shouldReturnAllTextesReglementaire() throws Exception {
		mockMvc.perform(get("https://localhost/api/texte/list")).andExpect(status().isOk())
				.andExpect(handler().method(TexteReglementaireController.class.getMethod("findAllTexteReglementaire")))
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].type", equalTo(TexteType.ARRETE.toString())))
				.andExpect(jsonPath("$[0].numero", equalTo("T1")))
				.andExpect(jsonPath("$[0].intitule", equalTo("Texte 1")))
				// DATE FORMAT TO TEST IS WRONG : dateCreation without annotation J@sonFormat(pattern="")
				.andExpect(jsonPath("$[0].dateCreation", equalTo("19/10/2015")));
	}

}
