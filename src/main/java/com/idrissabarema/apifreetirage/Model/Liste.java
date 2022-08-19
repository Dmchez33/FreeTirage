package com.idrissabarema.apifreetirage.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Liste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Creation des attributs dans l'entite Liste
    private int id_l;
    private Date date_l;
    private String libelle_l;
}
