package com.springboot.app.persistence.models;

public class TestModel {

    //Atributos 
    private String table;
    private String text;

    //Getters y setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
