package com.nutri.bitacoras.model.entiy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "usuario_id")
    private Long usuario_id;

    private String usuario;

    private String contraseña;







}
