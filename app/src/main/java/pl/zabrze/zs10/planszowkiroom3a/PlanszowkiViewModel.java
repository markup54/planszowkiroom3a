package pl.zabrze.zs10.planszowkiroom3a;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PlanszowkiViewModel extends AndroidViewModel {

    private PlanszowkiRepozytorium planszowkiRepozytorium;
    private LiveData<List<Planszowka>> planszowki;

    public PlanszowkiViewModel(@NonNull Application application) {
        super(application);
        planszowkiRepozytorium = new PlanszowkiRepozytorium(application);
        planszowki = planszowkiRepozytorium.getWszystkiePlanszowki();
    }

    public LiveData<List<Planszowka>> zwrocPlanszowki(int ile){
        return planszowkiRepozytorium.zwrocPlanszowkiwedlugLiczbyGraczy(ile);
    }

    public LiveData<List<Planszowka>> getPlanszowki() {
        return planszowki;
    }
    public void wstawPlanszowke(Planszowka planszowka){
        planszowkiRepozytorium.wstawPlanszowke(planszowka);
    }
}
