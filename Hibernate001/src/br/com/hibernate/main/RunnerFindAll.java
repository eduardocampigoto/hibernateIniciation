package br.com.hibernate.main;

import br.com.hibernate.entity.Agencia;
import br.com.hibernate.entity.Contrato;
import br.com.hibernate.entity.Pessoa;
import br.com.hibernate.hdao.AgenciaHDAO;
import br.com.hibernate.hdao.ContratoHDAO;
import br.com.hibernate.hdao.PessoaHDAO;
import br.com.hibernate.service.MostraDados;

public class RunnerFindAll {
	
	public static void executar(){
		
		
	try {
		
		Pessoa pessoa = (Pessoa) new PessoaHDAO().buscar("nome", "like", "nome").get(0);		
		Contrato contrato = (Contrato) new ContratoHDAO().buscar("fim_contrato", "like", "2020").get(0);		
		Agencia agencia = new AgenciaHDAO().buscar("descricao", "like", "teste").get(0);
		System.out.println("\n \n  \n ============================ \n \n \n");
		
		
		new MostraDados<Pessoa>().mostraValores(pessoa);
		new MostraDados<Agencia>().mostraValores(agencia);		
		new MostraDados<Contrato>().mostraValores(contrato);
		
		

		
	} catch (Exception e) {
		e.printStackTrace();
	}			
	

	}
}

