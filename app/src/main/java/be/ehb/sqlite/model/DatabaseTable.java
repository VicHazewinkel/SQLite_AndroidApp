package be.ehb.sqlite.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

// 1.
// aanmaken van de tabel in de database met de kolommen id, naam en kleur
//
@Entity
public class DatabaseTable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String naam;
    private String kleur;

    public DatabaseTable() {
    }

    @Ignore
    public DatabaseTable(int id, String naam, String kleur) {
        this.id = id;
        this.naam = naam;
        this.kleur = kleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
}
