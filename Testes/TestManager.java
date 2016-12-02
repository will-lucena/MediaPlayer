package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import DataBase.DataBaseUsersSingleton;
import DataBase.PlayListManager;
import DataBase.UsersManager;
import Exceptions.LoginIndisponivelException;
import Users.Usuario;
import Users.UsuarioAdm;
import Users.UsuarioComum;
import Users.UsuarioVip;

public class TestManager
{

    @Test
    public void testEscritaArquivoUser() throws LoginIndisponivelException
    {
        UsersManager manager = new UsersManager("users.txt", "playlists.txt");
        Usuario user = new UsuarioAdm();
        Usuario user1 = new UsuarioVip("Will", "will", "123");
        Usuario user2 = new UsuarioComum("Eloiza", "elo", "123");

        DataBaseUsersSingleton.getInstance().inserir(user);
        DataBaseUsersSingleton.getInstance().inserir(user1);
        DataBaseUsersSingleton.getInstance().inserir(user2);

        assertEquals(true, manager.gerarDataBase());
    }

    @Test
    public void testEscritaPlayList()
    {
        Usuario user = new UsuarioVip("Will", "will", "123");
        UsuarioVip vip = (UsuarioVip) user;
        PlayListManager manager = new PlayListManager();

        vip.criarPlayList();
        manager.gerarPlayList(user, vip.getPlayLists().get(0));
    }
}
