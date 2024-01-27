package com.webmotors.webMotors.Controller;

import com.webmotors.webMotors.Model.Montadora;
import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Service.MontadoraService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MontadoraController {
    private final MontadoraService montadoraService;

    public MontadoraController(MontadoraService montadoraService) {
        this.montadoraService = montadoraService;
    }

    @GetMapping("/montadora")
    public List<Montadora> findAll(){
        return this.montadoraService.findAll();
    }

    @PostMapping("/montadora/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Montadora m){
        return this.montadoraService.cadastrarAlterar(m, "cadastrar");
    }

    @PutMapping("/montadora/alterar")
    public ResponseEntity<?> alterar(@RequestBody Montadora m){
        return this.montadoraService.cadastrarAlterar(m, "alterar");
    }

    @DeleteMapping("/montadora/remover/{id}")
    public ResponseEntity<Resposta> deletar(@PathVariable Long id){
        return this.montadoraService.remover(id);
    }
}
