package manuel.com.co.listas.modelo;

public class User {

    private String id;
    private String name;
    private String idFirebase;
    private String email;

    public User(String name, String idFirebase, String email){
        this.name = name;
        this.idFirebase = idFirebase;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdFirebase() {
        return idFirebase;
    }

    public void setIdFirebase(String idFirebase) {
        this.idFirebase = idFirebase;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
