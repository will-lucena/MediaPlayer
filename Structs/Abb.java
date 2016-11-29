package Structs;

import DataBase.PlayListManager;
import Exceptions.LoginIndisponivelException;
import Exceptions.UsuarioNaoExisteException;
import Users.Usuario;
import Users.UsuarioAdm;
import Users.UsuarioVip;

public class Abb
{

    private NodeAbb raiz;

    public Abb()
    {
        this.raiz = new NodeAbb();
        this.raiz.setInfo(new UsuarioAdm());
    }

    public NodeAbb getRaiz()
    {
        return this.raiz;
    }

    public Usuario buscar(String user)
    {
        return this.buscar(this.raiz, user);
    }

    private Usuario buscar(NodeAbb node, String user)
    {
        if (node == null)
        {
            return null;
        }

        if (user.compareTo(node.getInfo().getLogin()) == 0)
        {
            return node.getInfo();
        }

        if (user.compareToIgnoreCase(node.getInfo().getLogin()) > 0)
        {
            return buscar(node.getDireita(), user);
        }

        if (user.compareToIgnoreCase(node.getInfo().getLogin()) < 0)
        {
            return buscar(node.getEsquerda(), user);
        }

        return null;
    }

    public void inserir(Usuario user) throws LoginIndisponivelException
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

    private NodeAbb inserir(NodeAbb node, Usuario user) throws LoginIndisponivelException
    {
        if (node == null)
        {
            node = new NodeAbb(user);
            return node;
        }
        else if (user.getLogin().compareTo(node.getInfo().getLogin()) > 0)
        {
            NodeAbb tmp = this.inserir(node.getDireita(), user);
            node.setDireita(tmp);
        }
        else if (user.getLogin().compareTo(node.getInfo().getLogin()) < 0)
        {
            NodeAbb tmp = this.inserir(node.getEsquerda(), user);
            node.setEsquerda(tmp);
        }
        else if (user.getLogin().compareTo(node.getInfo().getLogin()) == 0)
        {
            throw new LoginIndisponivelException("Usuario ja existe");
        }
        return node;
    }

    public void remover(String login) throws UsuarioNaoExisteException
    {
        this.raiz = this.remover(this.raiz, login);
    }

    private NodeAbb remover(NodeAbb node, String user) throws UsuarioNaoExisteException
    {
        if (node == null)
        {
            throw new UsuarioNaoExisteException("Usuario invalido");
        }
        
        else if (user.compareTo(node.getInfo().getLogin()) == 0)
        {
            node = this.removerCaso1(node);
            return node;
        }
        else if (user.compareTo(node.getInfo().getLogin()) > 0)
        {
            NodeAbb tmp = this.remover(node.getDireita(), user);
            node.setDireita(tmp);
        }
        else if (user.compareTo(node.getInfo().getLogin()) < 0)
        {
            NodeAbb tmp = this.remover(node.getEsquerda(), user);
            node.setEsquerda(tmp);
        }
        
        return null;
    }

    private NodeAbb removerCaso1(NodeAbb node) throws UsuarioNaoExisteException
    {
        if (node.getEsquerda() == null)
        {
            node = node.getDireita();
            return node;
        }
        else if (node.getDireita() == null)
        {
            node = node.getEsquerda();
            return node;
        }
        else
        {
            return removerCaso2(node);
        }
    }

    private NodeAbb removerCaso2(NodeAbb node) throws UsuarioNaoExisteException
    {
        NodeAbb sucessor = buscarSucessor(node.getEsquerda());
        remover(sucessor.getInfo().getLogin());
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

    public String gerarRegistro()
    {
        if (this.raiz != null)
        {
            StringBuilder sb = new StringBuilder();
            this.preOrdem(sb, this.raiz);
            return sb.toString();
        }
        return null;
    }

    private String preOrdem(StringBuilder sb, NodeAbb node)
    {
        if (node != null)
        {
            sb.append(gerarLinha(node.getInfo()));
            this.preOrdem(sb, node.getEsquerda());
            this.preOrdem(sb, node.getDireita());
            return sb.toString();
        }
        return sb.toString();
    }

    private String gerarLinha(Usuario user)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(user.getNome());
        sb.append(" | ");
        sb.append(user.getLogin());
        sb.append(" | ");
        sb.append(user.getSenha());
        sb.append(" | ");
        sb.append(user.getLoginMode().getMode());
        sb.append("\n");

        if (user.getClass() == UsuarioVip.class)
        {
            UsuarioVip vip = (UsuarioVip) user;
            for (PlayList playlist : vip.getPlayLists())
            {
                new PlayListManager().gerarPlayList(vip, playlist);
            }
        }

        return sb.toString();
    }
}
