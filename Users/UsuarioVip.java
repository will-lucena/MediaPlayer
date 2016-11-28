package Users;

import java.util.ArrayList;
import java.util.List;

import App.FileChooser;
import LoginStrategy.LoginModeVip;
import Structs.PlayList;

public class UsuarioVip extends Usuario
{
	private List<PlayList> playLists;
	
	public UsuarioVip(String nome, String login, String senha, int id)
	{
		super(nome, login, senha, id, new LoginModeVip());
		this.playLists = new ArrayList<>(); 
	}
	
	public List<PlayList> getPlayLists()
	{
		return this.playLists;
	}
	
	public PlayList criarPlayList()
	{
		PlayList playlist = new PlayList();
		
		String str = new FileChooser().escolherArquivo("Selecione a musica");
		
		playlist.addMusica(str);
		playLists.add(playlist);
		return playlist;
	}
}
