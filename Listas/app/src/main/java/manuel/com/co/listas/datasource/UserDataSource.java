package manuel.com.co.listas.datasource;

import android.content.Context;

import com.android.volley.RequestQueue;

import java.net.URL;

public class UserDataSource {

    private final static String URL_GET_USER = "https://fire-backend.herokuapp.com/users";
    private Context context;
    RequestQueue requestQueue;

    private UserDataSource(Context context){

    }

}
