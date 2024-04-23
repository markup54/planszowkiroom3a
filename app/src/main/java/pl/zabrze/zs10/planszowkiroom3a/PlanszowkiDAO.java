package pl.zabrze.zs10.planszowkiroom3a;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlanszowkiDAO {
    @Insert
    public void wstawDoBazy(Planszowka planszowka);

    @Query("Select * from planszowki")
    public List<Planszowka> zwrocWszystkiePlanszowki();

    @Query("Select * from planszowki where :liczbaGraczy<=maxLiczbaOsob and :liczbaGraczy>=minLiczbaOsob")
    public List<Planszowka> zwrocPlanszowkiZLiczbaGraczy(int liczbaGraczy);

}
