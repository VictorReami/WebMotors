package com.webmotors.webMotors.Repository;

import com.webmotors.webMotors.Model.Montadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MontadoraRepository extends JpaRepository<Montadora, Long> {

}
