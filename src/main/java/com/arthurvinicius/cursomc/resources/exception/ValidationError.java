package com.arthurvinicius.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);

    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErro(String fieldName, String messagem) {
        errors.add(new FieldMessage(fieldName, messagem));
    }
}
