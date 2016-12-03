package Users;

import LoginStrategy.LoginModeAdm;
import Structs.PlayList;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAdm extends Usuario
{
    private List<PlayList> playLists;
    
    public UsuarioAdm()
    {
        super();
        this.playLists = new ArrayList<>();
    }
    
    public UsuarioAdm(String nome, String login, String senha)
    {
        super(nome, login, senha, new LoginModeAdm());
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
}
