package com.webmotors.webMotors.Service;

import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Model.Usuario;
import com.webmotors.webMotors.Model.VeiculoAnuncio;
import com.webmotors.webMotors.Repository.VeiculoAnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoAnuncioService {
    private final VeiculoAnuncioRepository veiculoAnuncioRepository;
    private final Resposta resposta;

    @Autowired
    public VeiculoAnuncioService(VeiculoAnuncioRepository veiculoAnuncioRepository, Resposta resposta) {
        this.veiculoAnuncioRepository = veiculoAnuncioRepository;
        this.resposta = resposta;
    }

    public ResponseEntity<VeiculoAnuncio> finById(Long id){
        return new ResponseEntity(this.veiculoAnuncioRepository.findById(id), HttpStatus.OK);
    }

    public List<VeiculoAnuncio> findAll(){
        return this.veiculoAnuncioRepository.findAll();
    }

    //método para cadastrar ou alterar modelos
    public ResponseEntity<?> cadastrarAlterar(VeiculoAnuncio m, String acao){
        /*if(m.getNome().isEmpty()){
            resposta.setMensagem("O nome do modelo é obrigatório!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else if(m.getMontadora().getId().describeConstable().isEmpty()){
            resposta.setMensagem("O modelo precisar ser vinculado á uma montadora!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else{*/
        if(acao.equals("cadastrar")){
            return new ResponseEntity<VeiculoAnuncio>(this.veiculoAnuncioRepository.save(m), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<VeiculoAnuncio>(this.veiculoAnuncioRepository.save(m), HttpStatus.OK);
        }
        //}
    }

    public ResponseEntity<Resposta> remover(Long id){
        this.veiculoAnuncioRepository.deleteById(id);
        this.resposta.setMensagem("O Usuario foi removido com sucesso!");

        return new ResponseEntity<Resposta>(this.resposta, HttpStatus.OK);
    }

}
