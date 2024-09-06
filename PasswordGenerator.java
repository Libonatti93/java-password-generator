import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    // Caracteres permitidos para gerar a senha
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Gerador de Senhas!");
        
        // Solicita o comprimento da senha
        System.out.print("Digite o comprimento desejado para a senha: ");
        int length = scanner.nextInt();
        
        // Solicita as opções de composição da senha
        System.out.print("Incluir letras maiúsculas? (s/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("s");
        
        System.out.print("Incluir números? (s/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("s");
        
        System.out.print("Incluir símbolos? (s/n): ");
        boolean includeSymbols = scanner.next().equalsIgnoreCase("s");

        // Gera a senha com as opções especificadas
        String password = generatePassword(length, includeUppercase, includeNumbers, includeSymbols);
        System.out.println("Sua senha gerada é: " + password);

        scanner.close();
    }

    /**
     * Gera uma senha com base nas opções especificadas pelo usuário.
     *
     * @param length          Comprimento da senha.
     * @param includeUppercase Se deve incluir letras maiúsculas.
     * @param includeNumbers   Se deve incluir números.
     * @param includeSymbols   Se deve incluir símbolos.
     * @return Senha gerada como uma string.
     */
    public static String generatePassword(int length, boolean includeUppercase, boolean includeNumbers, boolean includeSymbols) {
        String characterSet = LOWERCASE_LETTERS; // Começa com letras minúsculas

        // Adiciona conjuntos de caracteres conforme as preferências do usuário
        if (includeUppercase) {
            characterSet += UPPERCASE_LETTERS;
        }
        if (includeNumbers) {
            characterSet += NUMBERS;
        }
        if (includeSymbols) {
            characterSet += SYMBOLS;
        }

        // Verifica se há pelo menos um conjunto de caracteres disponível
        if (characterSet.isEmpty()) {
            throw new IllegalArgumentException("Nenhum conjunto de caracteres selecionado para gerar a senha.");
        }

        // Usa SecureRandom para gerar senhas de forma segura
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        // Gera a senha com o comprimento especificado
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(randomIndex));
        }

        return password.toString();
    }
}
