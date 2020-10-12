package br.com.addario.cadastroveiculo.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.cadastroveiculo.model.Veiculo;
import br.com.addario.cadastroveiculo.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService service;

	@GetMapping
	public List<Veiculo> getTodosOsVeiculos() {
		return service.getTodosOsVeiculos();
	}

	@PostMapping
	public void cadastraVeiculo(@RequestBody Veiculo veiculo) {
		service.cadastraVeiculo(veiculo);
	}

	@DeleteMapping(path = "/{id}")
	public void removeVeiculo(@PathVariable long id) {
		service.removeVeiculo(id);
	}

	@GetMapping(path = "find/naovendidos")
	public Long getVeiculosNaoVendidos() {
		return service.getVeiculosNaoVendidos();
	}

	@GetMapping(path = "find/{decada}")
	public Long getVeiculosPorDecadaDeFabricacao(@PathVariable int decada) {
		return service.getVeiculosPorDecadaDeFabricacao(decada);
	}

	@GetMapping(path = "/find")
	public Long getVeiculosPorFabricante(@QueryParam("fabricante") String fabricante) {
		return service.getVeiculosPorFabricante(fabricante);
	}

	@GetMapping(path = "/find/ultimasemana")
	public List<Veiculo> getVeiculosRegistradosDuranteSemana() {
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		Date primeiroDiaDaSemanaPassada = calendar.getTime();
		return service.getVeiculosRegistradosDuranteAUltimaSemana(primeiroDiaDaSemanaPassada);
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<Veiculo> atualizaVeiculo(@PathVariable("id") long id, @RequestBody Veiculo veiculoUpdate) {
		Optional<Veiculo> veiculoOptional = service.findById(id);
		if (!veiculoOptional.isPresent())
			return ResponseEntity.notFound().build();

		Veiculo veiculo = veiculoOptional.get();
		if (veiculoUpdate.getMarca() != null) {
			veiculo.setMarca(veiculoUpdate.getMarca());
		}
		if (veiculoUpdate.getModelo() != null) {
			veiculo.setModelo(veiculoUpdate.getModelo());
		}
		if (veiculoUpdate.getAno() != 0) {
			veiculo.setAno(veiculoUpdate.getAno());
		}
		if (veiculoUpdate.getDescricao() != null) {
			veiculo.setDescricao(veiculoUpdate.getDescricao());
		}
		if (veiculoUpdate.isVendido()) {
			veiculo.setVendido(veiculoUpdate.isVendido());
		}

		veiculo.setUpdated(new Date());
		service.cadastraVeiculo(veiculo);

		return ResponseEntity.ok().build();
	}

}
