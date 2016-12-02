package LoginStrategy;

import Interface.TelaAdm;
import Users.Usuario;
import java.awt.Frame;

public class LoginModeAdm implements LoginModeStrategy
{
    @Override
    public void gerarTela(Frame parent, boolean modal, Usuario user)
    {
        new TelaAdm(parent, modal, user).setVisible(true);
    }
    
    @Override
    public String getMode()
    {
        return "adm";
    }
}
