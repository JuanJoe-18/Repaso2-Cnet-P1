package com.example.repository;

import com.example.model.Vehiculo;
import java.util.List;

public interface IVehiculoRepository {
    void add(Vehiculo vehiculo);
    List<Vehiculo> list();
}
