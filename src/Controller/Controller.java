package Controller;

import Model.Games;
import Model.Transactions;
import Model.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Devid L Manurung
 */
public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    public Users getUser(String email, String password) {
    conn.connect();
    String query = "SELECT * FROM users WHERE email = ? AND password = ?";
    Users user = new Users();

    try {
        PreparedStatement preparedStatement = conn.con.prepareStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            // Assuming the Transactions list is managed separately
            user.setListTransactions(new ArrayList<>());
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    conn.disconnect();
    return user;
}


    public ArrayList<Games> getAllGames(int userId) {
        ArrayList<Games> game = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM games WHERE id ='" + userId + "'";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Games games = new Games();
                games.setId(rs.getInt("id"));
                games.setName(rs.getString("name"));
                games.setGenre(rs.getString("genre"));
                games.setPrice(rs.getInt("price"));

            }
        } catch (SQLException e) {
            System.out.println("MASUK CATCH GET ALL TODOS : ");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("MASUK CATCH GET ALL TODOS NULL : ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("MASUK CATCH GET ALL TODOS NULL : ");
            e.printStackTrace();
        }
        conn.disconnect();
        return (game);
    }
    
    // Menu 2
    public boolean insertNewGames(Games games) {
        conn.connect();
        String query = "INSERT INTO games VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, games.getId());
            stmt.setString(2, games.getName());
            stmt.setString(3, games.getGenre()); 
            stmt.setInt(4, games.getPrice());   
            stmt.executeUpdate();
            conn.disconnect();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return (false);
        }
    }
    
    //ini select semua dari table todo
     public ArrayList<Transactions> getTransactions(int userID) {
        conn.connect();
        String query = "SELECT transactions.id, transactions.user_id, users.name, transactions.game_id, games.name, games.price\n"
                + "FROM transactions\n"
                + "JOIN users ON users.id = transactions.user_id\n"
                + "JOIN games ON games.id = transactions.game_id\n"
                + "WHERE transactions.user_id = '" + userID + "'";
        ArrayList<Transactions> listTransactions = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                

      
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listTransactions);
    }

}