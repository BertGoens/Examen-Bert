package bert.examenbert.api;

/* Created by Bert Goens */
public interface Config {
    String HOST = "http://werfregistratie.be/";
    String FOLDER = "prog5/david/prog5/"; //TODO: Juiste folder?

    String TABEL_STUDENTEN = "studenten";
    String TABEL_VAKKEN = "vakken";

    //region Adressen van de scripts
    //CRUD Studenten
    String URL_STUDENTEN_ADD = HOST + FOLDER + TABEL_STUDENTEN + "Add.php";
    String URL_STUDENTEN_GET = HOST + FOLDER + TABEL_STUDENTEN + "Get.php?student_id=";
    String URL_STUDENTEN_GET_ALL = HOST + FOLDER + TABEL_STUDENTEN + "GetAll.php";
    String URL_STUDENTEN_UPDATE = HOST + FOLDER + TABEL_STUDENTEN + "Update.php";
    String URL_STUDENTEN_DELETE = HOST + FOLDER + TABEL_STUDENTEN + "Delete.php?student_id=";

    //CRUD Vakken
    String URL_VAKKEN_ADD = HOST + FOLDER + TABEL_VAKKEN + "Add.php";
    String URL_VAKKEN_GET = HOST + FOLDER + TABEL_VAKKEN + "Get.php?vak_id=";
    String URL_VAKKEN_GET_ALL = HOST + FOLDER + TABEL_VAKKEN + "GetAll.php";
    String URL_VAKKEN_UPDATE = HOST + FOLDER + TABEL_VAKKEN + "Update.php";
    String URL_VAKKEN_DELETE = HOST + FOLDER + TABEL_VAKKEN + "Delete.php?vak_id=";
    //endregion

    //php script verzend parameters (crud operaties)
    //Ook gebruikt als JSON tags
    String STUDENT_ID = "student_id";
    String STUDENT_NAAM = "student_naam";
    String STUDENT_VOORNAAM = "student_voornaam";
    String STUDENT_KLAS_ID = "klas_id";

    String VAK_ID = "vak_id";
    String VAK_NAAM = "vak_naam";

    //php script results
    String JSON_RESULT_ARRAY = "result";
}
