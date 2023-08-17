package com.foryouinnet.common.controller;

import com.foryouinnet.common.exception.BusinessLogicException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler({BusinessLogicException.class})
    public ProblemDetail handleBusinessLogicException(BusinessLogicException exception) {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setProperty(ExceptionMedatataEnum.EXCEPTION_ID.toString(), exception.getExceptionEnum().name());
        problemDetail.setProperty(ExceptionMedatataEnum.DEFAULT_MESSAGE.toString(), exception.getExceptionEnum().toString());

        log.error(exception, exception);

        return problemDetail;
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ProblemDetail handleBusinessLogicException(ConstraintViolationException exception) {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        log.error(exception, exception);

        return problemDetail;
    }

    @ExceptionHandler({RuntimeException.class})
    public ProblemDetail handleRuntimeException(Throwable exception) {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setProperty("error", "unknown error");

        log.error(exception, exception);

        return problemDetail;
    }

    private enum ExceptionMedatataEnum {
        EXCEPTION_ID("exception_id"),
        MESSAGE_ID("message_id"),
        DEFAULT_MESSAGE("default_message");

        private String name;

        ExceptionMedatataEnum(String name) {
            this.name = name;
        }


        @Override
        public String toString() {

            return name;
        }
    }
}
