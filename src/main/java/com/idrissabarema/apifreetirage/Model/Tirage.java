package com.idrissabarema.apifreetirage.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Creation des attributs dans l'entite Tirage
    private int id_t;
    private Date date_t;
    private String libelle_l;
    private int nbre_demande;
}