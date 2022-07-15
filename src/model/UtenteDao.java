package model;

import java.sql.*;

public class UtenteDao { // Dao fa le query al database data access object

  public Utente doRetrieveById(int id) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps =
          con.prepareStatement("SELECT utente, nome, cognome,username,passwordhash,email,admin,indirizzo FROM utente WHERE id_user=?");
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

  public void doSave(Utente customer) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO utente (nome, cognome,username,passwordhash,email) VALUES(?,?,?,?,?)",
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