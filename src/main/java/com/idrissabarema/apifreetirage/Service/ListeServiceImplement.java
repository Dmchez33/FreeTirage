package com.idrissabarema.apifreetirage.Service;

import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Repository.ListeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ListeServiceImplement implements ListeService {
    @Autowired
    final private ListeRepository listeRepository;
    @Override
    public Liste CreerListe(Liste liste) {

        // Enregistrement des donnees dans la table liste

        return listeRepository.save(liste);
    }

    @Override
    public Iterable<Object[]>  AfficherListe() {
        return listeRepository.AfficherListe();
    }

    @Override
    public Liste findByLibellel(String libellel) {
        return listeRepository.findByLibellel(libellel);
    }
}
