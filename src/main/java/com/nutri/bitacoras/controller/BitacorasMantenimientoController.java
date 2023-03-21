package com.nutri.bitacoras.controller;

import com.nutri.bitacoras.exception.AppException;
import com.nutri.bitacoras.model.entiy.BitacorasMantenimiento;
import com.nutri.bitacoras.service.impl.BitacorasMantenimientoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/mantenimiento")
public class BitacorasMantenimientoController {

    @Autowired
    private BitacorasMantenimientoServiceImpl  bitacorasMantenimientoService;


    @GetMapping
    public ResponseEntity<List<?>> list(){
        return ResponseEntity.ok(bitacorasMantenimientoService.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> findById(@PathVariable Long id){
        return  ResponseEntity.ok(bitacorasMantenimientoService.findById(id));
    }

    @PostMapping
    public  ResponseEntity<?>create (@Valid @RequestBody BitacorasMantenimiento bitacorasMantenimiento){
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(bitacorasMantenimientoService.save(bitacorasMantenimiento));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody BitacorasMantenimiento bitacorasMantenimiento){
       BitacorasMantenimiento bitacorasMantenimientoFromDb= bitacorasMantenimientoService.findById(id);
     /* if(!bitacorasMantenimientoFromDb.getId_registro().equals(bitacorasMantenimiento.getId_registro())){
           throw  new AppException( HttpStatus.BAD_REQUEST, "ya se encuentra registrado");
       }*/

    bitacorasMantenimientoFromDb.setEmpleado_solicitante(bitacorasMantenimiento.getEmpleado_solicitante());
    bitacorasMantenimientoFromDb.setTecnico_resonsable(bitacorasMantenimiento.getTecnico_resonsable());
    bitacorasMantenimientoFromDb.setObservaciones(bitacorasMantenimiento.getObservaciones());
    bitacorasMantenimientoFromDb.setFecha_entrega(bitacorasMantenimiento.getFecha_entrega());
    bitacorasMantenimientoFromDb.setFecha_devolucion(bitacorasMantenimiento.getFecha_devolucion());
    bitacorasMantenimientoFromDb.setDispositivo_receptado(bitacorasMantenimiento.getDispositivo_receptado());
    //datos del equipo//


    bitacorasMantenimientoFromDb.setUsuario_ad(bitacorasMantenimiento.getUsuario_ad());
    bitacorasMantenimientoFromDb.setNombre_equipo(bitacorasMantenimiento.getNombre_equipo());
    bitacorasMantenimientoFromDb.setMarca(bitacorasMantenimiento.getMarca());
    bitacorasMantenimientoFromDb.setModelo(bitacorasMantenimiento.getModelo());
    bitacorasMantenimientoFromDb.setGarantia(bitacorasMantenimiento.getGarantia());
    bitacorasMantenimientoFromDb.setSerie(bitacorasMantenimiento.getSerie());
    bitacorasMantenimientoFromDb.setAnio(bitacorasMantenimiento.getAnio());
    bitacorasMantenimientoFromDb.setMac(bitacorasMantenimiento.getMac());
    bitacorasMantenimientoFromDb.setTcp_ip(bitacorasMantenimiento.getTcp_ip());
    //actividades realizadas
      bitacorasMantenimientoFromDb.setAnalisismalware(bitacorasMantenimiento.getAnalisismalware());
      bitacorasMantenimientoFromDb.setRespaldopst(bitacorasMantenimiento.getRespaldopst());
      bitacorasMantenimientoFromDb.setCreacionpst(bitacorasMantenimiento.getCreacionpst());
      bitacorasMantenimientoFromDb.setRespaldoinformacion(bitacorasMantenimiento.getRespaldoinformacion());
      bitacorasMantenimientoFromDb.setValidacionnas(bitacorasMantenimiento.getValidacionnas());
      bitacorasMantenimientoFromDb.setActualizacionnav(bitacorasMantenimiento.getActualizacionnav());
      bitacorasMantenimientoFromDb.setPermisosadmin(bitacorasMantenimiento.getPermisosadmin());
      bitacorasMantenimientoFromDb.setLimpieza_ext(bitacorasMantenimiento.getLimpieza_ext());
      bitacorasMantenimientoFromDb.setLimpieza_int(bitacorasMantenimiento.getLimpieza_int());
      //observaciones

        bitacorasMantenimientoFromDb.setAnalisis_malwareobs(bitacorasMantenimiento.getAnalisis_malwareobs());
        bitacorasMantenimientoFromDb.setRespaldo_pstobs(bitacorasMantenimiento.getRespaldo_pstobs());
        bitacorasMantenimientoFromDb.setCreacion_pstobs(bitacorasMantenimiento.getCreacion_pstobs());
        bitacorasMantenimientoFromDb.setRespaldo_informacionobs(bitacorasMantenimiento.getRespaldo_informacionobs());
        bitacorasMantenimientoFromDb.setRespaldo_informacionobs(bitacorasMantenimiento.getRespaldo_informacionobs());
        bitacorasMantenimientoFromDb.setValidacion_nasobs(bitacorasMantenimiento.getValidacion_nasobs());
        bitacorasMantenimientoFromDb.setActualizacion_navegadoresobs(bitacorasMantenimiento.getActualizacion_navegadoresobs());
        bitacorasMantenimientoFromDb.setPermisos_administradorobs(bitacorasMantenimiento.getPermisos_administradorobs());
        bitacorasMantenimientoFromDb.setLimpiezaexternaobs(bitacorasMantenimiento.getLimpiezaexternaobs());
        bitacorasMantenimientoFromDb.setLimpieza_internaobs(bitacorasMantenimiento.getLimpieza_internaobs());
        bitacorasMantenimientoFromDb.setProceso_mejora(bitacorasMantenimiento.getProceso_mejora());




       return  ResponseEntity.status(HttpStatus.CREATED).body(bitacorasMantenimientoService.save(bitacorasMantenimientoFromDb));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        BitacorasMantenimiento bitacoraFromDb= bitacorasMantenimientoService.findById(id);
        bitacorasMantenimientoService.delete(bitacoraFromDb.getId_registro());
        return ResponseEntity.noContent().build();
    }



}
