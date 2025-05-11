package com.todolist.controller;

import com.todolist.model.Categorie;
import com.todolist.model.Tache;
import com.todolist.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @GetMapping
    public List<Tache> getAllTaches() {
        return tacheService.getAllTaches();
    }

    @GetMapping("/etat/{etat}")
    public List<Tache> getTachesByEtat(@PathVariable String etat) {
        return tacheService.getTachesByEtat(etat);
    }

    @GetMapping("/categorie/{categorie}")
    public List<Tache> getTachesByCategorie(@PathVariable String categorie) {
        Categorie categorieEnum = Categorie.valueOf(categorie.toUpperCase());
        return tacheService.getTachesByCategorie(categorieEnum);
    }

    @PostMapping
    public Tache createTache(@RequestBody Tache tache) {
        return tacheService.saveTache(tache);
    }

    @DeleteMapping("/{id}")
    public void deleteTache(@PathVariable Long id) {
        tacheService.deleteTache(id);
    }

    @PutMapping("/{id}")
    public Tache updateTache(@PathVariable Long id, @RequestBody Tache tache) {
        return tacheService.updateTache(id, tache);
    }

}
