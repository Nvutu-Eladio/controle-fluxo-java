public class ContinueBreak {
    
    public static void main(String[] args) {
        for (int numero = 1; numero <= 5; numero++) {
            if (numero == 3) {
                // break; para a execução
                continue; // pula a execução
            }
            System.out.println(numero);
        }
    }
}
