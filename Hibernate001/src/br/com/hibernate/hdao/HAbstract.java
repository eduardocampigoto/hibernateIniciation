package br.com.hibernate.hdao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.configuration.HConnection;

public abstract class HAbstract<T> extends HConnection {
	private EntityManager em;
	
	public HAbstract(){
		em = getEntityManager();
	}
	
	public void incluir(T entity){
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}
	
	public void verificaEM(){
		if(em.isOpen())
			System.out.println("O EM está aberto!");
		else
			System.out.println("O EM está fechado!");
	}

	public void alterar(T o){
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public void excluir(int id){
		ParameterizedType superclass = (ParameterizedType)getClass().getGenericSuperclass();
		Class<T> classe = (Class<T>)superclass.getActualTypeArguments()[0];
		T o = em.find(classe, id);
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Buscar entidade passando nome da coluna e valor para busca
	 * 
	 *  @param
	 *  	campo - coluna para fazer a busca
	 *  
	 *  @param 
	 *  	valor - valor da consulta
	 * **/
	@SuppressWarnings("unchecked")
	public List<T> buscar(String campo, String operacao,String valor){
		try{
			String abreVal = " ";
			String fechaVal = " ";
			if(operacao.toLowerCase() == "like"){
				abreVal = "'%";
				fechaVal = "%'";
			}
			String queryStr = "SELECT e FROM "+getEntityName()+" e WHERE "
							+campo+" "+operacao+" "+abreVal+valor+fechaVal;
			Query query = super.getQuery(queryStr);
			List<T> list = query.getResultList();
			desconectar();
			return list;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public Object buscarEntidades(Class<?> classe, Integer primaryK){
		try{
			em.getTransaction().begin();
			Object obj  =  (Object) em.find(classe, primaryK);
			em.getTransaction().commit();
			return obj;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public String getEntityName() {
		ParameterizedType superclass = (ParameterizedType)getClass().getGenericSuperclass();
		Class<T> classe = (Class<T>)superclass.getActualTypeArguments()[0];		
		return classe.getSimpleName(); 
	}


}






