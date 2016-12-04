package LoginStrategy;

import Interface.TelaVip;
import Users.Usuario;
import java.awt.Frame;

public class LoginModeVip implements LoginModeStrategy
{
    @Override
    public String getMode()
    {
        return "vip";
    }

    @Override
    public void gerarTela(Frame parent, boolean modal, Usuario user)
    {
        new TelaVip(parent, modal, user).setVisible(true);
    }
}
