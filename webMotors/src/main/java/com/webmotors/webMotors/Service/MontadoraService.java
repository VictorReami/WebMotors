package com.webmotors.webMotors.Service;

import com.webmotors.webMotors.Model.Montadora;
import com.webmotors.webMotors.Model.Resposta;
import com.webmotors.webMotors.Repository.MontadoraRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MontadoraService {
    private final MontadoraRepository montadoraRepository;
    private final Resposta resposta;

    @Autowired
    public MontadoraService(MontadoraRepository montadoraRepository, Resposta resposta) {
        this.montadoraRepository = montadoraRepository;
        this.resposta = resposta;
    }

    //Busca todas as montadoras
    public List<Montadora> findAll(){
        return this.montadoraRepository.findAll();
    }

    //método para cadastrar ou alterar montadoras
    public ResponseEntity<?> cadastrarAlterar(Montadora m, String acao){
        if(m.getNome().equals("")){
            resposta.setMensagem("O nome da montadora é obrigatório!");
                return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<Montadora>(montadoraRepository.save(m), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Montadora>(montadoraRepository.save(m), HttpStatus.OK);
            }
        }
    }

    //método para remover Montadoras
    public ResponseEntity<Resposta> remover(Long id){
        this.montadoraRepository.deleteById(id);
        this.resposta.setMensagem("A montadora foi removida com sucesso!");

        return new ResponseEntity<Resposta>(this.resposta, HttpStatus.OK);
    }
}
