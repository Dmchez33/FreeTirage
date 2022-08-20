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

    // Implementation de la methode qui enregistre les donnee des donnees dans la table liste
    @Override
    public Liste CreerListe(Liste liste) {

        return null;
    }

    // Implementation de la methode qui retourne liste en fonction d'un id
    @Override
    public Liste FindIdliste(int idliste){
        return null;
    }

    @Override
    public List<Liste> AfficherListe() {
        return null;
    }
}
