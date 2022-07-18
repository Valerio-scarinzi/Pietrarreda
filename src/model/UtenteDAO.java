

package model;

import controller.ConPool;

import java.sql.*;
import java.util.ArrayList;

public class UtenteDAO {


  public ArrayList<Utente> doRetrieveAll() {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps =
          con.prepareStatement("SELECT * FROM Utente");

      ArrayList<Utente> customerList= new ArrayList<>();
      ResultSet rs = ps.executeQuery();

      while(rs.next()) {
        Utente p = new Utente();
        p.setId(rs.getInt(1));
        p.setNome(rs.getString(2));
        p.setCognome(rs.getString(3));
        p.setUsername(rs.getString(4));

        customerList.add(p);

      }
      con.close();
      return customerList;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  public void doSave(Utente customer) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
              "INSERT INTO Utente (default ,nome, cognome,username,passwordhash,email) VALUES(?,?,?,?,?)",
              Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, customer.getNome());
      ps.setString(2, customer.getCognome());
      ps.setString(3, customer.getUsername());
      ps.setString(4, customer.getPassword());
      ps.setString(5, customer.getEmail());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }

      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      int id = rs.getInt(1);
      customer.setId(id);
      con.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}