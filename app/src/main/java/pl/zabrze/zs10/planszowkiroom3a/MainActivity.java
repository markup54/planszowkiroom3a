package pl.zabrze.zs10.planszowkiroom3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
PlanszowkiDatabase planszowkiDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        planszowkiDatabase = PlanszowkiDatabase.zwrocObiektBazyDanych(getApplicationContext());

        Planszowka planszowka = new Planszowka("Cyklady",2,5,12);
       // planszowkiDatabase.planszowkiDAO().wstawDoBazy(planszowka);
        Planszowka p1 = new Planszowka("Azul",2,4,10);
        Planszowka p2 = new Planszowka("Szachy",2,2,15);
        Planszowka p3 = new Planszowka("Root",2,4,14);
       // planszowkiDatabase.planszowkiDAO().wstawDoBazyKilkaPlanszowek(p1,p2,p3);

    }
}