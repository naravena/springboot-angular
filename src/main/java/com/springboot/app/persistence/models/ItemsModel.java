package com.springboot.app.persistence.models;
public class ItemsModel {
    //Atributos
    private int id;
    private String nombre;
    private String descripcion;
    private String url;
    private String datoBuscador;

   
    //Getters y setters
    
    
     public String getDatoBuscador() {
        return datoBuscador;
    }

    public void setDatoBuscador(String datoBuscador) {
        this.datoBuscador = datoBuscador;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
}
