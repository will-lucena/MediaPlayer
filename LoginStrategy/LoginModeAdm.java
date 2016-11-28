package LoginStrategy;

import Interface.TelaAdm;

public class LoginModeAdm implements LoginModeStrategy
{

    @Override
    public void gerarTela()
    {
        new TelaAdm().setVisible(true);
    }

    @Override
    public String getMode()
    {
        return "adm";
    }
}
