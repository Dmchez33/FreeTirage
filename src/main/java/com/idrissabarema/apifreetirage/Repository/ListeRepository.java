package com.idrissabarema.apifreetirage.Repository;

import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListeRepository extends JpaRepository<Liste, Integer> {
    @Query(value = "SELECT liste.datel,liste.libellel FROM liste;", nativeQuery = true)
    public Iterable<Object[]>  AfficherListe();
    Liste findByLibellel(String libellel);

    List<Liste> findByIdl(long id);

    @Query(value = "SELECT count(*) FROM liste;", nativeQuery = true)
    int nombreTotalDeListe();

    @Query(value = "SELECT liste.libellel FROM liste, tirage WHERE tirage.idliste = liste.idl AND tirage.libellel =:valeur",nativeQuery = true)
    List<Object> trouverListeLIibelleSurTirage(@Param("valeur") String valeur);

}
