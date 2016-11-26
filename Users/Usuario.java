package Users;

import LoginStrategy.LoginModeAdm;
import LoginStrategy.LoginModeStrategy;
import MediaPlayer.MediaPlayer;

public abstract class Usuario 
{
	protected String nome;
	protected String login;
	protected String senha;
	protected int id;
	protected LoginModeStrategy loginMode;
	
	public Usuario()
	{
		this.nome = "Administrador";
		this.login = "admin";
		this.senha = "admin";
		this.id = 0;
		this.loginMode = new LoginModeAdm();
	}
	
	public Usuario(String nome, String login, String senha, int id, LoginModeStrategy loginMode)
	{
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.id = id;
		this.loginMode = loginMode;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public String getLogin()
	{
		return this.login;
	}
	
	public String getSenha()
	{
		return this.senha;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public LoginModeStrategy getLoginMode()
	{
		return this.loginMode;
	}
	
	public void setLoginMode(LoginModeStrategy loginMode)
	{
		this.loginMode = loginMode;
	}
	
	public void tocarMusica(MediaPlayer player)
	{
		player.tocar();
	}
}
