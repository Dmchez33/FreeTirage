package com.idrissabarema.apifreetirage.Repository;

import com.idrissabarema.apifreetirage.Model.Liste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListeRepository extends JpaRepository<Liste, Long> {

    // Fonction permettant de retourner la liste d'un id donnee

}
