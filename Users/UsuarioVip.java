package Users;

import java.util.ArrayList;
import java.util.List;

import App.FileChooser;
import LoginStrategy.LoginModeVip;
import Structs.PlayList;

public class UsuarioVip extends Usuario
{
    private List<PlayList> playLists;
  
    public UsuarioVip(String nome, String login, String senha)
    {
        super(nome, login, senha, new LoginModeVip());
        this.playLists = new ArrayList<>();
    }

    public List<PlayList> getPlayLists()
    {
        return this.playLists;
    }
    
    public void addPlayList(PlayList playlist)
    {
        this.playLists.add(playlist);
    }
    
    public PlayList getPlayList(int index)
    {
        return this.playLists.get(index);
    }
}
