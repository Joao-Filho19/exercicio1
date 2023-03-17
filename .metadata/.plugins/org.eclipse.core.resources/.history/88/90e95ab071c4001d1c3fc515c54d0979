package uea.pagamentos_api.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uea.pagamentos_api.models.Lancamento;
import uea.pagamentos_api.services.LancamentoService;


@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;
	

	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Lancamento> criar( @RequestBody Lancamento lancamento) {
		Lancamento lancamentoSalva = lancamentoService.criar(lancamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(lancamentoSalva.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(lancamentoSalva);
	}

	@GetMapping(value = "/{codigo}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and hasAuthority('SCOPE_read')")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Long codigo) {
		Lancamento lancamento = lancamentoService.buscarPorCodigo(codigo);
		return lancamento != null ? ResponseEntity.ok().body(lancamento) : ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/{codigo}")
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Void> deletar(@PathVariable Long codigo) {
		lancamentoService.deletar(codigo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{codigo}")
	//@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_LANCAMENTO')")
	public ResponseEntity<Lancamento> atualizar(@PathVariable Long codigo, @RequestBody Lancamento lancamento) {
		Lancamento lancamentoSalvo = lancamentoService.atualizar(codigo, lancamento);
		return ResponseEntity.ok(lancamentoSalvo);
	}

}
