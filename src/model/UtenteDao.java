package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDao {

  public Utente doRetrieveById(int id) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps =
          con.prepareStatement("SELECT utente, nome, cognome,username,passwordhash,email,admin,indirizzo FROM customer WHERE customerid=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Utente p = new Utente();
        p.setId(rs.getInt(1));
        p.setNome(rs.getString(2));
        p.setCognome(rs.getString(3));
        p.setUsername(rs.getString(4));
        p.setPassword(rs.getString(5));
        p.setEmail(rs.getString(6));

        return p;
      }
      con.close();
      return null;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


}
