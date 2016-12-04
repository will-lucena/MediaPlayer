package Structs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayList
{
    private final List<String> musicas;
    private String nome;

    public PlayList()
    {
        this.musicas = new ArrayList<>();
        this.nome = "playlist";
    }

    public String getNome()
    {
        return this.nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public List<String> getMusicas()
    {
        return this.musicas;
    }

    public PlayList criarPlayList(String musicas)
    {
        String[] lista = musicas.split("\n");
        this.musicas.addAll(Arrays.asList(lista));
        return this;
    }

    public void addMusica(String musica)
    {
        this.musicas.add(musica);
    }
}
