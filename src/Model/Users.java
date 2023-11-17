package Model;

import java.util.ArrayList;

/**
 *
 * @author Devid L Manurung
 */
public class Users {
    private int id;
    private String name;
    private String email;
    private String password;
    private ArrayList<Transactions> listTransactions;

    public Users(int id, String name, String email, String password, ArrayList<Transactions> listTransactions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.listTransactions = listTransactions;
    }

    public Users() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Transactions> getListTransactions() {
        return listTransactions;
    }

    public void setListTransactions(ArrayList<Transactions> listTransactions) {
        this.listTransactions = listTransactions;
    }
}
