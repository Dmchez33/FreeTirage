package com.idrissabarema.apifreetirage.Controller;


import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Repository.ListeRepository;
import com.idrissabarema.apifreetirage.Service.ListeService;
import com.idrissabarema.apifreetirage.Service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/postulant")
public class PostulantController {

    @Autowired
    final private PostulantService postulantService;

    @PostMapping("/ajoute_postulant/")
    String AjouterPostulant(){

        //IMPLEMENTATION DE LA METHODE DANS LE CONTROLLER
        return postulantService.INSERPostulant();
    }

}
