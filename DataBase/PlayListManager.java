package DataBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Structs.PlayList;
import Users.Usuario;

public class PlayListManager
{

    private int contPlayLists = 0;

    /*
	 * Formato do arquivo
	 * user.login/user.senha
	 * playlist.nome
	 * musica1
	 * musica2
	 * musicax
     */
    public String gerarPlayList(Usuario user, PlayList playlist)
    {
        String path = this.gerarNomeArquivo();
        try (FileWriter file = new FileWriter(path);
                PrintWriter escrever = new PrintWriter(file);)
        {
            escrever.print(user.getLogin());
            escrever.print("|");
            escrever.print(user.getSenha());
            escrever.print("\n");
            escrever.println(playlist.getNome());

            for (String linha : playlist.getMusicas())
            {
                escrever.println(linha);
            }
            return path;
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private String gerarNomeArquivo()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("playList");
        sb.append(this.contPlayLists);
        sb.append(".txt");

        return sb.toString();
    }

    public PlayList carregarPlayList(String path)
    {
        try (FileReader file = new FileReader(path);
                BufferedReader buffer = new BufferedReader(file);)
        {
            PlayList playlist = new PlayList();

            String linha = buffer.readLine();
            linha = buffer.readLine();
            linha = buffer.readLine();

            while (linha != null)
            {
                playlist.addMusica(linha);
                linha = buffer.readLine();
            }
            return playlist;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
