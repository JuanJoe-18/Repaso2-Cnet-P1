package com.example.service;

import com.example.model.Mantenimiento;

import java.util.List;

public interface IMantenimientoService {
    void add(Mantenimiento mantenimiento);
    List<Mantenimiento> list();
    List<Mantenimiento> findByVehiculoId(int vehiculoId);
}
