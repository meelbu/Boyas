package com.example.Monitoreo.entidad;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "muestra")
public class Muestra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "boya_id")
    private Boya boya;

    private LocalDateTime horarioMuestra;

    private String matriculaEmbarcacion;

    private double longitud;

    private double latitud;

    private double alturaNivelDelMar;

    public Muestra() {
    }

    public Muestra(Long id, Boya boya, LocalDateTime horarioMuestra, String matriculaEmbarcacion, double longitud, double latitud, double alturaNivelDelMar) {
        this.id = id;
        this.boya = boya;
        this.horarioMuestra = horarioMuestra;
        this.matriculaEmbarcacion = matriculaEmbarcacion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.alturaNivelDelMar = alturaNivelDelMar;
    }

    public Long getId() {
        return id;
    }

    public Boya getBoya() {
        return boya;
    }

    public LocalDateTime getHorarioMuestra() {
        return horarioMuestra;
    }

    public String getMatriculaEmbarcacion() {
        return matriculaEmbarcacion;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getAlturaNivelDelMar() {
        return alturaNivelDelMar;
    }
}
