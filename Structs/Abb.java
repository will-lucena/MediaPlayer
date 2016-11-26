package Structs;

import Users.Usuario;

public class Abb
{
	private NodeAbb raiz;
	
	public Abb()
	{
		this.raiz = new NodeAbb();
	}
	
	public NodeAbb getRaiz()
	{
		return raiz;
	}
	
	public NodeAbb buscar(Usuario user)
	{
		return this.buscar(this.raiz, user);
	}
	
	private NodeAbb buscar(NodeAbb node, Usuario user)
	{
		if (user.getId() == node.getChave())
		{
			return node;
		}
		
		if (user.getId() > node.getChave())
		{
			return buscar(node.getDireita(), user);
		}
		
		if (user.getId() < node.getChave())
		{
			return buscar(node.getEsquerda(), user);
		}
		
		return null;
	}
	
	public void inserir(Usuario user)
	{
		this.inserir(this.raiz, user);
	}
	
	private void inserir(NodeAbb node, Usuario user)
	{
		if (node == null)
		{
			node = new NodeAbb(user);
		}
		
		else if (user.getId() > node.getChave())
		{
			this.inserir(node.getDireita(), user);
		}
		
		else if (user.getId() < node.getChave())
		{
			this.inserir(node.getEsquerda(), user);
		}
	}
	
	/* terminar de implementar
	public void remover(Usuario user)
	{
		this.remover(this.raiz, user);
	}
	
	private NodeAbb remover(NodeAbb node, Usuario user)
	{
		if (user.getId() == node.getChave())
		{
			
		}
		
		if (user.getId() > node.getChave())
		{
			return this.remover(node.getDireita(), user);
		}
		
		if (user.getId() < node.getChave())
		{
			return this.remover(node.getEsquerda(), user);
		}
		
		return null;
	}
	
	private void removerCaso1(NodeAbb node)
	{
		if (node.getEsquerda() == null)
		{
			node = node.getDireita();
		}
		
		else if (node.getDireita() == null)
		{
			node = node.getEsquerda();
		}
		
		else
		{
			node = this.removerCaso2(node.getEsquerda());
		}
	}
	
	private NodeAbb removerCaso2(NodeAbb node)
	{
		if (node.getDireita() != null)
		{
			return node.getDireita();
		}
		
		return node;
	}
	/**/
}
