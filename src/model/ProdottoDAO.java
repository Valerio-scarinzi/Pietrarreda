package model;

import controller.ConPool;
import controller.MyExceptionServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDAO {

  public ArrayList<Prodotto> getAllProdotti() {
    try (Connection con = ConPool.getConnection()) {
      ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM prodotto;");
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        Prodotto p=new Prodotto();
        p.setIdprod(rs.getInt(1));
        p.setNome(rs.getString(2));
        p.setDesc(rs.getString(3));
        p.setPrezzo(rs.getDouble(4));
        p.setDisponibilita(rs.getInt(5));
        p.setImgPath_prod(rs.getString(6));

        prodotti.add(p);
      }
      con.close();
      return prodotti;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  } //restituisci tutti i prodotti dal database

  public ArrayList<Prodotto> getProdByName(String nome_prod) {
    try (Connection con = ConPool.getConnection()) {
    ArrayList<Prodotto> prodotti=new ArrayList<>();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM Prodotto where instr(nome_prod,?)");
      ps.setString(1,nome_prod);
      ResultSet rs = ps.executeQuery();
      if(rs== null){
        throw new MyExceptionServlet("errore nella query di ricerca prodotto");
        }
      else{
        while(rs.next()){
          String name=rs.getString(2);
          int id=rs.getInt(1);
          String desc=rs.getString(3);
          int quant=rs.getInt(5);
          double prezzo=rs.getDouble(4);
          String img=rs.getString(6);
          Prodotto p=new Prodotto(id,name,desc,prezzo,quant,img);
          prodotti.add(p);
        }
      }

      con.close();
      return prodotti;
    } catch (SQLException | MyExceptionServlet e) {
      throw new RuntimeException(e);
    }


  }


  public Prodotto getProdById(int id) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps =
          con.prepareStatement("SELECT * FROM  prodotto WHERE id_prodotto=?");

      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {

        Prodotto p = new Prodotto();
        p.setIdprod(rs.getInt(1));
        p.setNome(rs.getString(2));
        p.setDesc(rs.getString(3));
        p.setPrezzo(rs.getDouble(4));
        p.setDisponibilita(rs.getInt(5));
        p.setImgPath_prod(rs.getString(6));
        return p;
      }

      con.close();
      return null;

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }


  public void doUpdate(int idprod,String nome,String img,String descr,double prezzo,int disponibilita){
    try(Connection connection=ConPool.getConnection()) {
      PreparedStatement ps=connection.prepareStatement("UPDATE Prodotto set  nome_prod=?,descrizione_prod=?,costo_prodotto=?,disponibilita_prod=?,imgPath_prod=? where Id_prodotto=?;");
      ps.setString(1,nome);
      ps.setString(2,descr);
      ps.setDouble(3,prezzo);
      ps.setInt(4, disponibilita);
      ps.setString(5,img);
      ps.setInt(6,idprod);
      ps.executeUpdate();
    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }

  }


  public void doDelete(int id_prodotto) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM Prodotto WHERE `Id_prodotto` = ?;");
      ps.setInt(1, id_prodotto);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("errore nella cancellazione");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public void doSave(Prodotto prodotto) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("INSERT into Prodotto (nome_prod,descrizione_prod,costo_prodotto,disponibilita_prod,imgPath_prod) VALUES (?,?,?,?,?);");
      ps.setString(1, prodotto.getNome());
      ps.setString(2, prodotto.getDesc());
      ps.setDouble(4, prodotto.getPrezzo());
      ps.setInt(3, prodotto.getDisponibilita());
      ps.setString(5, prodotto.getImgPath_prod());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("Errore nell'inserimento");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

 /* public ArrayList<Prodotto> SearchProdByName(String name_prod) {
    ArrayList<Prodotto> search_prod=new ArrayList<>();
    PreparedStatement ps=null;
    try(Connection connection=ConPool.getConnection()) {
      ps=connection.prepareStatement("SELECT * FROM  prodotto WHERE nome_prod=?;");
      ps.setString(1,name_prod);
      ResultSet rs=ps.executeQuery();
      if(rs== null)
        throw new Controller.MyExceptionServlet("errore nella query di ricerca prodotto");
      else{
        while (rs.next()){
          Prodotto p = new Prodotto();
          p.setIdprod(rs.getInt(1));
          p.setNome(rs.getString(2));
          p.setDesc(rs.getString(3));
          p.setPrezzo(rs.getDouble(4));
          p.setDisponibilita(rs.getInt(5));
          p.setImgPath_prod(rs.getString(6));
          search_prod.add(p);
        }
      }

    } catch (SQLException | Controller.MyExceptionServlet e) {
      e.printStackTrace();
    }
    return search_prod;
  }*/



}
