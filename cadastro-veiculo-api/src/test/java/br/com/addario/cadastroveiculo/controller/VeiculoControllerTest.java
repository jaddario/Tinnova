package br.com.addario.cadastroveiculo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import br.com.addario.cadastroveiculo.service.VeiculoService;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;

@AutoConfigureMockMvc
@SpringBootTest
@Disabled
class VeiculoControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private VeiculoService service;

	private static VeiculoEntity veiculo;

	private static List<VeiculoEntity> veiculos;

//	@BeforeAll
//	static void init() {
//		veiculo = new VeiculoEntity(1L, "Monza", "Fiat", 1995, "Monza Preto");
//		veiculos = Arrays.asList(veiculo);
//	}
//
//	@Test
//	void testaConsultarTodosOsVeiculos() throws Exception {
//		given(service.getTodosOsVeiculos()).willReturn(veiculos);
//		mvc.perform(get("/veiculos")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andExpect(content().json(
//						"[{'id': 1,'modelo': 'Monza','marca': 'Fiat', 'descricao':'Monza Preto', 'ano': 1995, 'vendido': false}]"));
//	}
//
//	@Test
//	void testaCadastrarUmVeiculo() throws Exception {
//		mvc.perform(post("/veiculos")
//				.content(asJsonString(new VeiculoEntity(2l, "Chevete", "Chevrolet", 1992, "Chevrolet Branco Duas portas")))
//				.contentType("application/json")).andExpect(status().isOk());
//
//	}
//
//	@Test
//	void testaRemoverVeiculo() throws Exception {
//		mvc.perform(delete("/veiculos/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//	}
//
//
//	public static String asJsonString(final Object obj) {
//		try {
//			return new ObjectMapper().writeValueAsString(obj);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
}
