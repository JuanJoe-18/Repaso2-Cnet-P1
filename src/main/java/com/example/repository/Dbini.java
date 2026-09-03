package com.example.repository;

import com.example.model.Mantenimiento;
import com.example.model.Vehiculo;

public class Dbini {

    private final IVehiculoRepository vehiculoRepository;
    private final IMantenimientoRepository mantenimientoRepository;

    public Dbini(IVehiculoRepository vehiculoRepository, IMantenimientoRepository mantenimientoRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.mantenimientoRepository = mantenimientoRepository;
    }

    public void initData() {
        Vehiculo v1 = new Vehiculo(1, "Corolla", "Toyota", "ABC-123", "Carlos Perez", "2023-01-15", "Activo");
        Vehiculo v2 = new Vehiculo(2, "Civic", "Honda", "XYZ-789", "Ana Gomez", "2022-05-20", "Activo");
        Vehiculo v3 = new Vehiculo(3, "Spark", "Chevrolet", "OLD-999", "Luis Ramos", "2015-10-10", "DadoDeBaja");
        vehiculoRepository.add(v1);
        vehiculoRepository.add(v2);
        vehiculoRepository.add(v3);

        Mantenimiento m1 = new Mantenimiento(1, "MNT-001", "Cambio de aceite", "Cambio de aceite sintético y filtro", "Preventivo", "Taller Central", 2, 1);
        mantenimientoRepository.add(m1);
        v1.addMantenimiento(m1);
    }
}
