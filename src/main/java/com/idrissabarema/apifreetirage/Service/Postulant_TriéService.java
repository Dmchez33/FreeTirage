package com.idrissabarema.apifreetirage.Service;


import com.idrissabarema.apifreetirage.Model.Postulant_Trié;

import java.util.List;

public interface Postulant_TriéService {
    //Declaration des methode du Service Postulant
    Postulant_Trié CreerPostulant_Trié();
    List<Postulant_Trié> AfficherPostulant_Trié();

}
