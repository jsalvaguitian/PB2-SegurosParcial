package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.TreeSet;

public class Sistema {

	private String nombre;
	private TreeSet<Usuario>  usuarios;
	private HashSet<Bloqueable>bloqueados;
	
	public Sistema(String nombre) {
		this.nombre = nombre;
		this.usuarios = new TreeSet<>();
		this.bloqueados = new HashSet<>();
	}

	public Integer getCantidadDeUsuarios() {
		return this.usuarios.size();
	}

	public void agregarUsuario(Usuario user) {
		this.usuarios.add(user);
	}

	public boolean login(String password, String nombre) throws UserNotFound {
		Usuario buscado = this.getUsuario(nombre);
		
		if(buscado!=null) {
			if(buscado.getPassword().equals(password)) {
				return true;
			}
			if(!(buscado.getPassword().equals(password)) && buscado instanceof UsuarioBasico) {
				if(((UsuarioBasico) buscado).getCantidadLogueoMal()<=3) {
					((UsuarioBasico) buscado).incrementarCantidadLogueoMal();
					return false;
				}
				if(((UsuarioBasico) buscado).getCantidadLogueoMal()>=4){
					((UsuarioBasico) buscado).setFueBloqueado(true);
					
					this.bloqueados.add((UsuarioBasico) buscado);
					return false;
				}
				
			}
		}else {
			throw new UserNotFound();
		}
		return false;
	}

	public Usuario getUsuario(String nombre) {
		for(Usuario uno :  this.usuarios) {
			if(uno.getNombre().equals(nombre))
				return uno;
		}
		return null;
	}

	public Integer consultarBloqueados() {
		return this.bloqueados.size();
	}

	public void eliminar(Usuario user) throws ClassCastException{
		if(user instanceof UsuarioAdministrador) {
			throw new ClassCastException();
		}else {
			if(user instanceof UsuarioBasico) {
				
			}
		}
	
		
	}

}
