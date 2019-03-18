import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> arrayUsuario = new ArrayList<>();
    ArrayList<Integer> arraySenha = new ArrayList<>();
    private ArrayList<Double> arraySaldo = new ArrayList<>();

    //Atributos
    private int login;
    private int senha;
    private int posicao;
    private double saldo;

    //Métodos
    public void registrar() {
        int opcao = 0;
        boolean cadastrando = true;
        while (cadastrando) {
            System.out.println("Informe um ID númerico desejado para cadastro.");
            login = input.nextInt();
            System.out.println("Informe uma senha númerica desejado para cadastro.");
            senha = input.nextInt();
            arrayUsuario.add(login);
            arraySenha.add(senha);
            arraySaldo.add(0.0);
            System.out.println("Deseja continuar cadastrando?\n" +
                    "0 - Não" +
                    "\n1 - Sim");
            opcao = input.nextInt();
            if (opcao == 0) {
                cadastrando = false;
                System.out.println("Você será redirecionado ao login de usuário.");
            }else;
            if (opcao == 1) {
                cadastrando = true;
            }
        }
    }
    public int  validar() {
        int opcao = 0;
        System.out.println("Digite o seu número de ID: ");
        login = input.nextInt();
        System.out.println("Digite sua senha:");
        senha = input.nextInt();
        try {
            posicao = arrayUsuario.indexOf(login);
            if (arraySenha.get(posicao) != senha) {
                posicao = -1;
                System.out.println("A senha informada está incorreta");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            posicao = -1;
        }
        return posicao;
    }
    public void sacar(int posicao) {
        double saque = 0;
        System.out.println("Informe o valor que deseja sacar");
        saque = input.nextInt();
        if (arraySaldo.get(posicao) < saque){
            System.out.println("O valor de saque excede seu saldo!");
        }else {
            arraySaldo.set(posicao, (arraySaldo.get(posicao) - saque));
            System.out.println("Saque efetuado com sucesso");
        }
    }
    public void consultaSaldo(){
        System.out.println("Seu saldo atual é de: R$" +arraySaldo);
    }
    public void depositar(){
        double deposito = 0;
        System.out.println("Informe o valor que deseja depositar.");
        deposito = input.nextInt();
        arraySaldo.set(posicao,(arraySaldo.get(posicao) + deposito));
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
