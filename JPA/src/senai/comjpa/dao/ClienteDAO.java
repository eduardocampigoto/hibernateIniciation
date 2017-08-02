package senai.comjpa.dao;

import senai.comjpa.pojo.Cliente;

public interface ClienteDAO {
	public int incluirCliente(Cliente cliente);
	public Cliente buscarPorId(int id);
}
