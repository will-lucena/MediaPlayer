package LoginStrategy;

import Users.Usuario;
import java.awt.Frame;

public class LoginModeComum implements LoginModeStrategy
{

    @Override
    public void gerarTela(Frame parent, boolean modal, Usuario user)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getMode()
    {
        return "normal";
    }
}
