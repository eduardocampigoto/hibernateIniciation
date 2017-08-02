package senai.comjpa.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAConnection {
	private EntityManagerFactory conexao;
		
	private EntityManagerFactory conectar(){
		try{
			if (conexao != null && conexao.isOpen()){
				return conexao;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{}
		//Aqui deve ser informado o nome do atributo name da tag <persistence-unit>
		conexao = Persistence.createEntityManagerFactory("SENAI");
		System.out.println("");
		return conexao;
		//EntityManager em= conexao.createEntityManager();
		
	}
	
	//método createStatement
	protected EntityManager getEntityManager(){
		return conectar().createEntityManager();
	}
	
	//método prepareStatement
	protected Query getQuery(String jpql){
		return this.getEntityManager().createQuery(jpql);
	}

	
	
	

}
