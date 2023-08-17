package com.foryouinnet.common.exception;


import com.foryouinnet.common.model.enumeration.ExceptionRepresentation;
import lombok.Getter;

@Getter
public class BusinessLogicException extends RuntimeException {

    private final Enum<?> exceptionEnum;

    public BusinessLogicException(ExceptionRepresentation exceptionRepresentation) {
        super(exceptionRepresentation.getMessage());
        this.exceptionEnum = (Enum<?>) exceptionRepresentation;
    }

}
