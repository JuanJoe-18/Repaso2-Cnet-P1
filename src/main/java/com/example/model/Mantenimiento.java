package com.example.model;

public class Mantenimiento {
    private int id;
    private String codigoMantenimiento;
    private String titulo;
    private String descripcion;
    private String tipoServicio;
    private String taller;
    private int nivelUrgencia;
    private int vehiculoId;

    public Mantenimiento(int id, String codigoMantenimiento, String titulo, String descripcion, String tipoServicio, String taller, int nivelUrgencia, int vehiculoId) {
        this.id = id;
        this.codigoMantenimiento = codigoMantenimiento;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoServicio = tipoServicio;
        this.taller = taller;
        this.nivelUrgencia = nivelUrgencia;
        this.vehiculoId = vehiculoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoMantenimiento() {
        return codigoMantenimiento;
    }

    public void setCodigoMantenimiento(String codigoMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(int nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }
}
