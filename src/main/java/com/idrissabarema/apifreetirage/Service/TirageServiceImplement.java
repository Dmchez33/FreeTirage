package com.idrissabarema.apifreetirage.Service;

import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Model.Tirage;
import com.idrissabarema.apifreetirage.Repository.TirageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class TirageServiceImplement implements TirageService {
    //DECLARATION D'UN TIRAGE REPOSITORY
    @Autowired
    final private TirageRepository tirageRepository;

    //IMPLEMENTATION DE LA METHODE PERMETTANT DE CREER LE TIRAGE
    @Override
    public Tirage CreerTirage(Tirage tirage) {
        return tirageRepository.save(tirage);
    }

    //IMPLEMENTATION DE LA METHODE PERMETTANT D'AFFICHER LE TIRAGE
    @Override
    public List<Tirage> AfficherTirage() {
        return tirageRepository.findAll();
    }

    @Override
    public Tirage trouverTirageParLibelle(String libellet) {
        return tirageRepository.findByLibellel(libellet);
    }

    @Override
    public List<Tirage> trouverTirageParId(long id) {
        return this.tirageRepository.findByIdt(id);
    }

    @Override
    public List<Tirage> trouverTirageParListeId(Liste idliste) {
        return this.tirageRepository.findByIdliste(idliste);
    }

    @Override
    public int trouverNombreTirageParId(long id) {
        return tirageRepository.trouverNombreTirageParIdListe(id);
    }

    @Override
    public int trouverDeNombreTirageTotal() {
        return tirageRepository.trouverNombreDeTirageTotal();
    }

    @Override
    public int trouverDeNombreTotalListeTire() {
        return tirageRepository.trouverNombreDeListeTire();
    }

    @Override
    public List<Object> trouverTirageParListe() {
        return tirageRepository.nombreTirageParListe();
    }


}
