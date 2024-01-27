package com.webmotors.webMotors.Controller;

import com.webmotors.webMotors.Model.Opcional;
import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Model.Usuario;
import com.webmotors.webMotors.Service.OpcionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OpcionalController {
    private final OpcionalService opcionalService;

    public OpcionalController(OpcionalService opcionalService) {
        this.opcionalService = opcionalService;
    }

    @GetMapping("/opcional")
    public List<Opcional> findAll(){
        return this.opcionalService.findAll();
    }

    @PostMapping("/opcional/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Opcional m){
        return this.opcionalService.cadastrarAlterar(m, "cadastrar");
    }

    @PutMapping("/opcional/alterar")
    public ResponseEntity<?> alterar(@RequestBody Opcional m){
        return this.opcionalService.cadastrarAlterar(m, "alterar");
    }

    @DeleteMapping("opcional/remover/{id}")
    public ResponseEntity<Resposta> remover (@PathVariable Long id){
        return this.opcionalService.remover(id);
    }


}
