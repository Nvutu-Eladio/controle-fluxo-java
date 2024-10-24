import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;



public class AboutMe {

    public static void main(String[] args) {
        
    try{
        // Consegue pegar os scanners do nosso terminal
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("digite seu nome: ");
        String nome = scanner.next();

        System.out.println("Digite seu sobrenome");
        String sobrenome = scanner.next();

        System.out.println("Digite sua idade");
        int idade = scanner.nextInt();

        System.out.println("Digite a sua altura");
        double altura = scanner.nextDouble();

        System.out.println("Ola, me chamo " + nome.toLowerCase() + " " + sobrenome.toLowerCase());
        System.out.println("Tenho " + idade + " anos ");
        System.out.println("Minha altura é " + altura + "cm");
    } catch (InputMismatchException e) {
        System.out.println("Os campos idade e altura precisam ser númericos");
     }

    }
}
