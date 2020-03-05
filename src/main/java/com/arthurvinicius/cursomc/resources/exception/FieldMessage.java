package com.arthurvinicius.cursomc.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fielName;
    private String menssage;

    public FieldMessage() {

    }

    public FieldMessage(final String fielName, final String menssage) {
        super();
        this.fielName = fielName;
        this.menssage = menssage;
    }

    public String getFielName() {
        return fielName;
    }

    public void setFielName(final String fielName) {
        this.fielName = fielName;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(final String menssage) {
        this.menssage = menssage;
    }

}
