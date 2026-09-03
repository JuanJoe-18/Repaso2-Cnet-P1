package com.example.config;

import com.example.repository.Dbini;
import com.example.repository.IMantenimientoRepository;
import com.example.repository.IVehiculoRepository;
import com.example.repository.impl.MantenimientoRepositoryImpl;
import com.example.repository.impl.VehiculoRepositoryImpl;
import com.example.service.IMantenimientoService;
import com.example.service.IVehiculoService;
import com.example.service.impl.MantenimientoServiceImpl;
import com.example.service.impl.VehiculoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public IVehiculoRepository vehiculoRepository() {
        return new VehiculoRepositoryImpl();
    }

    @Bean
    public IMantenimientoRepository mantenimientoRepository() {
        return new MantenimientoRepositoryImpl();
    }

    @Bean
    public IVehiculoService vehiculoService(IVehiculoRepository repository) {
        return new VehiculoServiceImpl(repository);
    }

    @Bean
    public IMantenimientoService mantenimientoService(IMantenimientoRepository mantenimientos, IVehiculoRepository vehiculos) {
        return new MantenimientoServiceImpl(mantenimientos, vehiculos);
    }

    @Bean(initMethod = "initData")
    public Dbini dbini(IVehiculoRepository vehiculoRepository, IMantenimientoRepository mantenimientoRepository) {
        return new Dbini(vehiculoRepository, mantenimientoRepository);
    }
}
