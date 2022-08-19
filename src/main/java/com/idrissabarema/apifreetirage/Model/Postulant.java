package com.idrissabarema.apifreetirage.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Creation des attributs dans l'entite Postulant
    private int id_p;
    private String nom_p;
    private String prenom_p;
    private String numero_p;
    private String email_p;

}
