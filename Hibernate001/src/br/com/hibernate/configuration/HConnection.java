package br.com.hibernate.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HConnection  {
	private EntityManagerFactory conexao;
	
	private EntityManagerFactory conectar(){
		try{
			if(conexao != null && conexao.isOpen()){
				return conexao;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{}
		conexao = Persistence.createEntityManagerFactory("Agencia");
		return conexao;
	}
	
	
	protected void desconectar(){
		try{
			if(conexao != null && conexao.isOpen()){
				conexao.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{}
	}
	
	
	
	
	protected EntityManager getEntityManager(){
		 return conectar().createEntityManager();
	}
	
	protected Query getQuery(String hql){
		return this.getEntityManager().createQuery(hql);
	}
	
	
}
