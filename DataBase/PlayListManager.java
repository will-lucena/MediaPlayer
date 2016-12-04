package DataBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Structs.PlayList;
import Users.Usuario;
import Users.UsuarioAdm;
import Users.UsuarioVip;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import Structs.Abb;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayListManager
{

    private final StringBuilder playlists;
    private final String basePlayLists;
    private int contPlayLists;

    public PlayListManager()
    {
        this.contPlayLists = 0;
        this.basePlayLists = "playlists.txt";
        this.playlists = new StringBuilder();
    }

    /*
	 * Formato do arquivo
	 * user.login | user.senha
	 * playlist.nome
	 * musica1
	 * musica2
	 * musicax
     */
    public void gerarPlayLists()
    {
        try
        {
            for (Usuario user : DataBaseUsersSingleton.getInstance().getUsuarios())
            {
                if (user.getClass().equals(UsuarioVip.class))
                {
                    UsuarioVip vip = (UsuarioVip) user;

                    for (PlayList playlist : vip.getPlayLists())
                    {
                        String path = this.gerarNomeArquivo();
                        FileWriter file = new FileWriter(path);
                        PrintWriter escrever = new PrintWriter(file);

                        escrever.print(user.getLogin());
                        escrever.print(" | ");
                        escrever.println(user.getSenha());
                        escrever.println(playlist.getNome());

                        for (String linha : playlist.getMusicas())
                        {
                            escrever.println(linha);
                        }
                        this.playlists.append(path);
                        this.playlists.append("\n");
                        escrever.close();
                        file.close();
                    }
                }
                else if (user.getClass().equals(UsuarioAdm.class))
                {
                    UsuarioAdm adm = (UsuarioAdm) user;

                    for (PlayList playlist : adm.getPlayLists())
                    {
                        String path = this.gerarNomeArquivo();
                        FileWriter file = new FileWriter(path);
                        PrintWriter escrever = new PrintWriter(file);

                        escrever.print(user.getLogin());
                        escrever.print(" | ");
                        escrever.println(user.getSenha());
                        escrever.println(playlist.getNome());

                        for (String linha : playlist.getMusicas())
                        {
                            escrever.println(linha);
                        }
                        this.playlists.append(path);
                        this.playlists.append("\n");
                        escrever.close();
                        file.close();
                    }
                }
            }
            gerarBasePlayLists();
        } catch (IOException e1)
        {
            JOptionPane.showMessageDialog(null, "Erro no arquivo de playlists");
        }
    }

    private String gerarNomeArquivo()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("playList");
        sb.append(this.contPlayLists);
        sb.append(".txt");
        this.contPlayLists++;
        return sb.toString();
    }

    public void carregarPlayLists()
    {
        try (FileReader file = new FileReader(this.basePlayLists);
            BufferedReader buffer = new BufferedReader(file);)
        {
            String linha = buffer.readLine();

            while (linha != null && !linha.equals(""))
            {
                this.playlists.append(linha);
                this.playlists.append("\n");
                linha = buffer.readLine();
            }

            for (Usuario user : DataBaseUsersSingleton.getInstance().getUsuarios())
            {
                if (user.getClass().equals(UsuarioVip.class))
                {
                    UsuarioVip vip = (UsuarioVip) user;
                    carregarPlayLists(vip);
                }
                else if (user.getClass().equals(UsuarioAdm.class))
                {
                    UsuarioAdm adm = (UsuarioAdm) user;
                    carregarPlayLists(adm);
                }
            }
        } catch (IOException e1)
        {
            JOptionPane.showMessageDialog(null, "Erro no arquivo de playlists");
        }
    }

    private void carregarPlayLists(UsuarioVip user)
    {
        PlayList playlist = new PlayList();

        for (String arquivoPlaylist : this.playlists.toString().split("\n"))
        {
            try (FileReader file = new FileReader(arquivoPlaylist);
                BufferedReader buffer = new BufferedReader(file);)
            {
                String linha = buffer.readLine();
                if (validar(user, linha))
                {
                    linha = buffer.readLine();
                    playlist.setNome(linha);
                    linha = buffer.readLine();

                    while (linha != null)
                    {
                        playlist.addMusica(linha);
                        linha = buffer.readLine();
                    }
                    user.addPlayList(playlist);
                    DataBaseSingleton.getInstance().atualizarUsuario(user);
                }
            } catch (FileNotFoundException e1)
            {
                JOptionPane.showMessageDialog(null, "Erro no arquivo de playlists");
            } catch (IOException e2)
            {
                JOptionPane.showMessageDialog(null, "Erro no arquivo de playlists");
            }
        }
    }

    private void carregarPlayLists(UsuarioAdm user)
    {
        for (String arquivoPlaylist : this.playlists.toString().split("\n"))
        {
            try (FileReader file = new FileReader(arquivoPlaylist);
                BufferedReader buffer = new BufferedReader(file);)
            {
                PlayList playlist = new PlayList();
                String linha = buffer.readLine();
                if (validar(user, linha))
                {
                    linha = buffer.readLine();
                    playlist.setNome(linha);
                    linha = buffer.readLine();

                    while (linha != null)
                    {
                        playlist.addMusica(linha);
                        linha = buffer.readLine();
                    }
                    user.addPlayList(playlist);
                    DataBaseSingleton.getInstance().atualizarUsuario(user);
                }
            } catch (FileNotFoundException e1)
            {
                JOptionPane.showMessageDialog(null, "Erro no arquivo de playlists");
            } catch (IOException e2)
            {
                JOptionPane.showMessageDialog(null, "Erro no arquivo de playlists");
            }
        }
    }

    private void gerarBasePlayLists()
    {
        try (FileWriter file = new FileWriter(this.basePlayLists);
            PrintWriter escrever = new PrintWriter(file);)
        {
            for (String str : this.playlists.toString().split("\n"))
            {
                escrever.println(str);
            }
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro no arquivo de playlists");
        }
    }

    private boolean validar(Usuario user, String linha)
    {
        String[] dados = linha.split(" | ");

        return dados[0].equals(user.getLogin()) && dados[2].equals(user.getSenha());
    }
}
