package DataBase;

import java.util.ArrayList;
import java.util.List;

import Users.Usuario;

public class DataBaseSingleton
{
	private static List<Usuario> bancoDeUsuarios;
	
	private DataBaseSingleton()
	{
		bancoDeUsuarios = new ArrayList<>();
	}
	
	public List<Usuario> getInstance()
	{
		if (bancoDeUsuarios == null)
		{
			new DataBaseSingleton();
			return DataBaseSingleton.bancoDeUsuarios;
		}
		return bancoDeUsuarios;
	}	
}
