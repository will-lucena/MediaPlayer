package DataBase;

import Exceptions.LoginIndisponivelException;
import Structs.PlayList;
import Users.Usuario;
import Users.UsuarioAdm;
import Users.UsuarioComum;
import Users.UsuarioVip;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsersManager
{

    private final String pathMusicas;
    private final String pathPlaylists;
    public static StringBuilder playlists;

    static
    {
        playlists = new StringBuilder();
    }

    public UsersManager(String pathMusicas, String pathPlaylists)
    {
        this.pathMusicas = pathMusicas;
        this.pathPlaylists = pathPlaylists;
    }

    /*
	 * Formato do arquivo de usuarios
	 * user.login | user.senha | user.nome | user.tipo
     */
    public boolean gerarDataBase()
    {
        try (FileWriter file = new FileWriter(pathMusicas);
                PrintWriter escrever = new PrintWriter(file);)
        {
            String registro = DataBaseUsersSingleton.getInstance().gerarRegistro();
            String[] registros = registro.split("\n");
            for (String str : registros)
            {
                escrever.println(str);
            }
            return true;
        } catch (IOException e)
        {
            return false;
        }
    }

    public boolean gerarDataBasePlaylists()
    {
        try (FileWriter file = new FileWriter(pathPlaylists);
                PrintWriter escrever = new PrintWriter(file);)
        {
            String registro = playlists.toString();
            String[] registros = registro.split("\n");
            for (String str : registros)
            {
                escrever.println(str);
            }
            return true;
        } catch (IOException e)
        {
            return false;
        }
    }

    public boolean carregarDataBasePlaylists()
    {
        try (FileReader file = new FileReader(pathPlaylists);
                BufferedReader buffer = new BufferedReader(file);)
        {

            String linha = buffer.readLine();

            while (linha != null)
            {
                playlists.append(linha);
                linha = buffer.readLine();
            }
            return true;

        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex)
        {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean carregarDataBase()
    {
        try (FileReader file = new FileReader(pathMusicas);
                BufferedReader buffer = new BufferedReader(file);)
        {
            if (carregarDataBasePlaylists())
            {
                DataBaseUsersSingleton.getInstance();
                String linha = buffer.readLine();
                linha = buffer.readLine();

                while (linha != null)
                {
                    Usuario user;
                    String[] registro = linha.split(" | ");
                    switch (registro[6])
                    {
                        case "adm":
                            user = new UsuarioAdm(registro[0], registro[2], registro[4]);
                            user = carregarPlayLists((UsuarioAdm) user, playlists.toString().split("\n"));
                            break;
                        case "vip":
                            user = new UsuarioVip(registro[0], registro[2], registro[4]);
                            user = carregarPlayLists((UsuarioVip) user, playlists.toString().split("\n"));
                            break;
                        default:
                            user = new UsuarioComum(registro[0], registro[2], registro[4]);
                            break;
                    }
                    DataBaseUsersSingleton.getInstance().inserir(user);
                    linha = buffer.readLine();
                }
                return true;
            }
            return false;
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro no arquivo");
            return false;
        } catch (LoginIndisponivelException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro no banco");
            return false;
        }
    }

    private UsuarioAdm carregarPlayLists(UsuarioAdm user, String[] paths)
    {
        for (String lista : paths)
        {
            PlayList playlist = new PlayListManager().carregarPlayList(user, lista);
            if (playlist != null)
            {
                user.addPlayList(playlist);
            }
        }
        return user;
    }

    private UsuarioVip carregarPlayLists(UsuarioVip user, String[] paths)
    {
        for (String lista : paths)
        {
            PlayList playlist = new PlayListManager().carregarPlayList(user, lista);
            if (playlist != null)
            {
                user.addPlayList(playlist);
            }
        }
        return user;
    }
}
