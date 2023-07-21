package com.example.Monitoreo.servicio;

import com.example.Monitoreo.entidad.Muestra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MuestraServicioImpl implements MuestraServicio{

    private List<Muestra> muestras;

    public MuestraServicioImpl(){
        this.muestras = new ArrayList<>();
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
    public Muestra obtenerColor(Muestra muestra) {
        return null;
    }

    @Override
    public void eliminarMuestra(Long id) {

    }

    @Override
    public Muestra obtenerMuestraPorId(Long id) {
        return null;
    }


}
