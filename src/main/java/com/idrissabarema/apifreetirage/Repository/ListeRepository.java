package com.idrissabarema.apifreetirage.Repository;

import com.idrissabarema.apifreetirage.Model.Liste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListeRepository extends JpaRepository<Liste, Integer> {
    @Query(value = "SELECT liste.datel,liste.libellel FROM liste;", nativeQuery = true)
    public Iterable<Object[]>  AfficherListe();
}
