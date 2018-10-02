package manuel.com.co.listas.vistas.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import manuel.com.co.listas.R;
import manuel.com.co.listas.datasource.UserDataSource;
import manuel.com.co.listas.dominio.UserDominio;
import manuel.com.co.listas.modelo.User;

public class FormActivity extends AppCompatActivity implements UserDominio.View {

    @BindView(R.id.nameEditText)
    public EditText nombre;

    @BindView(R.id.idFirebaseEditText)
    public EditText idFirebase;

    @BindView(R.id.emailEditText)
    public EditText email;

    private UserDominio userDominio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
        userDominio = new UserDominio(this, UserDataSource.getInstance(this));
    }

    @OnClick({R.id.saveButton})
    public void guardarLocal(View v){
        if(validarFormulario()){
            userDominio.guardarUserLocal(new User(nombre.getText().toString(), idFirebase.getText().toString(), email.getText().toString()));
        }
    }

    private boolean validarFormulario(){
        boolean esValido = true;
        if(nombre.getText().toString().isEmpty()){
            nombre.setError("debe ingresar el nombre");
            esValido = false;
        }
        if(idFirebase.getText().toString().isEmpty()){
            idFirebase.setError("debe ingresar el apellido");
            esValido = false;
        }
        if(email.getText().toString().isEmpty()){
            email.setError("debe ingresar la dirección");
            esValido = false;
        }
        return esValido;
    }


    @Override
    public void showUser(List<User> users) {

    }

    @Override
    public void showMessage(int message) {

    }
}
