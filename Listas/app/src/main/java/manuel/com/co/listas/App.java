package manuel.com.co.listas;


import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App  extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }

    public static App getInstance() {
        return instance;
    }

}
