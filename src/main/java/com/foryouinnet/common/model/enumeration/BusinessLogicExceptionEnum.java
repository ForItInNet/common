package com.foryouinnet.common.model.enumeration;

public enum BusinessLogicExceptionEnum {
    ;

    public enum AccountService implements ExceptionRepresentation {
        EXISTS_BY_EMAIL_OR_USERNAME("Account with the same email or username already exists"),
        WRONG_EMAIL_OR_PASSWORD("Wrong email or password"),
        UPDATING_TIMEOUT("Updating timeout");

        private final String message;

        AccountService(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public enum RegistrationService implements ExceptionRepresentation {
        EXISTS_BY_EMAIL_OR_USERNAME("Registration request with the same email or username already exists. Please wait a few minute after moment of registration"),
        NOT_EXIST_OR_EXPIRED("Registration request expired or not exist"),;

        private final String message;

        RegistrationService(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public enum ConfirmationService implements ExceptionRepresentation {
        WRONG_REGISTRATION_ID_OR_CODE("Wrong registration id or code"),
        CONFIRMATION_CODE_SENDING_PAUSE("Code resending pause");

        private String message;

        ConfirmationService(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public enum MessageService implements ExceptionRepresentation {
        CONFIRMATION_CODE_SENDING_PAUSE("Code resending pause");

        private final String message;

        MessageService(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
}

