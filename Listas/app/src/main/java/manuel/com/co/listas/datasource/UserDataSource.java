package manuel.com.co.listas.datasource;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.net.URL;
import java.util.List;

import io.realm.Realm;
import manuel.com.co.listas.modelo.User;
import manuel.com.co.listas.modelo.UserRealm;

public class UserDataSource implements UserRemoteDataSource, UserDataSourceLocal {

    private final static String URL_GET_USER = "https://fire-backend.herokuapp.com/users";
    private Context context;
    private RequestQueue requestQueue;
    private static UserRemoteDataSource  INSTANCE = null;

    private UserDataSource(Context context){
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    public static UserRemoteDataSource getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new  UserDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void consultarUser(final GetUserCallback callback) {
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                URL_GET_USER,
                null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                try {

                    Gson gson = new Gson();
                    List<User> users = (List<User>) gson.fromJson(response.toString(), new TypeToken<List<User>>(){}.getType());
                    callback.onUserLoader(users);
                } catch (Exception e) {
                    callback.onError();
                }
              }
            }, new  Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    callback.onError();
                }
        });
        requestQueue.add(request);
    }

    @Override
    public void guardarUserLocal(userLocalCallback callback, User user) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        UserRealm userRealm = realm.createObject(UserRealm.class);
        userRealm.setName(user.getName());
        userRealm.setIdFirebase(user.getIdFirebase());
        userRealm.setEmail(user.getEmail());
    }
}
