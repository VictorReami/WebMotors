package com.webmotors.webMotors.Controller;

import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Model.Usuario;
import com.webmotors.webMotors.Model.VeiculoAnuncio;
import com.webmotors.webMotors.Service.VeiculoAnuncioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VeiculoAnuncioController {
    private final VeiculoAnuncioService veiculoAnuncioService;

    public VeiculoAnuncioController(VeiculoAnuncioService veiculoAnuncioService) {
        this.veiculoAnuncioService = veiculoAnuncioService;
    }

    @GetMapping("/anuncio/{id}")
    public ResponseEntity<VeiculoAnuncio> findById(@PathVariable Long id){
        return this.veiculoAnuncioService.finById(id);
    }

    @GetMapping("/anuncio")
    public List<VeiculoAnuncio> findAll(){
        return this.veiculoAnuncioService.findAll();
    }

    @PostMapping("/anuncio/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody VeiculoAnuncio m){
        return this.veiculoAnuncioService.cadastrarAlterar(m, "cadastrar");
    }

    @PutMapping("/anuncio/alterar")
    public ResponseEntity<?> alterar(@RequestBody VeiculoAnuncio m){
        return this.veiculoAnuncioService.cadastrarAlterar(m, "alterar");
    }

    @DeleteMapping("anuncio/remover/{id}")
    public ResponseEntity<Resposta> remover (@PathVariable Long id){
        return this.veiculoAnuncioService.remover(id);
    }

}
