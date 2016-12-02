package Exceptions;

public class UsuarioNaoExisteException extends Exception
{
    public UsuarioNaoExisteException(String msg)
    {
        super(msg);
    }
}
