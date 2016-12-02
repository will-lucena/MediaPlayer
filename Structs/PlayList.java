package Structs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayList
{
    private final List<String> musicas;
    private String nome;
    private final Scanner ler = new Scanner(System.in);

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

    public List<String> criarPlayList()
    {
        int i = 0;
        int j = 5;
        while (i < j)
        {
            this.musicas.add(this.selecionarMusica());
        }
        return this.musicas;
    }
    
    public PlayList criarPlayList(String musicas)
    {
        String[] lista = musicas.split("\n");
        this.musicas.addAll(Arrays.asList(lista));
        return this;
    }

    private String selecionarMusica()
    {
        System.out.println("Informe o caminho da musica");
        return ler.nextLine();
    }

    public void addMusica(String musica)
    {
        this.musicas.add(musica);
    }
}
