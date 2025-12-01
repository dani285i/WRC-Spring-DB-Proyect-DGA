package edu.dani.back.wrc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.dani.back.wrc.model.Coche;

public interface CocheRepo extends JpaRepository<Coche, Long> {

}
