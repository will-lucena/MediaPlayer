package DataBase;

import Exceptions.UsuarioInvalidoException;
import Exceptions.UsuarioNaoExisteException;
import Structs.Abb;
import Users.Usuario;

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
    
    public static Usuario autenticarUsuario(String login, String senha) throws UsuarioInvalidoException
    {
        Usuario user = getInstance().buscar(login);
        
        if (user != null && user.getSenha().equals(senha))
        {
            return user;
        }
        else
        {
            throw new UsuarioInvalidoException("Usuario nao cadastrado ou senha nao confere");
        }
    }
}
