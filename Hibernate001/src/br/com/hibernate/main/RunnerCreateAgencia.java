package br.com.hibernate.main;

import br.com.hibernate.entity.Agencia;
import br.com.hibernate.entity.Contrato;
import br.com.hibernate.hdao.AgenciaHDAO;

public class RunnerCreateAgencia {
	
	public static void executar(){
		Agencia agencia = new Agencia();
		AgenciaHDAO agenciaHDAO  = new AgenciaHDAO();
		Contrato contrato = null;
	try {
		agencia.setResponsavel("teste");
		agencia.setDescricao("testeAdd");
		contrato = (Contrato) agenciaHDAO.buscarEntidades(Contrato.class, 2);
		if(contrato != null)
			agencia.addContrato(contrato);	
		
		agenciaHDAO.incluir(agencia);
	} catch (Exception e) {
		e.printStackTrace();
	}			
	

	}
	
	

	
}

