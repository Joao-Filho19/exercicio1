package uea.pagamentos_api.services;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import uea.pagamentos_api.models.Refeicao;
import uea.pagamentos_api.repositories.RefeicaoRepository;
@Service
public class RefeicaoService {
	
	@Autowired
	private RefeicaoRepository refeicaoRepository;
	
	public Refeicao criar(Refeicao refeicao) {
		return refeicaoRepository.save(refeicao);
	}
	
	/*public Page<Refeicao> pesquisar(RefeicaoFilter refeicaoFilter, Pageable pageable) {
		return refeicaoRepository.filtrar(refeicaoFilter, pageable);
	}*/
	
	public List<Refeicao> listar(){
		return refeicaoRepository.findAll();
	}
	
	public Refeicao buscarPorCodigo(Long codigo) {
		Refeicao refeicao = refeicaoRepository.findById(codigo).orElseThrow();
		return refeicao;
	}
	
	public void excluir(Long codigo) {
		refeicaoRepository.deleteById(codigo);
	}

	/*public Refeicao atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Refeicao refeicaoSalva = refeicaoRepository.findById(codigo).orElseThrow();
		refeicaoSalva.setAtivo(ativo);
		return refeicaoRepository.save(refeicaoSalva);
	}*/

	public Refeicao atualizar(Long codigo, Refeicao refeicao) {
		Refeicao refeicaoSalva = refeicaoRepository.
				findById(codigo).orElseThrow();
		BeanUtils.copyProperties(refeicao, refeicaoSalva, "codigo");
		return refeicaoRepository.save(refeicaoSalva);
	}
	
}