package pl.zabrze.zs10.planszowkiroom3a;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Planszowka.class}, version = 1, exportSchema = false)
public abstract class PlanszowkiDatabase extends RoomDatabase {

    public abstract PlanszowkiDAO planszowkiDAO();

    private static volatile PlanszowkiDatabase instancjaBazyDanych;
    static final ExecutorService bazaDanychExecutor = Executors.newFixedThreadPool(4);

    public static PlanszowkiDatabase zwrocObiektBazyDanych(Context context){
        if(instancjaBazyDanych == null) {
            synchronized (PlanszowkiDatabase.class) {
                if(instancjaBazyDanych == null)
                instancjaBazyDanych = Room.databaseBuilder(
                                context.getApplicationContext(),
                                PlanszowkiDatabase.class,
                                "planszowki_db"
                        )
                        //.allowMainThreadQueries()
                        //.fallbackToDestructiveMigration()
                        .build();
            }
        }
        return instancjaBazyDanych;
    }

}
