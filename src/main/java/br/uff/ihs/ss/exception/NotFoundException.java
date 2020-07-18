package br.uff.ihs.ss.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -5872964667629019784L;

    public NotFoundException(final Class<?> clazz, final Long id) {
        super("NotFoundException with " + clazz.getSimpleName() + " and id " + id);
    }

}