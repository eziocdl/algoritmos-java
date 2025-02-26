package algoritmos_exercicios;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *  Resolvendo o algoritmo de validacao de senha com regex**/

public class ValidacaoSenha {
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a senha com no mínimo 8 caracteres: ");
		String senha = sc.nextLine();
		
		if(!validarSenha(senha)) {
			
			System.out.println("Senha inválida! ");
			
		} else {
			
			System.out.println("Senha válida.");
		}
		
		
		
		
		
		sc.close();
	}
	
	
	
	// validacao da senha, verificando todos os critérios a serem vistos
	
	
	private static boolean validarSenha(String senha) {
		
		// utilizando regex para reduzir boilerplate(códigos repetitivos)
		
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$";
		
		// compila a expressao regular(regex)
		
		Pattern pattern = Pattern.compile(regex);
		
		
		// cria um objeto Matcher para comparar a senha com o padrão solicitado na expressao regular
		
		Matcher matcher = pattern.matcher(senha);
		
		// verifica se a senha corresponde ao padrão e retorna o resultado:
		
		
		return matcher.matches();
	};
	

}
