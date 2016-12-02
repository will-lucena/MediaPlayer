package App;

import Structs.Trie;

public class Main
{

    public static void main(String[] args)
    {
        Trie trie = new Trie();
        trie.inserir("ab");
        trie.inserir("abc");
        trie.inserir("abcd");
        trie.inserir("b");
        trie.show();
    }
}
