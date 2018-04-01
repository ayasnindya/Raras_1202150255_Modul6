package id.ac.telkomuniversity.student.ayasnindya.raras_1202150255_modul6;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Hewlett Packard unyu on 1 Apr 2018.
 */

public class FirebaseApps extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if(!FirebaseApp.getApps(this).isEmpty())
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
}
