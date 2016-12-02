package DataBase;

import Exceptions.UsuarioInvalidoException;
import Exceptions.UsuarioNaoExisteException;
import Structs.Abb;
import Users.Usuario;

public class DataBaseUsersSingleton
{

    private static Abb bancoDeUsuarios = null;

    private DataBaseUsersSingleton()
    {
        bancoDeUsuarios = new Abb();
    }

    public static Abb getInstance()
    {
        if (bancoDeUsuarios == null)
        {
            new DataBaseUsersSingleton();
        }
        return bancoDeUsuarios;
    }
    
    public static Usuario autenticarUsuario(String login, String senha) throws UsuarioInvalidoException, UsuarioNaoExisteException
    {
        Usuario user = getInstance().buscar(login);
        
        if (user.getSenha().equals(senha))
        {
            return user;
        }
        else
        {
            throw new UsuarioInvalidoException("Usuario nao cadastrado ou senha nao confere");
        }
    }
}
