package com.webmotors.webMotors.Repository;

import com.webmotors.webMotors.Model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long >{
}
