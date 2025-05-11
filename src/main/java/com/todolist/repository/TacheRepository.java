package com.todolist.repository;

import com.todolist.model.Categorie;
import com.todolist.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findByEtat(String etat);

    List<Tache> findByCategorie(Categorie categorie);
}
