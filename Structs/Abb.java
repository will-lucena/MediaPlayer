package Structs;

import Users.Usuario;

public class Abb
{
	private NodeAbb raiz;

	public Abb()
	{
		this.raiz = null;
	}

	public NodeAbb getRaiz()
	{
		return this.raiz;
	}

	public boolean buscar(Usuario user)
	{
		return this.buscar(this.raiz, user);
	}

	private boolean buscar(NodeAbb node, Usuario user)
	{
		if (node == null)
		{
			return false;
		}
		
		if (user.getId() == node.getChave())
		{
			return true;
		}

		if (user.getId() > node.getChave())
		{
			return buscar(node.getDireita(), user);
		}

		if (user.getId() < node.getChave())
		{
			return buscar(node.getEsquerda(), user);
		}
		
		return false;
	}

	public void inserir(Usuario user)
	{
		if (this.raiz == null)
		{
			this.raiz = new NodeAbb();
			this.raiz.setInfo(user);
			this.raiz.setChave(user.getId());
		}
		else
		{
			inserir(this.raiz, user);			
		}
	}

	private NodeAbb inserir(NodeAbb node, Usuario user)
	{
		if (node == null)
		{
			node = new NodeAbb(user);
			return node;
		}

		else if (user.getId() > node.getChave())
		{
			node.setDireita(this.inserir(node.getDireita(), user));
		}

		else if (user.getId() < node.getChave())
		{
			node.setEsquerda(this.inserir(node.getEsquerda(), user));
		}

		return node;
	}

	// * terminar de implementar
	public void remover(Usuario user)
	{
		this.raiz = this.remover(this.raiz, user);
	}

	private NodeAbb remover(NodeAbb node, Usuario user)
	{
		if (user.getId() == node.getChave())
		{
			node = this.removerCaso1(node);
			return node;
		}

		else if (user.getId() > node.getChave())
		{
			node.setDireita(this.remover(node.getDireita(), user));
		}

		else if (user.getId() < node.getChave())
		{
			node.setEsquerda(this.remover(node.getEsquerda(), user));
		}
		
		return node;
	}

	private NodeAbb removerCaso1(NodeAbb node)
	{
		if (node.getEsquerda() == null)
		{
			return node = node.getDireita();
		}

		else if (node.getDireita() == null)
		{
			return node = node.getEsquerda();
		}

		else
		{
			
			return removerCaso2(node);
		}
	}

	private NodeAbb removerCaso2(NodeAbb node)
	{
		NodeAbb sucessor = buscarSucessor(node.getEsquerda());
		remover(sucessor.getInfo());
		node.setChave(sucessor.getChave());
		node.setInfo(sucessor.getInfo());
		return node;
	}
	
	private NodeAbb buscarSucessor(NodeAbb node)
	{
		if (node.getDireita() != null)
		{
			return buscarSucessor(node.getDireita());
		}
		return node;
	}
	/**/
}
