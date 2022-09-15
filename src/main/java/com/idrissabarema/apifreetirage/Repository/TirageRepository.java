package com.idrissabarema.apifreetirage.Repository;

import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Model.Postulant_Trié;
import com.idrissabarema.apifreetirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface TirageRepository extends JpaRepository<Tirage, Long> {

    Tirage findByLibellel(String libellet);

    List<Tirage> findByIdt(long id);

    List<Tirage> findByIdliste(Liste idliste);

    @Query(value = "SELECT COUNT(*) FROM tirage WHERE idliste=:idliste", nativeQuery = true)
    int trouverNombreTirageParIdListe(@Param("idliste") long idlise);

    @Query(value = "SELECT COUNT(*) FROM tirage", nativeQuery = true)
    int trouverNombreDeTirageTotal();

    @Query(value = "SELECT COUNT( DISTINCT idliste) FROM tirage", nativeQuery = true)
    int trouverNombreDeListeTire();



    @Query( value = "SELECT COUNT(*) FROM tirage,liste WHERE tirage.idliste=liste.idl GROUP BY idliste;", nativeQuery = true)
    List<Object> nombreTirageParListe();


}
