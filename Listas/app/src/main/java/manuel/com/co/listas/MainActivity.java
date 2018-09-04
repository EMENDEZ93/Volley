package manuel.com.co.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import manuel.com.co.listas.datasource.UserDataSource;
import manuel.com.co.listas.datasource.UserRemoteDataSource;
import manuel.com.co.listas.dominio.UserDominio;
import manuel.com.co.listas.modelo.User;

public class MainActivity extends AppCompatActivity implements UserDominio.View {

    private UserAdapter userAdapter;
    private UserDominio userDominio;
    private RecyclerView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (RecyclerView) findViewById(R.id.lista);
        userAdapter = new UserAdapter(getApplicationContext(), null, this);


        userDominio = new UserDominio(this, UserDataSource.getInstance(this));
        userDominio.consultarUser();
        consultarUser();
    }

    private void consultarUser() {
        userDominio = new UserDominio(this, UserDataSource.getInstance(this));
        userDominio.consultarUser();
    }

    @Override
    public void showUser(List<User> users) {
        userAdapter = new UserAdapter(getApplicationContext(), users, this);
        lista.setAdapter(userAdapter);
    }

    @Override
    public void showMessage(int message) {
        Log.d("********* ERROR *******", getString(message));
    }
}
