package com.idrissabarema.apifreetirage.Service;

import com.idrissabarema.apifreetirage.Model.Postulant_Trié;
import com.idrissabarema.apifreetirage.Model.Tirage;
import com.idrissabarema.apifreetirage.Repository.Postulant_TriéRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class Postulant_TriéServiceImplement implements Postulant_TriéService {
    @Autowired
    final private Postulant_TriéRepository postulant_triéRepository;
//METHODE PERMETTANT DE D'INSERER LES DONNEES
    @Override
    public Postulant_Trié CreerPostulant_Trié(Postulant_Trié postulant_trié) {

        return postulant_triéRepository.save(postulant_trié);

    }
//METHODE PERMETTANT DE RETOURNEZ LE TRIE
    @Override
    public List<Postulant_Trié> AfficherPostulant_Trié() {
        return postulant_triéRepository.findAll();
    }

//METHODE UTILISANT LA REQUETTE PERSONNALISES
    @Override
    public void INSERERPOSTULANT(String nom, String prenom, String numero, String email, long id) {
        postulant_triéRepository.INSERTPOSTULANTTRIE(nom,prenom,numero,email, id);

    }

    @Override
    public List<Postulant_Trié> trouverPostulantTireParId(Tirage tirage) {
        return postulant_triéRepository.findByIdtirage(tirage);
    }
}
