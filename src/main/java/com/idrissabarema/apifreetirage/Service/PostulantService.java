package com.idrissabarema.apifreetirage.Service;


import com.idrissabarema.apifreetirage.Model.Postulant;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface PostulantService {
    //Declaration des methode du Service Postulant
    ArrayList<Postulant> INSERPostulant(MultipartFile file);

    Iterable<Object[]> Afficher_Postulant();
    Postulant creerPostulant(Postulant postulant);
}
