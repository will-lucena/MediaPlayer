package LoginStrategy;

public interface LoginModeStrategy
{
	public boolean autenticar(String login, String senha);
	public String getMode();
}
