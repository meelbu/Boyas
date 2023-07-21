package com.example.Monitoreo.entidad;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "muestra")
public class Muestra{

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

    @PrePersist
    public void asignarHorarioDeMuestra() {
        horarioMuestra = LocalDateTime.now();
    }

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

    public void setBoya(Boya boya) {
        this.boya = boya;
    }

    public double getAlturaNivelDelMar() {
        return alturaNivelDelMar;
    }


}


