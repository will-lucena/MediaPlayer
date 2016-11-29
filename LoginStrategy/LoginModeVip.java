package LoginStrategy;

import Interface.TelaVip;

public class LoginModeVip implements LoginModeStrategy
{

    @Override
    public void gerarTela()
    {
        new TelaVip().setVisible(true);
    }

    @Override
    public String getMode()
    {
        return "vip";
    }
}
