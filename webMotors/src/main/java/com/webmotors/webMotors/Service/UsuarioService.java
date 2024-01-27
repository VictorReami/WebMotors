package com.webmotors.webMotors.Service;

import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Model.Usuario;
import com.webmotors.webMotors.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final Resposta resposta;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, Resposta resposta) {
        this.usuarioRepository = usuarioRepository;
        this.resposta = resposta;
    }

    public ResponseEntity<Usuario> finById(Long id){
        return new ResponseEntity(this.usuarioRepository.findById(id), HttpStatus.OK);
    }

    public List<Usuario> findAll(){
        return this.usuarioRepository.findAll();
    }

    //método para cadastrar ou alterar modelos
    public ResponseEntity<?> cadastrarAlterar(Usuario m, String acao){
        /*if(m.getNome().isEmpty()){
            resposta.setMensagem("O nome do modelo é obrigatório!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else if(m.getMontadora().getId().describeConstable().isEmpty()){
            resposta.setMensagem("O modelo precisar ser vinculado á uma montadora!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else{*/
        if(acao.equals("cadastrar")){
            return new ResponseEntity<Usuario>(this.usuarioRepository.save(m), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Usuario>(this.usuarioRepository.save(m), HttpStatus.OK);
        }
        //}
    }

    public ResponseEntity<Resposta> remover(Long id){
        this.usuarioRepository.deleteById(id);
        this.resposta.setMensagem("O Usuario foi removido com sucesso!");

        return new ResponseEntity<Resposta>(this.resposta, HttpStatus.OK);
    }

}
