package com.idrissabarema.apifreetirage.Service;

import com.idrissabarema.apifreetirage.Model.Tirage;

import java.util.List;

public interface TirageService {
    //Declaration des methode du Service Tirage
    Tirage CreerTirage();
    List<Tirage> AfficherTirage();
}
