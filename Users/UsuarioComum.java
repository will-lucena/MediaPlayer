package Users;

import LoginStrategy.LoginModeComum;

public class UsuarioComum extends Usuario
{
	public UsuarioComum(String nome, String login, String senha, int id)
	{
		super(nome, login, senha, id, new LoginModeComum());
	}
}
