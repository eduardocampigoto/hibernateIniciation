package br.com.hibernate.main;


public class RunnerCreateAll {
	
	public static void executar(){
		RunnerCreatePessoa.executar();
		RunnerCreateAgencia.executar();
		RunnerCreateContrato.executar();

	}
}
