package pl.zabrze.zs10.planszowkiroom3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PlanszowkiDatabase planszowkiDatabase;
    Button button;
    EditText editText;
    ListView listView;

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
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editTextIleOsob);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int ile = Integer.valueOf(editText.getText().toString());
                        List<Planszowka> listaPlanszowek = planszowkiDatabase
                                .planszowkiDAO().zwrocPlanszowkiZLiczbaGraczy(ile);

                        ArrayAdapter<Planszowka> adapter = new ArrayAdapter<>(getApplicationContext(),
                                android.R.layout.simple_list_item_1, listaPlanszowek);
                        listView.setAdapter(adapter);

                    }
                }
        );

    }
}