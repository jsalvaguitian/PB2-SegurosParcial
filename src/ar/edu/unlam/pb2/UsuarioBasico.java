package ar.edu.unlam.pb2;

public class UsuarioBasico extends Usuario implements Bloqueable, Eliminable{

	private Integer cantidadLogueoMal;
	private Boolean fueEliminado;
	private Boolean fueBloqueado;
	
	public UsuarioBasico(String nombre, String password) throws InvalidPassword {
		super(nombre, password);
		
		if(!this.validarPassword(password))
			throw new InvalidPassword();
		
		cantidadLogueoMal =0;
		fueEliminado = false;
		fueBloqueado = false;
	}

	@Override
	public boolean validarPassword(String password) {
		boolean tieneNumero = this.tieneNumero(password);;
		boolean tieneMinuscula = this.tieneMinuscula(password);
		boolean tieneMayuscula = this.tieneMayuscula(password);
		
		if(tieneMayuscula && tieneMinuscula && tieneNumero) {
			return true;
		}else
			return false;
	}

	public boolean tieneMayuscula(String password) {
		char letraA = 'A';
		char letraZ  = 'Z';
		
		for(int i =0; i<password.length(); i++) {
			for(int j = (int)letraA; j<(int)(letraZ+1); j++) {
				if(password.charAt(i) == (char)j) {
					return true;
				}
			}
			
		}
		return false;
	}

	public boolean tieneNumero(String password) {
		for(int i= 0; i <password.length(); i++) {
			if(password.charAt(i) == '0' ||  password.charAt(i) == '1' ||  password.charAt(i) == '2' || password.charAt(i) == '3' ||  password.charAt(i) == '4' ||  password.charAt(i) == '5' ||  password.charAt(i) == '6' ||  password.charAt(i) == '7' ||  password.charAt(i) == '8' ||  password.charAt(i) == '9') {
				return true;
			}
		}
		return false;
	}
	
	public boolean tieneMinuscula(String pwd) {
		char letraA = 'a';
		char letraZ  = 'z';
		
		for(int i =0; i<pwd.length(); i++) {
			for(int j = (int)letraA; j<(int)(letraZ+1); j++) {
				if(pwd.charAt(i) == (char)j) {
					return true;
				}
			}
			
		}
		return false;
	}

	public Integer getCantidadLogueoMal() {
		return cantidadLogueoMal;
	}

	public Boolean getFueEliminado() {
		return fueEliminado;
	}
	public void incrementarCantidadLogueoMal() {
		this.cantidadLogueoMal++;
	}

	public Boolean getFueBloqueado() {
		return fueBloqueado;
	}

	public void setFueBloqueado(Boolean fueBloqueado) {
		this.fueBloqueado = fueBloqueado;
	}

	public void setCantidadLogueoMal(Integer cantidadLogueoMal) {
		this.cantidadLogueoMal = cantidadLogueoMal;
	}

	public void setFueEliminado(Boolean fueEliminado) {
		this.fueEliminado = fueEliminado;
	}
	

	
	
}
