package com.nutri.bitacoras.model.entiy;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;


@Getter
@Setter
@Entity
@Table (name="REGIS_DESIGNACION_EQUI_COMPUTO")
public class BitacorasPedido {

    //registrodeasignaciondeequiposdecomputo

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_regis;
    private String tec_responsable;  //tecnico responsable
    private String emp_solicitante;  //empleado soicitante
    private String disp_entregados;//dispositivos entregados

    private String seriedisp;
    private Date fecha_entrega;//fecha entrega
    private String observacionesfe; //obsevaciones
    private Date fecha_devolucion;//fecha devolucion
    private String observacionesfd; //obsevaciones

    private String estadofp; //obsevaciones
    private String estado;
    
}
