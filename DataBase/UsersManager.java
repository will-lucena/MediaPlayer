package DataBase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Users.Usuario;
import Users.UsuarioVip;

public class UsersManager
{
	private String path = "usuarios.txt";
	
	public void gerarDataBase(DataBaseSingleton dataBase)
	{
		try (	FileWriter file = new FileWriter(path);
				PrintWriter escrever = new PrintWriter(file); )
		{
			for (Usuario user : dataBase.getInstance())
			{
				StringBuilder sb = new StringBuilder();
				
				sb.append(user.getLogin());
				sb.append("/");
				sb.append(user.getSenha());
				sb.append("/");
				sb.append(user.getNome());
				sb.append("/");
				sb.append(user.getLoginMode().getMode());
				
				escrever.println(sb.toString());
				
				if (user.getClass() == UsuarioVip.class)
				{
					/*
					 * criar pasta com nome user.login/user.senha
					 * salvar playslists dentro da pasta
					 */
				}
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
