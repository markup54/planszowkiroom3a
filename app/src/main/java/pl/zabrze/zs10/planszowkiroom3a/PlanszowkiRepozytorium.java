package pl.zabrze.zs10.planszowkiroom3a;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PlanszowkiRepozytorium {
    private PlanszowkiDAO planszowkiDAO;
    private LiveData<List<Planszowka>> wszystkiePlanszowki;


    PlanszowkiRepozytorium(Application application){
        PlanszowkiDatabase db = PlanszowkiDatabase.zwrocObiektBazyDanych(application);
        planszowkiDAO = db.planszowkiDAO();
        wszystkiePlanszowki = planszowkiDAO.zwrocWszystkiePlanszowki();
    }

    LiveData<List<Planszowka>> zwrocPlanszowkiwedlugLiczbyGraczy(int liczba){
        return planszowkiDAO.zwrocPlanszowkiZLiczbaGraczy(liczba);
    }

    public LiveData<List<Planszowka>> getWszystkiePlanszowki() {
        return wszystkiePlanszowki;
    }

    void wstawPlanszowke(Planszowka planszowka){
        PlanszowkiDatabase.bazaDanychExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        planszowkiDAO.wstawDoBazy(planszowka);
                    }
                }
        );
    }
}
