

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
        p.setAdmin(rs.getBoolean(7));

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
        p.setAdmin(rs.getBoolean(7));
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
      PreparedStatement ps = con.prepareStatement("INSERT into Utente (Nome,Cognome,username,passwordhash,email,admin) VALUES (?,?,?,?,?,?);");

      ps.setString(1, customer.getNome());
      ps.setString(2, customer.getCognome());
      ps.setString(3, customer.getUsername());
      ps.setString(4, customer.getPassword());
      ps.setString(5, customer.getEmail());
      ps.setBoolean(6,customer.isAdmin());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("Errore nell'inserimento");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public void doUpdate(int id,String nome,String cognome,String username,String password,String email,boolean admin) {
    try(Connection connection=ConPool.getConnection()) {
      PreparedStatement ps=connection.prepareStatement("UPDATE Utente set  Nome=?,Cognome=?,username=?,passwordhash=?,email=?,admin=? where Id_user=?;");
      ps.setString(1,nome);
      ps.setString(2,cognome);
      ps.setString(3,username);
      ps.setString(4, password);
      ps.setString(5,email);
      ps.setBoolean(6,admin);
      ps.setInt(7,id);
      ps.executeUpdate();
    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }
  }

  public void doDelete(int id) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM Utente WHERE `Id_user` = ?;");
      ps.setInt(1, id);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("errore nella cancellazione");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Utente doRetriveByEmail(String email){ //serve per controllo lato server: vede se esiste già un utente con stessa email.
    try (Connection con= ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM utente WHERE email=? ");
      ps.setString(1,email);
      ResultSet rs= ps.executeQuery();

      if(rs.next()){
        Utente p = new Utente();
        p.setId(rs.getInt(1));
        p.setNome(rs.getString(2));
        p.setCognome(rs.getString(3));
        p.setUsername(rs.getString(4));
        p.setPassword(rs.getString(5));
        p.setEmail(rs.getString(6));
        p.setAdmin(rs.getBoolean(7));
        return p;
      }
      } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Utente doRetrieveByUsernameEmailPassword(String email, String username, String password) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT * FROM  utente WHERE username=? AND passwordhash=? AND email=?");

      ps.setString(1, username);
      ps.setString(2, password);
      ps.setString(3,email);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {

        Utente p = new Utente();
        p.setId(rs.getInt(1));
        p.setNome(rs.getString(2));
        p.setCognome(rs.getString(3));
        p.setUsername(rs.getString(4));
        p.setPassword(rs.getString(5));
        p.setEmail(rs.getString(6));
        p.setAdmin(rs.getBoolean(7));
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

    public void doUpdate(int id, String newNome, String newCognome, String newUser, String newPass) {
      try(Connection connection=ConPool.getConnection()) {
        PreparedStatement ps=connection.prepareStatement("UPDATE Utente set  Nome=?,Cognome=?,username=?,passwordhash=? where Id_user=?;");
        ps.setString(1,newNome);
        ps.setString(2,newCognome);
        ps.setString(3,newUser);
        ps.setString(4,newPass);
        ps.setInt(5,id);
        ps.executeUpdate();
      }
      catch (SQLException e){
        throw new RuntimeException(e);
      }
    }

  public Utente doRetriveById(int id) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps =
              con.prepareStatement("SELECT * FROM  utente WHERE Id_user=?");

      ps.setInt(1,id);


      ResultSet rs = ps.executeQuery();

      if (rs.next()) {

        Utente p = new Utente();
        p.setId(rs.getInt(1));
        p.setNome(rs.getString(2));
        p.setCognome(rs.getString(3));
        p.setUsername(rs.getString(4));
        p.setPassword(rs.getString(5));
        p.setEmail(rs.getString(6));
        p.setAdmin(rs.getBoolean(7));
        return p;
      }

      con.close();
      return null;

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;

  }
}