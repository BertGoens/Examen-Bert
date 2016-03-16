package bert.examenbert.storage.dao;

/* Created by Bert Goens */
public class StudentDAO {
    private final int student_id;
    private final String student_naam;
    private final String student_voornaam;
    private final int klas_id;

    public StudentDAO(int student_id, String student_naam, String student_voornaam, int klas_id) {
        this.student_id = student_id;
        this.student_naam = student_naam;
        this.student_voornaam = student_voornaam;
        this.klas_id = klas_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getStudent_naam() {
        return student_naam;
    }

    public String getStudent_voornaam() {
        return student_voornaam;
    }

    public int getKlas_id() {
        return klas_id;
    }
}
