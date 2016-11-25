package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayList
{
	private List<String> musicas;
	private String nome;
	private Scanner ler = new Scanner(System.in);

	public PlayList()
	{
		this.musicas = new ArrayList<>();
	}
	
	public String getNome()
	{
		return this.nome;
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
