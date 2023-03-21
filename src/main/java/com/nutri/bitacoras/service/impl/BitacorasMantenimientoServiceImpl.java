package com.nutri.bitacoras.service.impl;

import com.nutri.bitacoras.exception.ResourceNotFoundException;
import com.nutri.bitacoras.model.entiy.BitacorasMantenimiento;
import com.nutri.bitacoras.repository.BitacorasMantenimientoRepository;
import com.nutri.bitacoras.service.generic.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BitacorasMantenimientoServiceImpl extends GenericServiceImpl<BitacorasMantenimiento> {
    @Autowired
    private BitacorasMantenimientoRepository bitacorasMantenimientoRepository;

    public BitacorasMantenimiento save(BitacorasMantenimiento entity){

       return bitacorasMantenimientoRepository.save(entity);
    }
    public BitacorasMantenimiento findById(Long id){

        return  bitacorasMantenimientoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    public List<BitacorasMantenimiento> findAll(){

        return  bitacorasMantenimientoRepository.findAll();
    }

   public void delete (Long id){
      bitacorasMantenimientoRepository.deleteById(id);
   }



}
