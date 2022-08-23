package com.idrissabarema.apifreetirage.Service;

import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Model.Tirage;

import java.util.Date;
import java.util.List;

public interface TirageService {
    //Declaration des methode du Service Tirage
    Tirage CreerTirage(Tirage tirage);

    //METHODE PERMETTANT D'AFFICHER LA LISTE DES TIRAGE EFFECTUER
    List<Tirage> AfficherTirage();
    //int CreerTirage1(String libelle, int nbre);
    Tirage trouverTirageParLibelle(String libellet);
}
