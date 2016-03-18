package br.com.hbrayres.angular.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2435284590575632975L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private String logradouro;

	@Column(nullable = false)
	private Long cep;

	@Column(length = 50, nullable = false)
	private String bairro;

	@Column(length = 100, nullable = false)
	private String cidade;

	@Column(length = 2, nullable = false)
	private String estado;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (logradouro != null && !logradouro.trim().isEmpty())
			result += "logradouro: " + logradouro;
		if (cep != null)
			result += ", cep: " + cep;
		if (bairro != null && !bairro.trim().isEmpty())
			result += ", bairro: " + bairro;
		if (cidade != null && !cidade.trim().isEmpty())
			result += ", cidade: " + cidade;
		if (estado != null && !estado.trim().isEmpty())
			result += ", estado: " + estado;
		return result;
	}
}