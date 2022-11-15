package com.example.parametros.controller;

import com.example.parametros.model.ParametroSaab;
import com.example.parametros.service.ParametroService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parametros")
public class ParametroController {

    private static Logger logger= Logger.getLogger(ParametroController.class);
    @Autowired
    private ParametroService parametroService;


   /* @GetMapping
    public ResponseEntity<List<Parametro>> buscarTodos(){
        return ResponseEntity.ok(parametroService.buscarTodos());
    }*/

    @PostMapping
    public ResponseEntity<ParametroSaab> registrar(@RequestBody ParametroSaab parametro){

        return ResponseEntity.ok(parametroService.guardar(parametro));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ParametroSaab> buscarPorId(@PathVariable Integer id){
        logger.info("buscarParametro desde controlador");
        return ResponseEntity.ok(parametroService.buscar(id));
    }


}
