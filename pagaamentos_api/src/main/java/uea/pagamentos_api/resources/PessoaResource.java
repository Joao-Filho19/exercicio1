package uea.pagamentos_api.resources;

import java.net.URI;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uea.pagamentos_api.models.Pessoa;
import uea.pagamentos_api.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	@Autowired
	private PessoaService pessoaService;
	
	
	
	@PostMapping
	public ResponseEntity <Pessoa> criar(@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.criar(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(pessoaSalva.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
	public ResponseEntity<List> listar() {
		List pessoas = (List) pessoaService.listar();
		return ResponseEntity.ok().body(pessoas);
	}

	
	@DeleteMapping(value="/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		pessoaService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
	/*
	@PutMapping(value="/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @RequestBody Pessoa pessoa){
		Pessoa pessoa = pessoaService;
	}*/
	
}
