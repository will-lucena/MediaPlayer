package LoginStrategy;

import Users.Usuario;

public interface LoginModeStrategy
{

    public void gerarTela(java.awt.Frame parent, boolean modal, Usuario user);
    public String getMode();
}
