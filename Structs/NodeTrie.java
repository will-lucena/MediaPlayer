package Structs;

import java.util.ArrayList;
import java.util.List;

public class NodeTrie
{

    private final char c;
    private final List<NodeTrie> filhos;
    private boolean isWord;
    private int numFilhos;

    public NodeTrie()
    {
        this.c = 0;
        this.filhos = new ArrayList<>();
        this.isWord = false;
    }

    public NodeTrie(char letter)
    {
        this.c = letter;
        this.filhos = new ArrayList<>();
        this.isWord = false;
    }

    public List<NodeTrie> getFilhos()
    {
        return filhos;
    }

    public void setNumFilhos(int numFilhos)
    {
        this.numFilhos = numFilhos;
    }
    
    public char getC()
    {
        return this.c;
    }

    public int getNumFilhos()
    {
        return this.numFilhos;
    }

    public boolean isIsWord()
    {
        return this.isWord;
    }

    public NodeTrie getFilho(char character)
    {
        for (NodeTrie node : this.filhos)
        {
            if (node.c == character)
            {
                return node;
            }
        }
        return null;
    }
    
    public int add(String palavra)
    {
        String sub = palavra.substring(1);
        char letter = palavra.charAt(0);
        
        if (sub.isEmpty())
        {
            if (getFilho(letter) == null)
            {
                NodeTrie node = new NodeTrie(letter);
                node.isWord = true;
                this.filhos.add(node);
                this.numFilhos++;
                return 1;
            }
            else
            {
                return 0;
            }
        }

        if (getFilho(letter) == null)
        {
            this.filhos.add(new NodeTrie(letter));
        }

        this.numFilhos += this.getFilho(letter).add(palavra.substring(1));
        return 1;
    }

    public boolean isWord(String s)
    {
        if (s.isEmpty())
        {
            return this.isWord;
        }
        char letter = s.charAt(0);

        if (getFilho(letter) == null)
        {
            return false;
        }
        
        return this.getFilho(letter).isWord(s.substring(1));
    }
}
