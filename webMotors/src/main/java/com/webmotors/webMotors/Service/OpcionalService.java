package com.webmotors.webMotors.Service;

import com.webmotors.webMotors.Model.Opcional;
import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Model.Usuario;
import com.webmotors.webMotors.Repository.OpcionalRepository;
import com.webmotors.webMotors.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcionalService {
    private final OpcionalRepository opcionalRepository;
    private final Resposta resposta;

    @Autowired
    public OpcionalService(OpcionalRepository opcionalRepository, Resposta resposta) {
        this.opcionalRepository = opcionalRepository;
        this.resposta = resposta;
    }

    public List<Opcional> findAll(){
        return this.opcionalRepository.findAll();
    }

    //método para cadastrar ou alterar modelos
    public ResponseEntity<?> cadastrarAlterar(Opcional m, String acao){
        /*if(m.getNome().isEmpty()){
            resposta.setMensagem("O nome do modelo é obrigatório!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else if(m.getMontadora().getId().describeConstable().isEmpty()){
            resposta.setMensagem("O modelo precisar ser vinculado á uma montadora!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else{*/
        if(acao.equals("cadastrar")){
            return new ResponseEntity<Opcional>(this.opcionalRepository.save(m), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Opcional>(this.opcionalRepository.save(m), HttpStatus.OK);
        }
        //}
    }

    public ResponseEntity<Resposta> remover(Long id){
        this.opcionalRepository.deleteById(id);
        this.resposta.setMensagem("A opção foi removida com sucesso!");

        return new ResponseEntity<Resposta>(this.resposta, HttpStatus.OK);
    }
}
