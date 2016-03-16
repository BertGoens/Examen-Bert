package bert.examenbert.storage.dao;

/* Created by Bert Goens */
public class VakDAO {
    private final int vak_id;
    private final String vak_naam;

    public VakDAO(int vak_id, String vak_naam) {
        this.vak_id = vak_id;
        this.vak_naam = vak_naam;
    }

    public int getVak_id() {
        return vak_id;
    }

    public String getVak_naam() {
        return vak_naam;
    }
}
