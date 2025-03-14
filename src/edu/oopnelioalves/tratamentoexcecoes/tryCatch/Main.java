package edu.oopnelioalves.tratamentoexcecoes.tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        method1();

        System.out.println("Fim da execução do apliticativo!");        

    }

    public static void method1(){
        System.out.println("Início do method1");
        method2();
        System.out.println("Fim do method1");
    }

    public static void method2(){ //tratamento de excecoes esta nesse metodo
        System.out.println("Início da execução do method2");
        Scanner scanner = new Scanner(System.in);        
        
        try {
            String [] v = scanner.nextLine().split(" ");
            int position = scanner.nextInt();
            System.out.println(v[position]);
    
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Posição inválida");
            e.printStackTrace(); // imprime o rastreiamento do stack
            /**
             * ferramenta útil para verificar a cadeia de chamadas de métodos
             * java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 3
            at edu.oopnelioalves.tratamentoexcecoes.Main.method2(Main.java:29)
            at edu.oopnelioalves.tratamentoexcecoes.Main.method1(Main.java:18) - o método 1 chamou o método 2 na linha 18
            at edu.oopnelioalves.tratamentoexcecoes.Main.main(Main.java:10)
             * 
             */
        } catch (InputMismatchException f) {
            System.out.println("Valor inválido informado!");
            f.printStackTrace();
        }

        //possíveis erros que podem acontecer: inputMistmatch e arrayOutofBounds
        //se a exceção não estiver tratada, o software para de funcionar

        scanner.close();
        System.out.println("Fim da execução do method2");
    }

}
