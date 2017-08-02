package senai.comjpa.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class JPAAbstract<T> extends JPAConnection{
	
	
	public abstract String getEntityName();
	
	//Junção do método prepareStatementGerandold, e inserts
		public void incluir(T o){
			EntityManager em = getEntityManager();
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			em.close();
		}
		
		@SuppressWarnings("unchecked")
		public T  buscarPorId(int id) {
			String entidade = getEntityName(); 
			String jpql = "Select c from "+entidade+" c where id="+id;
			Query query = super.getQuery(jpql);
			List<T> list = query.getResultList();
			for(T object: list){
				return object;
			}
			return null;
		}		

}
