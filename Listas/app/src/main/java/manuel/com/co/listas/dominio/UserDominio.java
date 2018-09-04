package manuel.com.co.listas.dominio;

import android.view.View;

import java.util.List;

import manuel.com.co.listas.R;
import manuel.com.co.listas.datasource.UserRemoteDataSource;
import manuel.com.co.listas.modelo.User;

public class UserDominio {

    private View view;
    private UserRemoteDataSource userRemoteDataSource;

    public UserDominio(View view, UserRemoteDataSource userRemoteDataSource){
        this.view = view;
        this.userRemoteDataSource = userRemoteDataSource;

    }

    public void consultarUser(){
        userRemoteDataSource.consultarUser(new UserRemoteDataSource.GetUserCallback() {
            @Override
            public void onUserLoader(List<User> users) {
                view.showUser(users);
            }

            @Override
            public void onError() {
                view.showMessage(R.string.error_generico);
            }
        });
    }


    public interface View {
        void showUser(List<User> users);
        void showMessage(int message);
    }

}
