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
	
	//Junção do método prepareStatementGerandold, e inserts
	public void incluir(Object o){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	

}
