package Structs;

import Users.Usuario;
import Users.UsuarioAdm;

public class NodeAbb
{
	private Usuario info;
	private int chave;
	private NodeAbb esquerda;
	private NodeAbb direita;
	
	protected NodeAbb()
	{
		this.info = new UsuarioAdm();
		this.chave = this.info.getId();
		this.esquerda = null;
		this.direita = null;
	}
	
	public NodeAbb(Usuario user)
	{
		this.info = user;
		this.chave = user.getId();
		this.esquerda = null;
		this.direita = null;
	}
	
	public Usuario getInfo()
	{
		return this.info;
	}
	
	public int getChave()
	{
		return this.chave;
	}
	
	public NodeAbb getEsquerda()
	{
		return esquerda;
	}
	
	public void setEsquerda(NodeAbb esquerda)
	{
		this.esquerda = esquerda;
	}
	
	public NodeAbb getDireita()
	{
		return direita;
	}
	
	public void setDireita(NodeAbb direita)
	{
		this.direita = direita;
	}
}
