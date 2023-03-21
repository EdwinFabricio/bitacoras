package com.nutri.bitacoras.controller;

import com.nutri.bitacoras.model.entiy.BitacorasMantenimiento;
import com.nutri.bitacoras.model.entiy.BitacorasPedido;
import com.nutri.bitacoras.service.impl.BitacoraPedidoServiceImpl;
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
@RequestMapping("/pedido")
public class BitacorasPedidoController {
    @Autowired
    private BitacoraPedidoServiceImpl bitacorasPedidoService;

  /* @PostMapping("/crear")
    public ResponseEntity<BitacorasPedido> crearPedido(
            @RequestBody BitacorasPedido p){
       return new
               ResponseEntity<>(bitacorasPedidoService.save(p),HttpStatus.CREATED);
   }*/


    @GetMapping
    public ResponseEntity<List<?>> listar(){
        return ResponseEntity.ok(bitacorasPedidoService.findAll());
    }

    @GetMapping("/{id_regis}")
    public  ResponseEntity<?> cargarporid(@PathVariable Long id_regis){
        return  ResponseEntity.ok(bitacorasPedidoService.findById(id_regis));
    }

    @PostMapping
    public  ResponseEntity<?>crear (@Valid @RequestBody BitacorasPedido bitacorasPedido){
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(bitacorasPedidoService.save(bitacorasPedido));
    }

    @PutMapping("/{id_regis}")
    public  ResponseEntity<?> editar(@PathVariable Long id_regis, @Valid @RequestBody BitacorasPedido bitacorasPedido){
          BitacorasPedido bitacorasPedidoFromDb= bitacorasPedidoService.findById(id_regis);

        bitacorasPedidoFromDb.setTec_responsable(bitacorasPedido.getTec_responsable());
        bitacorasPedidoFromDb.setEmp_solicitante(bitacorasPedido.getEmp_solicitante());
        bitacorasPedidoFromDb.setDisp_entregados(bitacorasPedido.getDisp_entregados());
        bitacorasPedidoFromDb.setSeriedisp(bitacorasPedido.getSeriedisp());
        bitacorasPedidoFromDb.setFecha_entrega(bitacorasPedido.getFecha_entrega());

        bitacorasPedidoFromDb.setObservacionesfe(bitacorasPedido.getObservacionesfe());
        bitacorasPedidoFromDb.setFecha_devolucion(bitacorasPedido.getFecha_devolucion());
        bitacorasPedidoFromDb.setObservacionesfd(bitacorasPedido.getObservacionesfd());
        bitacorasPedidoFromDb.setEstado(bitacorasPedido.getEstado());



        return  ResponseEntity.status(HttpStatus.CREATED).body(bitacorasPedidoService.save(bitacorasPedidoFromDb));
    }

    @DeleteMapping("/{id_regis}")
    public ResponseEntity<?>eliminar(@PathVariable Long id_regis){
        BitacorasPedido bitacoraPedidoFromDb= bitacorasPedidoService.findById(id_regis);
        bitacorasPedidoService.delete(bitacoraPedidoFromDb.getId_regis());
        return ResponseEntity.noContent().build();
    }


}

