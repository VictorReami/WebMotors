package com.webmotors.webMotors.Controller;

import com.webmotors.webMotors.Model.Modelo;
import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Service.ModeloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModeloController {
    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping("/modelo")
    public List<Modelo> findAll(){
        return this.modeloService.findAll();
    }

    @PostMapping("/modelo/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Modelo m){
        return this.modeloService.cadastrarAlterar(m, "cadastrar");
    }

    @PutMapping("/modelo/alterar")
    public ResponseEntity<?> alterar(@RequestBody Modelo m){
        return this.modeloService.cadastrarAlterar(m, "alterar");
    }

    @DeleteMapping("modelo/remover/{id}")
    public ResponseEntity<Resposta> remover (@PathVariable Long id){
        return this.modeloService.remover(id);
    }

}
