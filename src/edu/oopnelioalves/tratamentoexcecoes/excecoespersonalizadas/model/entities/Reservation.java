package edu.oopnelioalves.tratamentoexcecoes.excecoespersonalizadas.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import edu.oopnelioalves.tratamentoexcecoes.excecoespersonalizadas.model.exception.DomainException;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
        if (!checkout.after(checkin)) {
            throw new DomainException("Data de checkout tem ser depois da data de checkin");
        }
        
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

    //é possível retornar e também FAZER algo dentro de um método
    public void updateDates (Date checkin, Date checkout) throws DomainException{
            
        Date now = new Date();
            //se a data de checkin ou checkout são anteriores às datas anteriores
        if (checkin.before(now) || checkout.before(now)) {
            //utilização de classe de exceção já pronta no java
            throw new DomainException("Datas de reserva devem ser posteriores a data de hoje.") ;
        }
        if (!checkout.after(checkin)) {
            throw new DomainException("Data de checkout tem ser depois da data de checkin");
        }        
        
        this.checkin = checkin;
        this.checkout = checkout;        
    }

    @Override
    public String toString() {
        return "Reservation: Room: " +  sdf.format(getRoomNumber()) + ", checkin " + sdf.format(getCheckin())  +", checkout" + getCheckout() + ", nights";
    }

    
}
