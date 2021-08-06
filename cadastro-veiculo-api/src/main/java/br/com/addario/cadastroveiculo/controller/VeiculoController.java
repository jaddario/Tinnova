package br.com.addario.cadastroveiculo.controller;

import java.util.List;

import br.com.addario.cadastroveiculo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.cadastroveiculo.model.entity.VeiculoEntity;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService service;

	@GetMapping
	@ApiOperation(value = "Retorna todos os veículos na base", response = VeiculoEntity.class)
	public List<VeiculoEntity> getTodosOsVeiculos() {
		return service.getTodosOsVeiculos();
	}

//	@PostMapping
//	@ApiOperation(value = "Cadastra veículo na base", response = VeiculoEntity.class)
//	public ResponseEntity<VeiculoEntity> cadastraVeiculo(@RequestBody VeiculoEntity veiculo) {
//		VeiculoEntity veiculoSalvo = service.cadastraVeiculo(veiculo);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculoSalvo.getId())
//				.toUri();
//		return ResponseEntity.created(uri).build();
//	}

//	@DeleteMapping(path = "/{id}")
//	@ApiOperation(value = "Remove veículo da base", response = Void.class)
//	public void removeVeiculo(@PathVariable long id) {
//		service.removeVeiculo(id);
//	}
//
//	@GetMapping(path = "find/{id}")
//	@ApiOperation(value = "Retorna veículo pelo id", response = VeiculoEntity.class)
//	public ResponseEntity<VeiculoEntity> getVeiculoPeloId(@PathVariable long id) {
//		return service.getVeiculoPeloId(id).map(veiculo -> ResponseEntity.ok().body(veiculo))
//				.orElse(ResponseEntity.notFound().build());
//	}

//	@GetMapping(path = "find/pordecada/{decada}")
//	@ApiOperation(value = "Retorna número de veículos por década",
//		notes = "Dado uma década, retorna o número de veículos cujo o ano de fabricação esteja inserida nessa data. Ex.: 1990", response = Long.class)
//	public Long getVeiculosPorDecadaDeFabricacao(@PathVariable int decada) {
//		return service.getVeiculosPorDecadaDeFabricacao(decada);
//	}

//	@GetMapping(path = "find/porfabricante{fabricante}")
//	@ApiOperation(value = "Retorna número de veículos por fabricante")
//	public Long getVeiculosPorFabricante(@PathVariable String fabricante) {
//		return service.getVeiculosPorFabricante(fabricante);
//	}
//
//	@GetMapping(path = "find/naovendidos")
//	@ApiOperation(value = "Retorna número de veículos não vendidos")
//	public Long getVeiculosNaoVendidos() {
//		return service.getVeiculosNaoVendidos();
//	}
//
//	@GetMapping(path = "find/ultimasemana")
//	@ApiOperation(value = "Retorna número de veículos Registrados na última semana")
//	public List<VeiculoEntity> getVeiculosRegistradosDuranteSemana() {
//		Calendar calendar = new GregorianCalendar();
//		calendar.add(Calendar.DAY_OF_MONTH, -7);
//		Date primeiroDiaDaSemanaPassada = calendar.getTime();
//		return service.getVeiculosRegistradosDuranteAUltimaSemana(primeiroDiaDaSemanaPassada);
//	}
//
//	@PatchMapping(path = "/{id}")
//	@ApiOperation(value = "Atualiza dados do veículo", notes = "Atualiza qualquer dado do veículo")
//	public ResponseEntity<VeiculoEntity> atualizaVeiculo(@PathVariable("id") long id, @RequestBody VeiculoEntity veiculoUpdate) {
//		Optional<VeiculoEntity> veiculoOptional = service.getVeiculoPeloId(id);
//		if (!veiculoOptional.isPresent())
//			return ResponseEntity.notFound().build();
//
//		VeiculoEntity veiculo = veiculoOptional.get();
//		if (veiculoUpdate.getMarca() != null) {
//			veiculo.setMarca(veiculoUpdate.getMarca());
//		}
//		if (veiculoUpdate.getModelo() != null) {
//			veiculo.setModelo(veiculoUpdate.getModelo());
//		}
//		if (veiculoUpdate.getAno() != 0) {
//			veiculo.setAno(veiculoUpdate.getAno());
//		}
//		if (veiculoUpdate.getDescricao() != null) {
//			veiculo.setDescricao(veiculoUpdate.getDescricao());
//		}
//		if (veiculoUpdate.isVendido()) {
//			veiculo.setVendido(veiculoUpdate.isVendido());
//		}
//
//		veiculo.setUpdated(LocalDateTime.now());
//		service.cadastraVeiculo(veiculo);
//
//		return ResponseEntity.ok().build();
//	}

}
