package pl.zabrze.zs10.planszowkiroom3a;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlanszowkiDAO {
    @Insert
    public void wstawDoBazy(Planszowka planszowka);

    @Insert
    public void wstawDoBazyKilkaPlanszowek(Planszowka ... planszowki);

    @Query("Select * from planszowki")
    public LiveData<List<Planszowka>> zwrocWszystkiePlanszowki();

    @Query("Select * from planszowki where :liczbaGraczy<=maxLiczbaOsob and :liczbaGraczy>=minLiczbaOsob")
    public LiveData<List<Planszowka>> zwrocPlanszowkiZLiczbaGraczy(int liczbaGraczy);

}
