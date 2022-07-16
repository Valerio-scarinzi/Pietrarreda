

package model;

import controller.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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



}