package manuel.com.co.listas.datasource;

import java.util.List;

import manuel.com.co.listas.modelo.User;

public interface UserRemoteDataSource {

    void consultarUser(GetUserCallback callback);

    public interface GetUserCallback{
        void onUserLoader(List<User> users);
        void onError();
    }
}
