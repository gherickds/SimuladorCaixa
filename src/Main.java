import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;
        int opcao2 = 0;
        Scanner scan = new Scanner(System.in);
        Usuario user = new Usuario();

        System.out.println("Escolha uma das opções: \n" +
                "1 - Registrar." +
                "\n2 - Entrar.");
        opcao = scan.nextInt();
        switch (opcao) {
            case 1:
                user.registrar();
            case 2:
                int posicao = user.validar();
                if (posicao == -1) {
                    break;
                }else{
                    opcao2 = 0;
                    while (opcao2 != 4) {
                        System.out.println("Escolha uma das operações: \n" +
                                "1 - Consultar saldo" +
                                "\n2 - Efetuar depósito" +
                                "\n3 - Efetuar saque" +
                                "\n4 - Logout");
                        opcao2 = scan.nextInt();
                        switch (opcao2) {
                            case 1:
                                user.consultaSaldo();
                                break;
                            case 2:
                                user.depositar();
                                break;
                            case 3:
                                user.sacar(posicao);
                                break;
                            case 4:
                                System.out.println("Você se desconectou.");
                                break;
                        }
                    }
                }
        }
    }
}
