package model;

import controller.ConPool;
import model.Carrello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CarrelloDAO {
  public static void doDeleteAll(Carrello carrello) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM Carrello WHERE Id_usr=?");
      ps.setInt(1, carrello.getIdutente());
      if (ps.executeUpdate() == 0) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void deleteProdotto(int idCliente, int idProdotto){
    PreparedStatement ps = null;
    try(Connection con = ConPool.getConnection()){
      ps=con.prepareStatement("delete from Carrello where Id_prd=? and Id_usr=?;");
      ps.setInt(1,idProdotto);
      ps.setInt(2,idCliente);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }




  public static int doSave(int idCliente, int idProdotto, int quantitaCarrello, int idCarrello, Carrello cart){
    PreparedStatement ps = null;
    try(Connection con = ConPool.getConnection()){
      ps=con.prepareStatement("insert into Carrello(Id_sc,Id_usr,Id_prd,qty_product,Total_price) values(?,?,?,?,?)");
      ps.setInt(1,idCarrello);
      ps.setInt(2,idCliente);
      ps.setInt(3,idProdotto);
      ps.setInt(4,quantitaCarrello);
      ps.setDouble(5,cart.getTotalPrice());
      int res = ps.executeUpdate();
      return res;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }


  public static void doDeleteUsrID(int id_usr){
    try(Connection con = ConPool.getConnection()) {
      PreparedStatement ps=con.prepareStatement("DELETE FROM Carrello where Id_usr=?");
      ps.setInt(1,id_usr);
      ps.executeUpdate();
    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }
  }

  public static void doDeletebyProdID(int id_prod){
    try(Connection con = ConPool.getConnection()) {
      PreparedStatement ps=con.prepareStatement("DELETE FROM Carrello where Id_prd=?");
      ps.setInt(1,id_prod);
      ps.executeUpdate();
    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }
  }
  public Carrello doRetrieveByUser(int idCliente){
    PreparedStatement ps = null;
    try(Connection con = ConPool.getConnection()){
      ps = con.prepareStatement("select Id_sc , Id_usr from Carrello where  Id_usr=?;");
      ps.setInt(1,idCliente);
      ResultSet rs = ps.executeQuery();
      if(rs.next()){
        Carrello cart = new Carrello();
        cart.setIdcarrello(rs.getInt("id_carrello"));
        cart.getIdprodotto(rs.getInt("id_cliente"));
        return cart;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Carrello getCarrelloByUser(int idUtente){
    PreparedStatement ps;
    try(Connection con = ConPool.getConnection()){
      ps = con.prepareStatement("select Id_sc, Id_usr, Id_prd, name_product, price,short_descripton,shipping_cart.qty_product,Total_price from Carrello join Product on Shipping_cart.Id_prd = Product.Id_product where Id_usr=?;");
      ps.setInt(1,idUtente);
      HashMap<Integer, Carrello.ProdottoQuantità> list_product= new HashMap<>();
      Carrello cart = new Carrello();
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        Prodotto e = new Prodotto();
        cart.setIdcarrello(rs.getInt("Id_sc"));
        cart.setIdutente(rs.getInt("Id_usr"));
        e.setNome(rs.getString(4));
        e.setPrezzo(rs.getDouble(5));
        e.setDesc(rs.getString(6));
        e.setIdprod((rs.getInt(3)));
        Carrello.ProdottoQuantità prodottoQuantità=new Carrello.ProdottoQuantità(e, rs.getInt(7));
        list_product.put(rs.getInt(3),prodottoQuantità);
        cart.setTotalPrice(rs.getDouble(8));
      }
      cart.setProd_cart(list_product);
      return cart;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;

  }
  public static void setQuantita(Carrello carrello, int new_qty, int idProdotto) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement(" update Carrello  set qty_product=?  where Id_prd=? and Id_usr=?; ");
      ps.setInt(1, new_qty);
      ps.setInt(2, idProdotto);
      ps.setInt(3, carrello.getIdutente());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE1 error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public static void setPrezzo(Carrello cart, double new_price,int idProdotto){
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement(" update Carrello  set Total_price=?  where Id_prd=? and Id_usr=?; ");
      ps.setDouble(1, new_price);
      ps.setInt(2, idProdotto);
      ps.setInt(3, cart.getIdutente());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE2 error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }




}
