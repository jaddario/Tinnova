package br.com.addario.cadastroveiculo.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.addario.cadastroveiculo.model.Veiculo;
import br.com.addario.cadastroveiculo.service.VeiculoService;

@AutoConfigureMockMvc
@SpringBootTest
class VeiculoControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private VeiculoService service;

	private static Veiculo veiculo;

	private static List<Veiculo> veiculos;
	
	@BeforeAll
	static void init() {
		veiculo = new Veiculo();
		veiculo.setId(1L);
		veiculo.setModelo("Monza");
		veiculo.setMarca("Fiat");
		veiculo.setDescricao("Monza Preto");
		veiculo.setAno(1995);
		veiculos = Arrays.asList(veiculo);
	}
	
	@Test
	void testaConsultarTodosOsVeiculos() throws Exception {
		given(service.getTodosOsVeiculos()).willReturn(veiculos);
		mvc.perform(get("/veiculos")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("[{'id': 1,'modelo': 'Monza','marca': 'Fiat', 'descricao':'Monza Preto', 'ano': 1995, 'vendido': false}]"));
	}
	
	
	@Test
	void testaCadastrarUmVeiculo() throws Exception {
		mvc.perform(post("/veiculos")
			.content(asJsonString(new Veiculo(2l, "Chevete", "Chevrolet", 1992, "Chevrolet Branco Duas portas")))
		    .contentType("application/json"))
			.andExpect(status().isOk());

	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
