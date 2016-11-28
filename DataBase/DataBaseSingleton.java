package DataBase;

import Structs.Abb;

public class DataBaseSingleton
{
	private static Abb bancoDeUsuarios = null;
	
	private DataBaseSingleton()
	{
		bancoDeUsuarios = new Abb();
	}
	
	public static Abb getInstance()
	{
		if (bancoDeUsuarios == null)
		{
			new DataBaseSingleton();
		}
		return bancoDeUsuarios;
	}	
}
