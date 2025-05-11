package com.todolist.service;

import com.todolist.model.Categorie;
import com.todolist.model.Tache;
import com.todolist.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;

    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    public List<Tache> getTachesByEtat(String etat) {
        return tacheRepository.findByEtat(etat);
    }

    public List<Tache> getTachesByCategorie(Categorie categorie) {
        return tacheRepository.findByCategorie(categorie);
    }

    public Optional<Tache> getTacheById(Long id) {
        return tacheRepository.findById(id);
    }

    public Tache saveTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public void deleteTache(Long id) {
        tacheRepository.deleteById(id);
    }

    public Tache updateTache(Long id, Tache tache) {
        // Vérifier si la tâche existe
        if (tacheRepository.existsById(id)) {
            tache.setId(id); // Mettre à jour l'ID de la tâche pour éviter les conflits
            return tacheRepository.save(tache);
        } else {
            throw new RuntimeException("Tâche non trouvée avec l'ID: " + id);
        }
    }
}
