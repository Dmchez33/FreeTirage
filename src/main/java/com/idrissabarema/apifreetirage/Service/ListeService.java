package com.idrissabarema.apifreetirage.Service;

import com.idrissabarema.apifreetirage.Model.Liste;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ListeService {

    //Declaration des methode du Service Liste
    Liste CreerListe(Liste liste);
    Iterable<Object[]>  AfficherListe();
    Liste findByLibellel(String libellel);
    List<Liste>afficerListe();

    List<Liste>afficerListeParId(long id);

}
