package LoginStrategy;

import Interface.TelaComum;
import Users.Usuario;
import java.awt.Frame;

public class LoginModeComum implements LoginModeStrategy
{

    @Override
    public void gerarTela(Frame parent, boolean modal, Usuario user)
    {
        new TelaComum(parent, modal, user).setVisible(true);
    }
    
    @Override
    public String getMode()
    {
        return "normal";
    }
}
