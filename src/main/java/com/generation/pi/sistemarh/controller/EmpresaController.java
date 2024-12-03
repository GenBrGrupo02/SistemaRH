package com.generation.pi.sistemarh.controller;

import com.generation.pi.sistemarh.model.EmpresaModel;
import com.generation.pi.sistemarh.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpresaController {

    @Autowired
    private EmpregadoRepository empregadoRepository;


   
}
