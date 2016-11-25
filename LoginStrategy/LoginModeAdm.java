package LoginStrategy;

public class LoginModeAdm implements LoginModeStrategy
{

	@Override
	public boolean autenticar(String login, String senha)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMode()
	{
		return "adm";
	}
}
