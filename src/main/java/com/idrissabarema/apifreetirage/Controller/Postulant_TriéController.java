package com.idrissabarema.apifreetirage.Controller;

import com.idrissabarema.apifreetirage.Model.Postulant_Trié;
import com.idrissabarema.apifreetirage.Service.Postulant_TriéService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/postulant_trie")
public class Postulant_TriéController {

    @Autowired
    final private Postulant_TriéService postulantTriéService;

    //METHODE PERMETTANT D'AFFICHER LE POSTULANTTRIE
    @GetMapping("/afficher_postulant_trie")
    public List<Postulant_Trié> AfficherPostulantTrie(){
        return postulantTriéService.AfficherPostulant_Trié();
    }

}
