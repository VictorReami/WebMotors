package com.webmotors.webMotors.Service;

import com.webmotors.webMotors.Model.Modelo;
import com.webmotors.webMotors.Model.Montadora;
import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Repository.ModeloRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {
    private final ModeloRepository modeloRepository;
    private final Resposta resposta;

    @Autowired
    public ModeloService(ModeloRepository modeloRepository, Resposta resposta) {
        this.modeloRepository = modeloRepository;
        this.resposta = resposta;
    }

    public List<Modelo> findAll(){
        return this.modeloRepository.findAll();
    }

    //método para cadastrar ou alterar modelos
    public ResponseEntity<?> cadastrarAlterar(Modelo m, String acao){
        /*if(m.getNome().isEmpty()){
            resposta.setMensagem("O nome do modelo é obrigatório!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else if(m.getMontadora().getId().describeConstable().isEmpty()){
            resposta.setMensagem("O modelo precisar ser vinculado á uma montadora!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else{*/
            if(acao.equals("cadastrar")){
                return new ResponseEntity<Modelo>(modeloRepository.save(m), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Modelo>(modeloRepository.save(m), HttpStatus.OK);
            }
        //}
    }

    public ResponseEntity<Resposta> remover(Long id){
        this.modeloRepository.deleteById(id);
        this.resposta.setMensagem("O modelo foi removido com sucesso!");

        return new ResponseEntity<Resposta>(this.resposta, HttpStatus.OK);
    }


}
