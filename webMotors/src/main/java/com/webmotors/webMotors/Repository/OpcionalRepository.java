package com.webmotors.webMotors.Repository;

import com.webmotors.webMotors.Model.Opcional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionalRepository extends JpaRepository<Opcional, Long> {
}
