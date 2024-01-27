package com.webmotors.webMotors.Repository;

import com.webmotors.webMotors.Model.VeiculoAnuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoAnuncioRepository extends JpaRepository<VeiculoAnuncio, Long> {
}
