package pl.zabrze.zs10.planszowkiroom3a;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "planszowki")
public class Planszowka {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_planszowki")
    private int id;
    private String nazwa;
    private int minLiczbaOsob;
    private int maxLiczbaOsob;
    private int wiek;

    public Planszowka(String nazwa, int minLiczbaOsob, int maxLiczbaOsob, int wiek) {
        id =0;
        this.nazwa = nazwa;
        this.minLiczbaOsob = minLiczbaOsob;
        this.maxLiczbaOsob = maxLiczbaOsob;
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Planszowka: "+ nazwa ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getMinLiczbaOsob() {
        return minLiczbaOsob;
    }

    public void setMinLiczbaOsob(int minLiczbaOsob) {
        this.minLiczbaOsob = minLiczbaOsob;
    }

    public int getMaxLiczbaOsob() {
        return maxLiczbaOsob;
    }

    public void setMaxLiczbaOsob(int maxLiczbaOsob) {
        this.maxLiczbaOsob = maxLiczbaOsob;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
}
