package uea.pagamentos_api.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.NotBlank;


@Entity
public class Consumidor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull(message = "Tipo é obrigatório")
	private String nome;

	@NotNull(message = "Tipo é obrigatório")
	private LocalDate dataNascimento;
	
	@NotNull(message = "Tipo é obrigatório")
	private String cpf;
	
	@NotNull(message = "Tipo é obrigatório")

	@JsonIgnoreProperties("consumidor")
	@OneToMany(mappedBy = "consumidor")
	private List<Refeicao> refeicao = new ArrayList<>();
	

	public Consumidor() {
		super();
	}

	public Consumidor(Long codigo, String nome, LocalDate dataNascimento, String cpf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Refeicao> getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(List<Refeicao> refeicao) {
		this.refeicao = refeicao;
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
		Consumidor other = (Consumidor) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
