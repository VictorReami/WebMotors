package com.webmotors.webMotors.Controller;

import com.webmotors.webMotors.Model.Modelo;
import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Model.Usuario;
import com.webmotors.webMotors.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return this.usuarioService.finById(id);
    }

    @GetMapping("/usuario")
    public List<Usuario> findAll(){
        return this.usuarioService.findAll();
    }

    @PostMapping("/usuario/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario m){
        return this.usuarioService.cadastrarAlterar(m, "cadastrar");
    }

    @PutMapping("/usuario/alterar")
    public ResponseEntity<?> alterar(@RequestBody Usuario m){
        return this.usuarioService.cadastrarAlterar(m, "alterar");
    }

    @DeleteMapping("usuario/remover/{id}")
    public ResponseEntity<Resposta> remover (@PathVariable Long id){
        return this.usuarioService.remover(id);
    }



}
