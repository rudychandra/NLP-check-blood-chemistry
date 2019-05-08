package bimbingan_deby;

public class HasilCek {

    private String kategori, field, hasil, selisih, traction;

    public HasilCek(String kategori, String field, String hasil, String selisih, String traction) {
        this.kategori = kategori;
        this.field = field;
        this.hasil = hasil;
        this.selisih = selisih;
        this.traction = traction;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public String getSelisih() {
        return selisih;
    }

    public void setSelisih(String selisih) {
        this.selisih = selisih;
    }

    public String getTraction() {
        return traction;
    }

    public void setTraction(String traction) {
        this.traction = traction;
    }

}
