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
        String[] enumPath = exception.getExceptionEnum().getClass().getCanonicalName().split("\\.");
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setProperty(ExceptionMedatataEnum.GROUP_ID.toString(), enumPath[enumPath.length - 1]);
        problemDetail.setProperty(ExceptionMedatataEnum.EXCEPTION_ID.toString(), exception.getExceptionEnum().name());
        problemDetail.setProperty(ExceptionMedatataEnum.DEFAULT_MESSAGE.toString(), exception.getMessage());

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
        GROUP_ID("groupId"),
        EXCEPTION_ID("exceptionId"),
        MESSAGE_ID("messageId"),
        DEFAULT_MESSAGE("defaultMessage");

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
