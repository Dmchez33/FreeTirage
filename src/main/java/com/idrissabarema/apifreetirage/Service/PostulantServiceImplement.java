package com.idrissabarema.apifreetirage.Service;

import com.idrissabarema.apifreetirage.Model.Postulant;
import com.idrissabarema.apifreetirage.Repository.PostulantRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostulantServiceImplement implements PostulantService {


    @Autowired
    final private PostulantRepository postulantRepository;

    // METHODE PERMETTANT D'INSERER LES POSTULANT DANS LA TABLE POSTULANT
    @Override
    public ArrayList<Postulant> INSERPostulant(MultipartFile file) {

        DataFormatter formatter=new DataFormatter();
        ArrayList<Postulant> values = new ArrayList<Postulant>(); // Variable permettant de prendre toutes les donnes du tableau

        // Bloque permettant de lever les exception lors de l'importation du fichier excel
        try{
            //InputStream fichier = new FileInputStream("fichierSource.xls"); // Recuperation du fichier Execl sous forme de fichier simple

            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream()); // conversion du fichier simple sous forme d'un fichier POI

            HSSFWorkbook wb = new HSSFWorkbook(fs); // Conversion du fichier POI sous format Workbook

            HSSFSheet sheet = wb.getSheetAt(0); // Recuperation du Premier page du fichier excel

            Iterator rows = sheet.rowIterator(); // Recuperation de tous les lignes de la page du fichier
            // Boucle permettant de parcours toutes lignes de la page

            while (rows.hasNext()){

                //values.clear(); // Vider toutes les donnes du tableau dynamique "values"

                HSSFRow row = (HSSFRow) rows.next(); // Recuperation d'une ligne du tableau

                Iterator cells = row.cellIterator(); // Recuperation de toutes toutes les colonnes de chaque ligne
                Postulant p=new Postulant();
                int numColun=0;
                // Boucle permettant de parcourut toutes les colonnes de chaque ligne
                while (cells.hasNext()){

                    HSSFCell cell = (HSSFCell) cells.next(); // Recuperation d'une colonne

                    switch (numColun){

                        case 0:
                            p.setPrenomp(formatter.formatCellValue(cell));
                            break;
                        case 1:
                            p.setNomp(formatter.formatCellValue(cell));
                            break;
                        case 2:
                            p.setNumerop(formatter.formatCellValue(cell));
                            break;
                        case 3:
                            p.setEmailp(formatter.formatCellValue(cell));
                            break;
                        default:
                            break;
                    }
                    numColun++;

                    // Condition permettant de verifier le type de la colonne et effectuer une convesion si c'est type int
                   // if (cell.getCellType() == CellType.NUMERIC){
                     //   values.add(Integer.toString((int) cell.getNumericCellValue()));
                   // }
                    //else{
                      //  values.add(cell.getStringCellValue());
                   // }
                }

                //postulantRepository.INSERTPOSTULANT (values.get(3),values.get(1),values.get(2),values.get(0));
                  values.add(p);
            }
            return values;

        }catch (Exception e){

            e.printStackTrace();
            return null;

        }

    }

    // IMPLEMENTATION DE LA METHODE PERMETTANT D'AFFICHER LES POSTULANTS
    @Override
    public List<Postulant> Afficher_Postulant() {
        return postulantRepository.findAll();
    }

    // IMPLEMENTATION DE LA METHODE PERMETTANT D'INSERER LE POSTULANT
    @Override
    public Postulant creerPostulant(Postulant postulant) {
        return postulantRepository.save(postulant);
    }

    // IMPLEMENTATION DE LA METHODE PERMETTANT DE RETOURNER LE NOMBRE POSTULANT DANS LA TABLE POSTULANT
    @Override
    public long NombrePostulant(){

        return postulantRepository.count();

    }

    // IMPLEMENTATION DE LA METHODE PERMETTANT DE SUPPRIMER UN POSTULANT PAR SON ID
    @Override
    public void suprimerPostulantById(Long id){

        postulantRepository.deleteById(id);
    }

    // IMPLEMENTATION DE LA METHODE PERMETTANT DE TROUVER UN POSTULANT PAR SON ID
    @Override
    public List<Postulant> TrouverPostulantId(long id){

        return postulantRepository.findByIdp(id);
    }

}
