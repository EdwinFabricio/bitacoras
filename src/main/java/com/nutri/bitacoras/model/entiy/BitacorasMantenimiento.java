package com.nutri.bitacoras.model.entiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="REGISTRO_RECEPCION_DE_EQUPOS DE COMPUTO PARA MANTENIMIENTO")
public class BitacorasMantenimiento {
    //registro de recepcion de equipos para mantenimiento preventivo/correctivo

    /*
    *tecnico responsable
    * empleado solicitante
    * fechas---->
    * fehcas de entrega y fechas de devolucion
    * observaciones
    * dispositivo */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;
    private String tecnico_resonsable;
    private String empleado_solicitante;

    private Date fecha_entrega;
    private Date fecha_devolucion;

    private String observaciones;

    private String dispositivo_receptado;

    /*
    *DATOS DEL EQUIPO
    * */

    private String usuario_ad;

    private String nombre_equipo;
    private String marca;
    private String modelo;
    private String garantia;

    private  String serie;
    private String anio;

    private String tcp_ip;
    private String mac;

    //----actividades realizadas---//

    //software
    private String analisismalware;
    private String analisis_malwareobs;
    //----------------//
    private String respaldopst;
    private String respaldo_pstobs;
//------------------------//
    private String creacionpst;
    private String creacion_pstobs;
    //----//
    private String respaldoinformacion;
    private  String respaldo_informacionobs;
    //------//
    private  String validacionnas;

    private String validacion_nasobs;
//------//
    private String actualizacionnav;
    private String actualizacion_navegadoresobs;
//----//
    private String permisosadmin;
    private String permisos_administradorobs;
    //hardware
private String limpieza_ext;
    private String limpieza_externa;
    private String limpiezaexternaobs;

    private String limpieza_int;
    private  String limpieza_internaobs;

private String proceso_mejora;

}
