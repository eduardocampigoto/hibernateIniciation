package br.com.hibernate.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import br.com.hibernate.entity.Agencia;
import br.com.hibernate.entity.Contrato;
import br.com.hibernate.entity.Pessoa;

public class MostraDados<T>{ 
	
	
	public void mostraValores(T o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		for (Method method : o.getClass().getMethods()){
			String ret = "";
			String methodName = method.getName();
			if(methodName.toLowerCase().contains("get") &&
				!methodName.equals("getClass") && 
				!methodName.equals("getInteger")){
				Object methodResp = method.invoke(o);
				
				if(methodResp instanceof String)
					ret = methodResp.toString();
				
				else if(methodResp instanceof Date)
					ret = new FormataData().objectToString(methodResp);
				
				else if(methodResp instanceof Pessoa)
					 new MostraDados<Pessoa>().mostraValores((Pessoa) methodResp);
				
				else if(methodResp instanceof Agencia)
					 new MostraDados<Agencia>().mostraValores((Agencia) methodResp);
				
				else if(methodResp instanceof Contrato)
					 new MostraDados<Contrato>().mostraValores((Contrato) methodResp);
				
				else if(methodResp instanceof Integer)
						ret = methodResp.toString();
				 
				if(!methodResp.getClass().isInstance(Object.class) && ret != null){
					System.out.println(" ----------------------------------------- ");
					System.out.println(" Classe : "+ o.getClass().getSimpleName());
					System.out.println(" ----------------------------------------- ");
					System.out.println(" Metodo : "+method.getName());
					System.out.println(" Retorno : "+ret+"\n \n");
				}
				
			}
		}
		
	}


}

