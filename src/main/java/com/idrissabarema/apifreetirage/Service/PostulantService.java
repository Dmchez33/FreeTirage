package com.idrissabarema.apifreetirage.Service;


import com.idrissabarema.apifreetirage.Model.Postulant;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PostulantService {
    //Declaration des methode du Service Postulant
    ArrayList<Postulant> INSERPostulant(MultipartFile file);

    // METHODE PERMETTANT D'AFFICHER LE POSTULANT
    List<Postulant> Afficher_Postulant();

    // METHODE PERMETTANT DE CREER LA TABLE POSTULANT
    Postulant creerPostulant(Postulant postulant);

    //METHODE PERMETTANT DE RETOURNER LE NOMBRE D'ELEMENT DANS LA TABLE POSTULANT
    long NombrePostulant();

    //METHODE PERMETTANT DE SUPPRIMER L'ID TROUVER DANS LA TABLES POSTULANT
    void suprimerPostulantById(Long id);

    //METHODE PERMETTANT DE RETROUVE UN POSTULANT EN FONCTION DE SON ID
    List<Postulant> TrouverPostulantId(long id_p);
}
