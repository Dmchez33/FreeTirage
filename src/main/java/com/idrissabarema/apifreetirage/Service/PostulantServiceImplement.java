package com.idrissabarema.apifreetirage.Service;

import com.idrissabarema.apifreetirage.Model.Postulant;
import com.idrissabarema.apifreetirage.Repository.PostulantRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@AllArgsConstructor
@Service
public class PostulantServiceImplement implements PostulantService {


    @Autowired
    final private PostulantRepository postulantRepository;
    @Override
    public String INSERPostulant() {


        ArrayList<String> values = new ArrayList<String>(); // Variable permettant de prendre toutes les donnes du tableau

        // Bloque permettant de lever les exception lors de l'importation du fichier excel
        try{
            InputStream fichier = new FileInputStream("fichierSource.xls"); // Recuperation du fichier Execl sous forme de fichier simple

            POIFSFileSystem fs = new POIFSFileSystem(fichier); // conversion du fichier simple sous forme d'un fichier POI

            HSSFWorkbook wb = new HSSFWorkbook(fs); // Conversion du fichier POI sous format Workbook

            HSSFSheet sheet = wb.getSheetAt(0); // Recuperation du Premier page du fichier excel

            Iterator rows = sheet.rowIterator(); // Recuperation de tous les lignes de la page du fichier
            // Boucle permettant de parcours toutes lignes de la page

            while (rows.hasNext()){

                values.clear(); // Vider toutes les donnes du tableau dynamique "values"

                HSSFRow row = (HSSFRow) rows.next(); // Recuperation d'une ligne du tableau

                Iterator cells = row.cellIterator(); // Recuperation de toutes toutes les colonnes de chaque ligne

                // Boucle permettant de parcourut toutes les colonnes de chaque ligne
                while (cells.hasNext()){

                    HSSFCell cell = (HSSFCell) cells.next(); // Recuperation d'une colonne

                    // Condition permettant de verifier le type de la colonne et effectuer une convesion si c'est type int
                    if (cell.getCellType() == CellType.NUMERIC){
                        values.add(Integer.toString((int) cell.getNumericCellValue()));
                    }
                    else{
                        values.add(cell.getStringCellValue());
                    }
                }

                postulantRepository.INSERTPOSTULANT (values.get(0),values.get(1),values.get(2),values.get(3));

            }
            return "LES DONNEES SONT BIEN ENREGISTREES";

        }catch (Exception e){

            e.printStackTrace();
            return "DONNEE NON ENREGISTRES DANS LA BASE";

        }

    }

    //AFFICHAGE LISTE POSTULANT
    @Override
    public List<Postulant> AfficherPostulant() {
        return null;
    }
}
