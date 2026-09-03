package com.example.service;

import com.example.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    void add(Vehiculo vehiculo);
    List<Vehiculo> list();
}
