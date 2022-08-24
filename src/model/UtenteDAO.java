

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
        p.setEmail(rs.getString(6));
        p.setPassword(rs.getString(5));

        customerList.add(p);

      }
      con.close();
      return customerList;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Utente doRetrieveByUsernamePassword(String username, String password) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps =
          con.prepareStatement("SELECT * FROM  utente WHERE username=? AND passwordhash=?");

      ps.setString(1, username);
      ps.setString(2, password);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {

        Utente p = new Utente();
        p.setId(rs.getInt(1));
        p.setNome(rs.getString(2));
        p.setCognome(rs.getString(3));
        p.setUsername(rs.getString(4));
        p.setPassword(rs.getString(5));
        p.setEmail(rs.getString(6));
        System.out.println(p.toString());
        return p;
      }

      con.close();
      return null;

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
}


  public void doSave(Utente customer) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("INSERT into Utente (Nome,Cognome,username,passwordhash,email,admin) VALUES (?,?,?,?,?,false);");

      ps.setString(1, customer.getNome());
      ps.setString(2, customer.getCognome());
      ps.setString(3, customer.getUsername());
      ps.setString(4, customer.getPassword());
      ps.setString(5, customer.getEmail());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}