package edu.oopnelioalves.tratamentoexcecoes.excecoespersonalizadas.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration() {
        long diff = checkout.getTime() - checkin.getTime(); // pega a diferenca entre as duas datas em milissegundos
        TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte para dias o que está no argumento, ou seja, o tempo em mili
        return diff;
    }

    public void updateDates (Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Reservation: Room: " +  sdf.format(getRoomNumber()) + ", checkin " + sdf.format(getCheckin())  +", checkout" + getCheckout() + ", nights";
    }

    
}
