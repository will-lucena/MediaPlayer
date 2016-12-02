package Structs;

import Users.Usuario;

public class NodeAbb
{
    private Usuario info;
    private NodeAbb esquerda;
    private NodeAbb direita;

    protected NodeAbb()
    {
        this.info = null;
        this.esquerda = null;
        this.direita = null;
    }

    public NodeAbb(Usuario user)
    {
        this.info = user;
        this.esquerda = null;
        this.direita = null;
    }

    public Usuario getInfo()
    {
        return this.info;
    }

    public void setInfo(Usuario user)
    {
        this.info = user;
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
