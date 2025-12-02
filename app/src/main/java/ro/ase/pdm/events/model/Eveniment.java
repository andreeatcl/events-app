package ro.ase.pdm.events.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "evenimente")
public class Eveniment implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;
    String denumire;
    String categorie;
    String data;
    String ora;
    String loculDesfasurarii;
    String descriere;

    public Eveniment(String denumire, String categorie, String data, String ora, String loculDesfasurarii, String descriere) {
        setDenumire(denumire);
        setCategorie(categorie);
        setData(data);
        setOra(ora);
        setLoculDesfasurarii(loculDesfasurarii);
        setDescriere(descriere);
    }

    @Ignore
    public Eveniment() {
        denumire = "Eveniment nou";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    // to do: muta validarile intr-o functie. daca nu e bun => nu se adauga/modifica in loc de throw exception
    public void setDenumire(String denumire) {
        if (denumire.isEmpty() || !denumire.matches("^[A-Za-z0-9\\s]+$"))
            throw new RuntimeException("Denumirea evenimentului nu este valida.");
        this.denumire = denumire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        if (categorie.isEmpty() || !categorie.matches("^[A-Za-z0-9\\s]+$"))
            throw new RuntimeException("Categoria evenimentului nu este valida.");

        this.categorie = categorie;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (data.isEmpty() || !data.matches("^\\d{4}-\\d{2}-\\d{2}$"))
            throw new RuntimeException("Data evenimentului nu este valida.");

        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        if (ora.isEmpty() || !ora.matches("^\\d{2}:\\d{2}$"))
            throw new RuntimeException("Ora evenimentului nu este valida.");

        this.ora = ora;
    }

    public String getLoculDesfasurarii() {
        return loculDesfasurarii;
    }

    public void setLoculDesfasurarii(String loculDesfasurarii) {
        if (loculDesfasurarii.isEmpty() || !denumire.matches("^[A-Za-z0-9\\s]+$"))
            throw new RuntimeException("Adresa evenimentului nu este valida.");

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
                ", ora='" + ora + '\'' +
                ", loculDesfasurarii='" + loculDesfasurarii + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
