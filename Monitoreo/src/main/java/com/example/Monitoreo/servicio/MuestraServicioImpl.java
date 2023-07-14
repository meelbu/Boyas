package com.example.Monitoreo.servicio;

import com.example.Monitoreo.entidad.Muestra;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuestraServicioImpl implements MuestraServicio{
    @Override
    public Muestra registrarMuestra(Long BoyaId, Muestra muestra) {
        return null;
    }

    @Override
    public Muestra registrarMuestra(Muestra muestra) {
        return null;
    }

    @Override
    public List<Muestra> listarMuestras() {
        return null;
    }

    @Override
    public List<Muestra> obtenerMuestraPorIdDeBoya(Long idBoya, Long idMuestra) {
        return null;
    }

    @Override
    public List<Muestra> obtenerMuestraPorIdDeBoya(Long idBoya) {
        return null;
    }

    @Override
    public void eliminarMuestra(Long id) {

    }


}
