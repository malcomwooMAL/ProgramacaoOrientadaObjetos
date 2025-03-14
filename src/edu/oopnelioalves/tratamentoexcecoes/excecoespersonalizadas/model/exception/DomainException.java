package edu.oopnelioalves.tratamentoexcecoes.excecoespersonalizadas.model.exception;

public class DomainException extends Exception{ //exception - excecao que obriga o dev a tratar
    public DomainException(String msg) {
        super(msg);
    }
}
