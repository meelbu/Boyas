package com.example.Monitoreo.servicio;

import com.example.Monitoreo.entidad.Boya;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoyaServicioImpl implements BoyaServicio {

    @Override
    public Boya crearBoya(Boya boya) {
        return null;
    }

    @Override
    public List<Boya> listarBoyas() {
        return null;
    }

    @Override
    public Boya obtenerBoyaPorId(Long id) {
        return null;
    }

    @Override
    public Boya actualizarColorLuz() {
        return null;
    }

    @Override
    public void actualizarColorLuz(Long id) {

    }

    @Override
    public Boya actualizarBoya(Boya boya) {

        return boya;
    }

}
