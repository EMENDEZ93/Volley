package manuel.com.co.listas.datasource;

import manuel.com.co.listas.modelo.User;

public interface UserDataSourceLocal {

    void guardarUserLocal(userLocalCallback callback, User user);

    public interface userLocalCallback{
        void onUserLocalSave(User user);
        void onError();
    }

}
