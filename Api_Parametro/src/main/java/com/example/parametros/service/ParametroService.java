package com.example.parametros.service;


import com.example.parametros.model.ParametroSaab;

import com.example.parametros.repository.impl.ParametroDaoFile;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ParametroService {
    private static Logger logger= Logger.getLogger(ParametroService.class);
    public ParametroService() {
    }

    private ParametroDaoFile parametroDaoFile = new ParametroDaoFile();

    public ParametroService(ParametroDaoFile parametroDaoFile) {
        this.parametroDaoFile = parametroDaoFile;
    }

    public ParametroSaab guardar(ParametroSaab p){
        return  parametroDaoFile.guardar(p);
    }

    public ParametroSaab buscar(Integer id) {
        ParametroSaab parametro = new ParametroSaab();
        parametro=parametroDaoFile.buscar(id);
        return parametro;
    }

/*
    public List<Parametro> buscarTodos(){
        return parametroDaoFile.buscarTodos();
    }

 */
}
