package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
    private int id;
    private String modelo;
    private String marca;
    private String placa;
    private String conductor;
    private String fechaIngreso;
    private String estado;
    private List<Mantenimiento> mantenimientos;

    public Vehiculo(int id, String modelo, String marca, String placa, String conductor, String fechaIngreso, String estado) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.conductor = conductor;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.mantenimientos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public void addMantenimiento(Mantenimiento mantenimiento) {
        if (!mantenimientos.contains(mantenimiento)) {
            this.mantenimientos.add(mantenimiento);
        }
    }
}
