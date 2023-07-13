package ar.edu.unlam.pb2;

public class UsuarioAdministrador extends Usuario {

	public UsuarioAdministrador(String nombre, String password) throws InvalidPassword {
		super(nombre, password);
		
		if(!this.validarPassword(password)) {
			throw new InvalidPassword();
		}
	}

	@Override
	public boolean validarPassword(String password) {
		boolean tieneNumero = this.tieneNumero(password);;
		boolean tieneMinuscula = this.tieneMinuscula(password);
		boolean tieneMayuscula = this.tieneMayuscula(password);
		boolean tieneCaracterEspecial = this.tieneCaracterEspecial(password);
		boolean tieneUnaSecuenciaCaracteres = this.tieneSecuencia(password);
		
		if(tieneNumero && tieneMinuscula && tieneMayuscula && tieneCaracterEspecial && !tieneUnaSecuenciaCaracteres)
			return true;
		else
			return false;
	}

	private boolean tieneSecuencia(String password) {
		
		for(int i = 0; i < password.length(); i++) {
			
			
		}
		return false;
	}

	private boolean tieneCaracterEspecial(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) == '!' || password.charAt(i) == '*' || password.charAt(i) == '?'  || password.charAt(i) == '@') {
				return true;
			}
		}
		return false;
	}

	private boolean tieneMayuscula(String password) {
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

	private boolean tieneMinuscula(String password) {
		char letraA = 'a';
		char letraZ  = 'z';
		
		for(int i =0; i<password.length(); i++) {
			for(int j = (int)letraA; j<(int)(letraZ+1); j++) {
				if(password.charAt(i) == (char)j) {
					return true;
				}
			}
			
		}
		return false;
	}

	private boolean tieneNumero(String password) {
		for(int i= 0; i <password.length(); i++) {
			if(password.charAt(i) == '0' ||  password.charAt(i) == '1' ||  password.charAt(i) == '2' || password.charAt(i) == '3' ||  password.charAt(i) == '4' ||  password.charAt(i) == '5' ||  password.charAt(i) == '6' ||  password.charAt(i) == '7' ||  password.charAt(i) == '8' ||  password.charAt(i) == '9') {
				return true;
			}
		}
		return false;
	}

}
