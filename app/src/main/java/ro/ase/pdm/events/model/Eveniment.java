package ro.ase.pdm.events.model;

public class Eveniment {
    String denumire;
    String categorie;
    String data;
    String loculDesfasurarii;
    String descriere;

    // de adaugat: validari de input
    public Eveniment(String denumire, String categorie, String data, String loculDesfasurarii, String descriere) {
        this.denumire = denumire;
        this.categorie = categorie;
        this.data = data;
        this.loculDesfasurarii = loculDesfasurarii;
        this.descriere = descriere;
    }

    public Eveniment() {}

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLoculDesfasurarii() {
        return loculDesfasurarii;
    }

    public void setLoculDesfasurarii(String loculDesfasurarii) {
        this.loculDesfasurarii = loculDesfasurarii;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                "denumire='" + denumire + '\'' +
                ", categorie='" + categorie + '\'' +
                ", data='" + data + '\'' +
                ", loculDesfasurarii='" + loculDesfasurarii + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
