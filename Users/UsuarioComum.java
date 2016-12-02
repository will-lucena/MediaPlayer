package Users;

import LoginStrategy.LoginModeComum;

public class UsuarioComum extends Usuario
{
    public UsuarioComum(String nome, String login, String senha)
    {
        super(nome, login, senha, new LoginModeComum());
    }
}
