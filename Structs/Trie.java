package Structs;

import Exceptions.BancoVazioException;

public class Trie
{
    private final NodeTrie raiz;
    
    public Trie()
    {
        this.raiz = new NodeTrie();
    }
    
    public boolean isEmpty()
    {
        return this.raiz.getNumFilhos() == 0;
    }

    public void inserir(String musica)
    {
        this.raiz.setNumFilhos(this.raiz.getNumFilhos() + this.raiz.add(musica));
    }

    public void show()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.raiz.getC());
        show(this.raiz, sb);
    }

    private void show(NodeTrie raiz, StringBuilder sb)
    {
        for (NodeTrie node : raiz.getFilhos())
        {
            if (node != null)
            {
                if (node.isIsWord())
                {
                    if (node.getNumFilhos() > 0)
                    {
                        sb.append(node.getC());
                        System.out.println(sb.toString());
                        show(node, sb);
                    }
                    else
                    {
                        System.out.println(sb.toString() + node.getC());
                        return;
                    }
                }
                else
                {
                    sb.append(node.getC());
                    show(node, sb);
                }
            }
            if (raiz.equals(this.raiz))
            {
                sb = new StringBuilder();
            }
        }
    }

    public String gerarRegistro() throws BancoVazioException
    {
        if (!isEmpty())
        {
            StringBuilder palavras = new StringBuilder();
            gerarRegistro(this.raiz, new StringBuilder(), palavras);
            return palavras.toString();
        }
        else
        {
            throw new BancoVazioException("Ainda nao foram adicionadas musicas ao banco");
        }
    }

    private void gerarRegistro(NodeTrie raiz, StringBuilder sb, StringBuilder palavras)
    {
        for (NodeTrie node : raiz.getFilhos())
        {
            if (node != null)
            {
                if (node.isIsWord())
                {
                    if (node.getNumFilhos() > 0)
                    {
                        sb.append(node.getC());
                        palavras.append(sb.toString());
                        palavras.append("\n");
                        gerarRegistro(node, sb, palavras);
                    }
                    else
                    {
                        palavras.append(sb.toString());
                        palavras.append(node.getC());
                        palavras.append("\n");
                        break;
                    }
                }
                else
                {
                    sb.append(node.getC());
                    gerarRegistro(node, sb, palavras);
                }
            }
            if (raiz.equals(this.raiz))
            {
                sb = new StringBuilder();
            }
        }
    }
    
    public String[] buscarPalavra(String palavra) throws BancoVazioException
    {
        return gerarRegistro().split("\n");
    }
}
