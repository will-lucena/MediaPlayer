package DataBase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UsersManager
{

    private String path;

    public UsersManager()
    {
        this.path = "usuarios.txt";
    }

    /*
	 * Formato do arquivo de usuarios
	 * user.login/user.senha/user.nome/user.tipo
     */
    public boolean gerarDataBase()
    {
        try (FileWriter file = new FileWriter(path);
                PrintWriter escrever = new PrintWriter(file);)
        {
            String registro = DataBaseSingleton.getInstance().gerarRegistro();
            String[] registros = registro.split("\n");
            for (String str : registros)
            {
                escrever.println(str);
            }
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
