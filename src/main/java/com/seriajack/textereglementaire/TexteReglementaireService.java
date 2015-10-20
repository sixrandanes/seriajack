package com.seriajack.textereglementaire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TexteReglementaireService {

    @Autowired
    TexteReglementaireRepository texteReglementaireRepository;

    public List<TexteReglementaire> findAllTexteReglementaire() {
        return texteReglementaireRepository.findAll();
    }

}