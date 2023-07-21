package com.example.Monitoreo.controlador;

import com.example.Monitoreo.entidad.Boya;
import com.example.Monitoreo.servicio.BoyaServicio;
import com.example.Monitoreo.servicio.MuestraServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/boyas")
public class
BoyaControlador {
     private final BoyaServicio boyaServicio;
     private final MuestraServicio muestraServicio;


    public BoyaControlador(BoyaServicio boyaServicio, MuestraServicio muestraServicio) {
        this.boyaServicio = boyaServicio;
        this.muestraServicio = muestraServicio;
    }

    @PostMapping("/boyas")
    public ResponseEntity<Boya> crearBoya(@RequestBody Boya boya) {
        Boya nuevaBoya = boyaServicio.crearBoya(boya);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaBoya);
    }

    @GetMapping("/listaboyas")
    public ResponseEntity<List<Boya>> listarBoyas() {
        List<Boya> boyas = boyaServicio.listarBoyas();
        return ResponseEntity.ok(boyas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boya> obtenerBoyaPorId(@PathVariable Long id) {
        Boya boya = boyaServicio.obtenerBoyaPorId(id);
        if (boya != null) {
            boya.setMuestras(null);
            return ResponseEntity.ok(boya);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/boyas/{id}")
    public ResponseEntity<Boya> actualizarColorLuz(@PathVariable Long id, @RequestBody String color) {
        Boya boya = boyaServicio.obtenerBoyaPorId(id);
        if (boya != null) {
            boya.setColorLuz(color);
            Boya boyaActualizada = boyaServicio.actualizarBoya(boya);
            return ResponseEntity.ok(boyaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boya> actualizarBoya(@PathVariable Long id, @RequestBody Boya boyaActualizada) {
        Boya boyaExistente = boyaServicio.obtenerBoyaPorId(id);
        if (boyaExistente != null) {
            boyaExistente.setColorLuz(boyaActualizada.getColorLuz());
            boyaExistente.setLongitudInstalacion(boyaActualizada.getLongitudInstalacion());
            boyaExistente.setLatitudInstalacion(boyaActualizada.getLatitudInstalacion());

            Boya boyaActualizadaObj = boyaServicio.actualizarBoya(boyaExistente);
            return ResponseEntity.ok(boyaActualizadaObj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
