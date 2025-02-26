package algoritmos_exercicios;

import java.util.Locale;
import java.util.Scanner;

public class ValidacaoEmail {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o seu email: ");
        String email = sc.nextLine();

        if (validarEmail(email)) {
            System.out.println("Email válido!");
        } else {
            System.out.println("Email inválido!");
        }

        sc.close();
    }

    private static boolean validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            return false;
        }

        String[] partes = email.split("@");
        if (partes.length != 2) { // Deve ter exatamente um '@'
            return false;
        }

        String parteLocal = partes[0];
        String dominio = partes[1];

        return validarParteLocal(parteLocal) && validarDominio(dominio);
    }

    private static boolean validarParteLocal(String parteLocal) {
        return !parteLocal.isEmpty() && parteLocal.matches("^[a-zA-Z0-9._-]+$");
    }

    private static boolean validarDominio(String dominio) {
        if (dominio.isEmpty() || dominio.startsWith(".") || dominio.endsWith(".") || dominio.contains("..")) {
            return false;
        }

        String[] partes = dominio.split("\\.");
        if (partes.length < 2) { // Deve haver pelo menos um subdomínio e um TLD
            return false;
        }

        String tld = partes[partes.length - 1]; // Última parte (TLD)
        if (!tld.matches("^[a-zA-Z]{2,}$")) { // TLD deve ter pelo menos 2 letras (ex: .com, .br)
            return false;
        }

        for (String parte : partes) {
            if (!parte.matches("^[a-zA-Z0-9-]+$")) {
                return false;
            }
        }
        return true;
    }
}
