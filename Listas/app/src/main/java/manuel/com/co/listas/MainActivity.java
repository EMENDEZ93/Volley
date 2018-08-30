package manuel.com.co.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import manuel.com.co.listas.modelo.User;

public class MainActivity extends AppCompatActivity {

    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView lista = (RecyclerView) findViewById(R.id.lista);
        userAdapter = new UserAdapter(getApplicationContext(), listaEstudiantes(), this);
        lista.setAdapter(userAdapter);

    }

    private List<User> listaEstudiantes() {
        List<User> users = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId("nombre" + i);
            user.setName("apellido" + i);
            user.setPhone("sexo" + i);
            users.add(user);
        }


        return users;
    }
}
