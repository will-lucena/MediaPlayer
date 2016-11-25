package Users;

import java.util.ArrayList;
import java.util.List;
import Lists.PlayList;

public class UsuarioVip extends Usuario
{
	private List<PlayList> playLists;
	
	public UsuarioVip()
	{
		super();
		this.playLists = new ArrayList<>(); 
	}
	
	public List<PlayList> getPlayLists()
	{
		return this.playLists;
	}
}
