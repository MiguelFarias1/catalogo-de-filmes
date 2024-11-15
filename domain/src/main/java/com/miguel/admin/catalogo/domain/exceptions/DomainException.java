package com.miguel.admin.catalogo.domain.exceptions;

import java.util.List;
import com.miguel.admin.catalogo.domain.validation.Error;

public class DomainException extends NoStackTraceException {

    private final List<Error> errors;

    private DomainException(final String message, final List<Error> errors) {
        super(message);
        this.errors = errors;
    }

    public static DomainException with(final Error error) {
        return new DomainException("", List.of(error));
    }

    public static DomainException with(final List<Error> errors) {
        return new DomainException("", errors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
