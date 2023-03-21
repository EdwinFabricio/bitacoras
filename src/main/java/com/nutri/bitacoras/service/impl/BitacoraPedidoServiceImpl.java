package com.nutri.bitacoras.service.impl;

import com.nutri.bitacoras.exception.ResourceNotFoundException;
import com.nutri.bitacoras.model.entiy.BitacorasMantenimiento;
import com.nutri.bitacoras.model.entiy.BitacorasPedido;
import com.nutri.bitacoras.repository.BitacorasPedidoRepository;
import com.nutri.bitacoras.service.generic.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BitacoraPedidoServiceImpl extends GenericServiceImpl<BitacorasPedido>  {

    @Autowired
    private BitacorasPedidoRepository bitacorasPedidoRepository;

    public BitacorasPedido save(BitacorasPedido entity){

        return bitacorasPedidoRepository.save(entity);
    }
    public BitacorasPedido findById(Long id_regis){

        return  bitacorasPedidoRepository.findById(id_regis).orElseThrow(() -> new ResourceNotFoundException("id", id_regis));
    }

    public List<BitacorasPedido> findAll(){

        return  bitacorasPedidoRepository.findAll();
    }

    public void delete (Long id_regis){
        bitacorasPedidoRepository.deleteById(id_regis);
    }



}
