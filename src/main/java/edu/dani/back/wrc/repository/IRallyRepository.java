package edu.dani.back.wrc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.dani.back.wrc.model.Rally;

public interface IRallyRepository extends JpaRepository<Rally, Long> {

}
