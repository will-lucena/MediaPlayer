package LoginStrategy;

import Interface.TelaNormal;

public class LoginModeComum implements LoginModeStrategy
{

    @Override
    public void gerarTela()
    {
        new TelaNormal().setVisible(true);
    }

    @Override
    public String getMode()
    {
        return "normal";
    }
}
