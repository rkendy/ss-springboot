package br.uff.ihs.ss.exception;

public class ConflictException extends RuntimeException {

    private static final long serialVersionUID = 621657691395040287L;

    public ConflictException(final Class<?> clazz, String msg) {
        super("ConflictException with " + clazz.getSimpleName() + ": " + msg);
    }

}