package controladores;

import dados.BibliotecarioDados;
import dados.ExcecaoDados;

public class BibliotecarioControlador {
	
	private BibliotecarioDados dados = new BibliotecarioDados();

	public void login(String nome, String email, String senha) throws Exception, ExcecaoControlador {
		
		if(nome.isBlank()) {
			throw new ExcecaoControlador("O campo nome não pode ser vazio.");
		}
		
		if(!nome.matches("^[a-zA-Z,\\s]+$")){
			throw new ExcecaoControlador("O campo nome não pode ter números.");
		}
		
		if(email.isBlank()) {
			throw new ExcecaoControlador("O campo email não pode ser vazio.");
		}
		
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z.]+$")) {
			throw new ExcecaoControlador("Caracteres Invalidos digitados no campo Email.");
		}
		
		if(senha.isBlank()) {
			throw new ExcecaoControlador("O campo senha não pode ser vazio.");
		}
		
		if(!dados.verificarNomeBibliotecario(nome)) {
			throw new ExcecaoControlador("Nome de usuario não encontrado.");
		}
		
		if(!dados.verificarEmailBibliotecario(email)) {
			throw new ExcecaoControlador("Email de usuário não encontrado.");
		}
		
		if(!dados.verificarSenha(senha)) {
			throw new ExcecaoControlador("Senha incorreta.");
		}
		
	}
}
