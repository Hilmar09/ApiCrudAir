package com.ApiCrudAir.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class UserCommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long user;

    @Column
    private String ciudad;

    
    @Column
    private Long calidadAire;
    
    @Column
    private Boolean vive;
    
    @Column
    private Integer valoracion;
    
    @Column
    private String comentario;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
    
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getCalidadAire() {
        return calidadAire;
    }

    public void setCalidadAire(Long calidadAire) {
        this.calidadAire = calidadAire;
    }

    public Boolean getVive() {
        return vive;
    }

    public void setVive(Boolean vive) {
        this.vive = vive;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
