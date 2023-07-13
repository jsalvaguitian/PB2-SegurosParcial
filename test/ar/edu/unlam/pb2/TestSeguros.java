package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class TestSeguros {
/*
 * Los usuarios pueden ser de tipo Básico o Administradores
 */

	@Test
	public void queSePuedaCrearUnSistema() {

		Sistema sistema =  new Sistema("Lightech");
		
		assertNotNull(sistema);
		assertEquals((Integer)0, sistema.getCantidadDeUsuarios());
	}
	
	@Test
	public void queElUsuarioSeBloqueeSiSeLoguea3VecesConContraseniaIncorrecta() throws InvalidPassword, UserNotFound {
		//al menos un número y una minúscula y una mayúscula.
		
		Sistema sistema =  new Sistema("Lightech");
		final String nombre = "Homero";
		final String password = "Hola1";
		final String passwordIncorrecta = "lalal";
		
		UsuarioBasico user= new UsuarioBasico(nombre, password);

		sistema.agregarUsuario(user);
		
		assertFalse(sistema.login(passwordIncorrecta, nombre));
		assertFalse(sistema.login(passwordIncorrecta, nombre));
		assertFalse(sistema.login(passwordIncorrecta, nombre));
		assertFalse(sistema.login(passwordIncorrecta, nombre));
		assertEquals((Integer)4, user.getCantidadLogueoMal());
		assertEquals((Integer)1, sistema.consultarBloqueados());
	}
	
	@Test(expected = UserNotFound.class)
	public void queNoSePuedaLoguearUnUsuario() throws InvalidPassword, UserNotFound {
		Sistema sistema =  new Sistema("Lightech");
		final String nombre = "Homero";
		final String password = "Hola1";
		
		UsuarioBasico user= new UsuarioBasico(nombre, password);
		
		sistema.login(password, nombre);
	}
	

	@Test(expected = InvalidPassword.class)
	public void queNoSePuedaGenerarUnUsuarioConpasswordInvalida() throws InvalidPassword, UserNotFound {
		Sistema sistema =  new Sistema("Lightech");
		final String nombre = "Homero";
		final String password = "hola";
		
		UsuarioBasico user= new UsuarioBasico(nombre, password);
	}
	
	@Test(expected= ClassCastException.class)
	public void queNoSePuedaEliminarUnAdministrador() throws InvalidPassword, UserNotFound,ClassCastException{
		
		Sistema sistema =  new Sistema("Lightech");
		final String nombre = "Homero";
		final String password = "Hola1!";
		
		UsuarioAdministrador user= new UsuarioAdministrador(nombre, password);

		sistema.agregarUsuario(user);
		
		sistema.eliminar(user);
	}
	
	
		
	
	
	
	

}
