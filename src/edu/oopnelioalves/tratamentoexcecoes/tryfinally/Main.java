package edu.oopnelioalves.tratamentoexcecoes.tryfinally;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("src\\edu\\oopnelioalves\\tratamentoexcecoes\\tryfinally\\in.txt"); 
        //inicialmente, declarar apenas que o Scanner existe
        Scanner sc = null;
        
        try{
            sc = new Scanner(file); 
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        
        // o que foi capturado: foi capturada a exceção de que o arquivo não existe (renomear o arquivo para n.txt)    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro detectado: " + e.getMessage());
        
        // independente se houve o tratamento de exceções ou não, executar isto aqui. Se o scanner foi alocado, fechar
        } finally { //o bloco finally executa instruções independentemente de ter encontrado excecoes
            if (sc != null)  {
                sc.close();
            }

        }
    }
}
