package uea.pagamentos_api.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import uea.pagamentos_api.models.enums.TipoRefeicao;


@Entity
public class Refeicao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull(message = "Tipo é obrigatório")
	private LocalDate dataConsumo;
	
	@NotNull(message = "Tipo é obrigatório")
	private TipoRefeicao tipo;
	

	@ManyToOne
	@JoinColumn(name="consumidor_id")
	private Consumidor consumidor;

	public Refeicao() {
		super();
	}

	public Refeicao(Long codigo, @NotNull(message = "Tipo é obrigatório") LocalDate dataConsumo,
			Consumidor consumidor) {
		super();
		this.codigo = codigo;
		this.dataConsumo = dataConsumo;
		this.consumidor = consumidor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataConsumo() {
		return dataConsumo;
	}

	public void setDataConsumo(LocalDate dataConsumo) {
		this.dataConsumo = dataConsumo;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}
	

	public TipoRefeicao getTipo() {
		return tipo;
	}

	public void setTipo(TipoRefeicao tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refeicao other = (Refeicao) obj;
		return Objects.equals(codigo, other.codigo);
	}

	
}
