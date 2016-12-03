package DataBase;

import Exceptions.LoginIndisponivelException;
import Users.Usuario;
import Users.UsuarioAdm;
import Users.UsuarioComum;
import Users.UsuarioVip;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class UsersManager
{

    private final String baseUsuarios;

    public UsersManager()
    {
        baseUsuarios = "baseUsuarios.txt";
    }

    /*
	 * Formato do arquivo de usuarios
	 * user.login | user.senha | user.nome | user.tipo
     */
    public boolean gerarDataBase()
    {
        try (FileWriter file = new FileWriter(baseUsuarios);
            PrintWriter escrever = new PrintWriter(file);)
        {
            String registro = DataBaseUsersSingleton.getInstance().gerarRegistro();
            if (registro != null && !registro.equals(""))
            {
                String[] registros = registro.split("\n");
                for (String str : registros)
                {
                    escrever.println(str);
                }
                return true;
            }
            return false;
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro no arquivo de usuarios");
            return false;
        }
    }

    public boolean carregarDataBase()
    {
        try (FileReader file = new FileReader(baseUsuarios);
            BufferedReader buffer = new BufferedReader(file);)
        {
            DataBaseUsersSingleton.getInstance();
            String linha = buffer.readLine();

            while (linha != null)
            {
                Usuario user;
                String[] registro = linha.split(" | ");
                switch (registro[6])
                {
                    case "adm":
                        user = new UsuarioAdm(registro[0], registro[2], registro[4]);
                        break;
                    case "vip":
                        user = new UsuarioVip(registro[0], registro[2], registro[4]);
                        break;
                    default:
                        user = new UsuarioComum(registro[0], registro[2], registro[4]);
                        break;
                }
                DataBaseUsersSingleton.getInstance().inserir(user);
                linha = buffer.readLine();
            }
            return true;
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro no arquivo de usuarios");
            return false;
        } catch (LoginIndisponivelException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro no banco de usuarios");
            return false;
        }
    }
}
