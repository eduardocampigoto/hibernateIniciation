package senai.comjpa.dao.abstraction;

import senai.comjpa.dao.jpa.ClienteJPADAO;
import senai.comjpa.dao.jpa.JPAConnection;
import senai.comjpa.pojo.Cidade;
import senai.comjpa.pojo.Cliente;
import senai.comjpa.pojo.Estado;

public class RunnerJPA {
	
	public static void main(String[] args){
		
		Estado estado = new Estado();
		estado.setId(1); 
		estado.setNome("Santa Catarina");
		estado.setUf("SC");
	
		Cidade cidade = new Cidade();
		cidade.setId(1);
		cidade.setNome("Joinville");
		cidade.setEstado(estado);
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome("Eduardo");
		cliente.setCidade(cidade);
		
		JPAConnection jpa = new JPAConnection();
		ClienteJPADAO clienteDAO = new ClienteJPADAO();
		clienteDAO.incluirCliente(cliente);
		
		System.out.println("Cliente com ID "+cliente.getId()+" inserido");
	
	}

}
