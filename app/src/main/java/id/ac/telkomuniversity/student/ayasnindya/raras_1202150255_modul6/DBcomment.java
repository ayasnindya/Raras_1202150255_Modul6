package id.ac.telkomuniversity.student.ayasnindya.raras_1202150255_modul6;

/**
 * Created by Hewlett Packard unyu on 1 Apr 2018.
 */

public class DBcomment {
    String userKomentar, isiKomentar, fotoKomentar;

    //Dibutuhkan kosong untuk membaca data
    public DBcomment(){

    }

    //Constructor dari class ini
    public DBcomment(String userKomentar, String isiKomentar, String fotoKomentar) {
        this.userKomentar = userKomentar;
        this.isiKomentar = isiKomentar;
        this.fotoKomentar = fotoKomentar;
    }

    //getter untuk variabel dari class ini
    public String getFotoKomentar() {
        return fotoKomentar;
    }

    public String getUserKomentar() {
        return userKomentar;
    }

    public String getIsiKomentar() {
        return isiKomentar;
    }

}