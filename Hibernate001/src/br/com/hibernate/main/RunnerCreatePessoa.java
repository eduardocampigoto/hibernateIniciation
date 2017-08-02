package br.com.hibernate.main;

import br.com.hibernate.entity.Pessoa;
import br.com.hibernate.hdao.PessoaHDAO;
import br.com.hibernate.service.FormataData;

public class RunnerCreatePessoa {

	public static void executar() {

		Pessoa pessoa = new Pessoa();
		FormataData fmtData = new FormataData();
		pessoa.setNome("nome");
		pessoa.setNome_mae("nome da mae");
		pessoa.setNome_pai("nome do pai");
		pessoa.setCpf("cpf");
		pessoa.setRg("rg");
		pessoa.setData_nasc(fmtData.stringToDate("19/02/1988"));
		PessoaHDAO pessoaHDAO = new PessoaHDAO();
		pessoaHDAO.incluir(pessoa);

	}

}
