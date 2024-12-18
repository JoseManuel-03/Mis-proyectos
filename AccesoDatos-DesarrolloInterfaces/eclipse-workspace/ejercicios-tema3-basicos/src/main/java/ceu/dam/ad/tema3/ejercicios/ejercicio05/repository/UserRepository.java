package ceu.dam.ad.tema3.ejercicios.ejercicio05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.tema3.ejercicios.ejercicio05.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
