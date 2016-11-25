package DataBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Lists.PlayList;
import Users.Usuario;

public class PlayListManager
{
	private String path;
	private int contPlayLists = 0;
	
	/*
	 * Formato do arquivo
	 * user.login/user.senha
	 * playlist.nome
	 * musica1
	 * musica2
	 * musicax
	 */
	public void gerarPlayList(Usuario user, PlayList playlist)
	{
		try (	FileWriter file = new FileWriter(this.gerarNomeArquivo());
				PrintWriter escrever = new PrintWriter(file); )
		{
			escrever.print(user.getLogin());
			escrever.print("/");
			escrever.print(user.getSenha());
			escrever.print("\n");
			escrever.println(playlist.getNome());
			
			for (String linha : playlist.getMusicas())
			{
				escrever.println(linha);
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private String gerarNomeArquivo()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.path);
		sb.append("/");
		sb.append("playList");
		sb.append(this.contPlayLists);
		
		return sb.toString();
	}
	
	private PlayList carregarPlayList(String path)
	{
		try (FileReader file = new FileReader(path);
				BufferedReader buffer = new BufferedReader(file);)
		{
			PlayList playlist = new PlayList();
			
			String linha = buffer.readLine();
			while (linha != null)
			{
				playlist.addMusica(linha);
				linha = buffer.readLine();
			}
			return playlist;
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
