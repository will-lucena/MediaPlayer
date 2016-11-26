package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import Structs.Abb;
import Users.Usuario;
import Users.UsuarioAdm;
import Users.UsuarioVip;

public class TestArvore
{
	@Test
	public void testInserir()
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
	public void testBuscar()
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
		
		assertEquals(true, arvore.buscar(user));
		assertEquals(true, arvore.buscar(user1));
		assertEquals(true, arvore.buscar(user2));
		assertEquals(true, arvore.buscar(user3));
	}
	
	@Test
	public void testRemover()
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
		
		arvore.remover(user);
		//arvore.remover(user1);
		//arvore.remover(user2);
		//arvore.remover(user3);

		assertEquals(false, arvore.buscar(user));
		assertEquals(true, arvore.buscar(user1));
		assertEquals(true, arvore.buscar(user2));
		assertEquals(true, arvore.buscar(user3));
		assertEquals(true, arvore.buscar(user4));
		assertEquals(true, arvore.buscar(user5));
	}
}
