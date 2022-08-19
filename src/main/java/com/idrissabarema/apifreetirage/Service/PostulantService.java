package com.idrissabarema.apifreetirage.Service;


import com.idrissabarema.apifreetirage.Model.Postulant;

import java.util.List;

public interface PostulantService {
    //Declaration des methode du Service Postulant
    Postulant CreerPostulant();
    List<Postulant> AfficherPostulant();
}
