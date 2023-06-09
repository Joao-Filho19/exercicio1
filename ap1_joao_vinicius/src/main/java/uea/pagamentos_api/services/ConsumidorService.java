package uea.pagamentos_api.services;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import uea.pagamentos_api.models.Consumidor;
import uea.pagamentos_api.repositories.ConsumidorRepository;
@Service
public class ConsumidorService {
	
	@Autowired
	private ConsumidorRepository consumidorRepository;
	
	public Consumidor criar(Consumidor consumidor) {
		return consumidorRepository.save(consumidor);
	}
	
	/*public Page<Consumidor> pesquisar(ConsumidorFilter consumidorFilter, Pageable pageable) {
		return consumidorRepository.filtrar(consumidorFilter, pageable);
	}*/
	
	public List<Consumidor> listar(){
		return consumidorRepository.findAll();
	}
	
	public Consumidor buscarPorCodigo(Long codigo) {
		Consumidor consumidor = consumidorRepository.findById(codigo).orElseThrow();
		return consumidor;
	}
	
	public void excluir(Long codigo) {
		consumidorRepository.deleteById(codigo);
	}

	/*public Consumidor atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Consumidor consumidorSalva = consumidorRepository.findById(codigo).orElseThrow();
		consumidorSalva.setAtivo(ativo);
		return consumidorRepository.save(consumidorSalva);
	}*/

	public Consumidor atualizar(Long codigo, Consumidor consumidor) {
		Consumidor consumidorSalva = consumidorRepository.
				findById(codigo).orElseThrow();
		BeanUtils.copyProperties(consumidor, consumidorSalva, "codigo");
		return consumidorRepository.save(consumidorSalva);
	}
	
}