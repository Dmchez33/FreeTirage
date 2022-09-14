package com.idrissabarema.apifreetirage.Service;


import com.idrissabarema.apifreetirage.Model.Postulant_Trié;
import com.idrissabarema.apifreetirage.Model.Tirage;

import java.util.List;

public interface Postulant_TriéService {

    //Declaration des methode du Service Postulant
    Postulant_Trié CreerPostulant_Trié(Postulant_Trié postulant_trié);

    // METHODE PERMETTANT DE AFFICHER LES POSTULANTS TRIER
    List<Postulant_Trié> AfficherPostulant_Trié();

    //INSERTION AVEC LA PERSONNALISEES
    void INSERERPOSTULANT(String nom, String prenom, String numero, String email, long id);

    List<Postulant_Trié> trouverPostulantTireParId(Tirage tirage);

}
