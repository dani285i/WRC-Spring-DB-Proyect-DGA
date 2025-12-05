package edu.dani.back.wrc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.dani.back.wrc.model.PatrocinadorOficial;

public interface PatrocinadorRepo extends JpaRepository<PatrocinadorOficial, Long>  {

}
