package Structs;

import Exceptions.BancoVazioException;

public class Trie
{
    private StringBuilder musicas;
    private final NodeTrie raiz;

    public Trie()
    {
        this.raiz = new NodeTrie();
        this.musicas = new StringBuilder();
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
            this.musicas = new StringBuilder();
            StringBuilder palavras = new StringBuilder();
            gerarRegistro(this.raiz, new StringBuilder(), palavras);
            return musicas.toString();
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
                    if (node.getFilhos().size() > 0)
                    {
                        sb.append(node.getC());
                        musicas.append(palavras.toString());
                        musicas.append(sb.toString());
                        musicas.append("\n");
                        gerarRegistro(node, sb, new StringBuilder().append(palavras.toString()));
                    }
                    else
                    {
                        sb.append(node.getC());
                        musicas.append(palavras.toString());
                        musicas.append(sb.toString());
                        musicas.append("\n");
                        break;
                    }
                }
                else
                {
                    sb.append(node.getC());
                    if (node.getFilhos().size() > 1)
                    {
                        palavras.append(sb.toString());
                        sb = new StringBuilder();
                    }
                    gerarRegistro(node, sb, new StringBuilder().append(palavras.toString()));
                }
            }
            sb = new StringBuilder();
        }
    }

    public String[] buscarPalavra(String palavra) throws BancoVazioException
    {
        return gerarRegistro().split("\n");
    }
}
