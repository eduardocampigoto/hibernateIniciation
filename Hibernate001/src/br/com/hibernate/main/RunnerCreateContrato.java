package br.com.hibernate.main;

import br.com.hibernate.entity.Agencia;
import br.com.hibernate.entity.Contrato;
import br.com.hibernate.entity.Pessoa;
import br.com.hibernate.hdao.ContratoHDAO;
import br.com.hibernate.service.FormataData;

public class RunnerCreateContrato {

	public static void executar() {
		FormataData fmtData = new FormataData();
		Agencia agencia = null;
		Pessoa contratante = null;
		Pessoa contratado = null;

		try {

			ContratoHDAO contratoHDAO = new ContratoHDAO();
			Contrato contrato = new Contrato();
			contrato.setInicio_contrato(fmtData.stringToDate("10/01/2011"));
			contrato.setFim_contrato(fmtData.stringToDate("10/10/2020"));
			contrato.setClausulas("asdsada  alterado 5555");			
			
			agencia = (Agencia) contratoHDAO.buscarEntidades(Agencia.class, 1);
			if(agencia != null)
				contrato.setAgencia(agencia);

			contratante = (Pessoa) contratoHDAO.buscarEntidades(Pessoa.class, 1);
			if(contratante != null)
				contrato.setContratante(contratante);
			
			contratado = (Pessoa) contratoHDAO.buscarEntidades(Pessoa.class, 2);
			if(contratado != null)
				contrato.setContratado(contratado);			
			
			contratoHDAO.incluir(contrato);
			contratoHDAO.verificaEM();


					
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*public static Agencia buscarAgencia() {
		AgenciaHDAO agenciaHDAO = new AgenciaHDAO();
		Agencia agencia = null;
		List<Agencia> agenciaL = agenciaHDAO.buscar("descricao", "like",
				"testeAdd");
		if (agenciaL.listIterator().hasNext())
			;
		agencia = agenciaL.get(0);
		return agencia;
	}*/
}
