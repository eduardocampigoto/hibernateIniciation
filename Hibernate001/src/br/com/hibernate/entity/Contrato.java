package br.com.hibernate.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contrato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Pessoa contratante;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Pessoa contratado;
	@Temporal(TemporalType.DATE)
	private Date inicio_contrato;
	@Temporal(TemporalType.DATE)
	private Date fim_contrato;
	private String clausulas;
	@ManyToOne
	private Agencia agencia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Pessoa getContratante() {
		return contratante;
	}
	public void setContratante(Pessoa contratante) {
		this.contratante = contratante;
	}
	public Pessoa getContratado() {
		return contratado;
	}
	public void setContratado(Pessoa contratado) {
		this.contratado = contratado;
	}
	public Date getInicio_contrato() {
		return inicio_contrato;
	}
	public void setInicio_contrato(Date inicio_contrato) {
		this.inicio_contrato = inicio_contrato;
	}
	public Date getFim_contrato() {
		return fim_contrato;
	}
	public void setFim_contrato(Date fim_contrato) {
		this.fim_contrato = fim_contrato;
	}
	public String getClausulas() {
		return clausulas;
	}
	public void setClausulas(String clausulas) {
		this.clausulas = clausulas;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	

}
