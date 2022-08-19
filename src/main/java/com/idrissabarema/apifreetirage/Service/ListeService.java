package com.idrissabarema.apifreetirage.Service;

import com.idrissabarema.apifreetirage.Model.Liste;

import java.util.List;

public interface ListeService {

    //Declaration des methode du Service Liste
    Liste CreerListe(Liste liste);
    List<Liste> AfficherListe();
}
