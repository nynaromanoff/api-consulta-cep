package com.github.apiCep.repository;

import com.github.apiCep.entity.LogConsultaCep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogConsultaCepRepository extends JpaRepository<LogConsultaCep, Long> {
}
