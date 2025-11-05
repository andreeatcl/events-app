package ro.ase.pdm.events.model;

import java.io.Serializable;

public class Eveniment implements Serializable {
    String denumire;
    String categorie;
    String data;
    String loculDesfasurarii;
    String descriere;

    public Eveniment(String denumire, String categorie, String data, String loculDesfasurarii, String descriere) throws Exception {
        setDenumire(denumire);
        setCategorie(categorie);
        setData(data);
        setLoculDesfasurarii(loculDesfasurarii);
        setDescriere(descriere);
    }

    public Eveniment() {
        denumire = "Eveniment nou";
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) throws Exception {
        if (denumire.isEmpty() || !denumire.matches("^[A-Za-z0-9\\s]+$"))
            throw new Exception("Denumirea evenimentului nu este valida.");
        this.denumire = denumire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) throws Exception {
        if (categorie.isEmpty() || !categorie.matches("^[A-Za-z0-9\\s]+$"))
            throw new Exception("Categoria evenimentului nu este valida.");

        this.categorie = categorie;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) throws Exception {
        if (data.isEmpty() || !data.matches("^\\d{2}/\\d{2}/\\d{4}\\s\\d{2}:\\d{2}$"))
            throw new Exception("Data evenimentului nu este valida.");

        this.data = data;
    }

    public String getLoculDesfasurarii() {
        return loculDesfasurarii;
    }

    public void setLoculDesfasurarii(String loculDesfasurarii) throws Exception {
        if (loculDesfasurarii.isEmpty() || !denumire.matches("^[A-Za-z0-9\\s]+$"))
            throw new Exception("Adresa evenimentului nu este valida.");

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
