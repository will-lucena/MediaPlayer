package DataBase;

import Structs.Trie;

public class DataBaseSongsSingleton
{
    private static Trie bancoDeMusicas = null;

    private DataBaseSongsSingleton()
    {
        bancoDeMusicas = new Trie();
    }

    public static Trie getInstance()
    {
        if (bancoDeMusicas == null)
        {
            new DataBaseSongsSingleton();
        }
        return bancoDeMusicas;
    }
}
