package com.example.Monitoreo.servicio;

import com.example.Monitoreo.entidad.Boya;
import com.example.Monitoreo.entidad.Muestra;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoyaServicioImpl implements BoyaServicio{

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
    public Boya actualizarColorDeLuz(Long id, String color) {
        return null;
    }

    @Override
    public Muestra registrarMuestra(Muestra muestra) {
        return null;
    }

    @Override
    public List<Muestra> obtenerMuestraPorIdDeBoya(Long idBoya) {
        return null;
    }

    @Override
    public void resetearColorDeLuz(Long id) {

    }

    @Override
    public void resetearColor(Long id) {

    }
}
