package ceu.dam.ad.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.users.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
