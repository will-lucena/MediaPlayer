package Testes;

import Exceptions.LoginIndisponivelException;
import Exceptions.UsuarioNaoExisteException;
import static org.junit.Assert.*;

import org.junit.Test;

import Structs.Abb;
import Users.Usuario;
import Users.UsuarioAdm;
import Users.UsuarioVip;

public class TestArvore
{

    @Test
    public void testInserir() throws LoginIndisponivelException
    {
        Abb arvore = new Abb();
        Usuario user = new UsuarioAdm();
        Usuario user1 = new UsuarioVip("Will", "will", "123", 5);
        Usuario user2 = new UsuarioVip("Eloiza", "elo", "123", 3);
        Usuario user3 = new UsuarioVip("Miguel", "migs", "123", 8);

        arvore.inserir(user);
        arvore.inserir(user1);
        arvore.inserir(user2);
        arvore.inserir(user3);

        assertEquals(user.getId(), arvore.getRaiz().getInfo().getId());
        assertEquals(user1.getId(), arvore.getRaiz().getDireita().getInfo().getId());
    }

    @Test
    public void testBuscar() throws LoginIndisponivelException
    {
        Abb arvore = new Abb();
        Usuario user = new UsuarioAdm();
        Usuario user1 = new UsuarioVip("Will", "will", "123", 5);
        Usuario user2 = new UsuarioVip("Eloiza", "elo", "123", 3);
        Usuario user3 = new UsuarioVip("Miguel", "migs", "123", 8);

        arvore.inserir(user);
        arvore.inserir(user1);
        arvore.inserir(user2);
        arvore.inserir(user3);

        assertEquals(user, arvore.buscar(user.getLogin()));
        assertEquals(user1, arvore.buscar(user1.getLogin()));
        assertEquals(user2, arvore.buscar(user2.getLogin()));
        assertEquals(user3, arvore.buscar(user3.getLogin()));
    }

    @Test
    public void testRemover() throws LoginIndisponivelException, UsuarioNaoExisteException
    {
        Abb arvore = new Abb();
        Usuario user = new UsuarioAdm();
        Usuario user1 = new UsuarioVip("Will", "will", "123", 6);
        Usuario user2 = new UsuarioVip("Eloiza", "elo", "123", 3);
        Usuario user3 = new UsuarioVip("Miguel", "migs", "123", 8);
        Usuario user4 = new UsuarioVip("Nadine", "nadis", "123", 5);
        Usuario user5 = new UsuarioVip("Zeus", "zeus", "123", 4);

        arvore.inserir(user);
        arvore.inserir(user1);
        arvore.inserir(user2);
        arvore.inserir(user3);
        arvore.inserir(user4);
        arvore.inserir(user5);

        arvore.remover(user.getLogin());
        //arvore.remover(user1);
        //arvore.remover(user2);
        //arvore.remover(user3);

        assertEquals(null, arvore.buscar(user.getLogin()));
        assertEquals(user1, arvore.buscar(user1.getLogin()));
        assertEquals(user2, arvore.buscar(user2.getLogin()));
        assertEquals(user3, arvore.buscar(user3.getLogin()));
        assertEquals(user4, arvore.buscar(user4.getLogin()));
        assertEquals(user5, arvore.buscar(user5.getLogin()));
    }
}
