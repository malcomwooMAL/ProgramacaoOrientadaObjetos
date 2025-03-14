package edu.oopnelioalves.tratamentoexcecoes.excecoespersonalizadas.model.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import edu.oopnelioalves.tratamentoexcecoes.excecoespersonalizadas.model.entities.Reservation;

public class Main {
    public static void main(String[] args) throws ParseException { // propaga a exceção para ser tratada em outro método
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyu");

        System.out.println("Digite o número do quarto: ");
        int number = sc.nextInt();
        System.out.println("Digite a data de checkIn (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.println("Informe a data de checkout: ");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkin)) System.out.println("Datas Inválidas. Data de entrada posterior a saída");
        else {
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reserva realizada!");


            System.out.println("Atualize as informações da reserva: ");
            System.out.println("Digite a data de checkIn (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.println("Informe a data de checkout: ");
            checkout = sdf.parse(sc.next());

            String error = reservation.updateDates(checkin, checkout);
            if (error != null)  System.out.println("Erro na reserva: " + error);
            else System.out.println("Reservation" + reservation);
        }    
        

    }
}
