package pl.zabrze.zs10.planszowkiroom3a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PlanszowkiDatabase planszowkiDatabase;
    private PlanszowkiViewModel planszowkiViewModel;
    Button button;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planszowkiViewModel = new ViewModelProvider(
                this,
                new ViewModelProvider.AndroidViewModelFactory(
                        getApplication()
                )
        ).get(PlanszowkiViewModel.class);

        planszowkiViewModel.getPlanszowki().observe(this, new Observer<List<Planszowka>>() {
            @Override
            public void onChanged(List<Planszowka> planszowkas) {
                ArrayAdapter<Planszowka> adapter = new ArrayAdapter<>(
                        getApplication(),
                        android.R.layout.simple_list_item_1,
                        planszowkas
                );
                ListView listView = findViewById(R.id.listView2);
                listView.setAdapter(adapter);
            }
        });
        planszowkiDatabase = PlanszowkiDatabase.zwrocObiektBazyDanych(getApplicationContext());

        Planszowka planszowka = new Planszowka("Cyklady",2,5,12);
        planszowkiViewModel.wstawPlanszowke(planszowka);
        // planszowkiDatabase.planszowkiDAO().wstawDoBazy(planszowka);
        Planszowka p1 = new Planszowka("Azul",2,4,10);
        Planszowka p2 = new Planszowka("Szachy",2,2,15);
        Planszowka p3 = new Planszowka("Root",2,4,14);
       // planszowkiDatabase.planszowkiDAO().wstawDoBazyKilkaPlanszowek(p1,p2,p3);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editTextIleOsob);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int ile = Integer.valueOf(editText.getText().toString());
                       // List<Planszowka> listaPlanszowek = planszowkiDatabase
                         //       .planszowkiDAO().zwrocPlanszowkiZLiczbaGraczy(ile);
                        planszowkiViewModel
                                .zwrocPlanszowki(ile)
                                .observe(
                                        MainActivity.this,
                                        new Observer<List<Planszowka>>() {
                                            @Override
                                            public void onChanged(List<Planszowka> planszowkas) {
                                                ArrayAdapter<Planszowka> adapter =
                                                        new ArrayAdapter<>(getApplicationContext(),
                                                                android.R.layout.simple_list_item_1, planszowkas);
                                                listView.setAdapter(adapter);
                                            }
                                        }
                                );


                    }
                }
        );

    }
}