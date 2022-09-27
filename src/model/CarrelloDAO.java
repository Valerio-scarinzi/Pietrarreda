package model;

import controller.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CarrelloDAO {

    public static void doDeleteAll(Carrello carrello) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM carrello WHERE Id_usr=?");
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
            ps=con.prepareStatement("delete from carrello where Id_prd=? and Id_usr=?;");
            ps.setInt(1,idProdotto);
            ps.setInt(2,idCliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void doSave(int idUser, int idPrd, int quantita,Carrello carrello) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT into carrello (Id_sc,Id_usr,Id_prd,Total_price,qty_product) VALUES (?,?,?,?,?);");
            ps.setInt(1, idUser);
            ps.setInt(2, idUser);
            ps.setInt(3, idPrd);
            ps.setDouble(4,carrello.getPrezzoTotCar());
            ps.setInt(5, quantita);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore nell'inserimento");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /*public static ArrayList<Carrello> doRetriveCartByIdUtente(int idUtente) {

        ArrayList<Carrello> carrellos = new ArrayList<Carrello>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM  Carrello WHERE Id_usr=?");
            ps.setInt(1,idUtente);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Carrello p = new Carrello();
                p.setIdSc(rs.getInt(1));
                p.setIdUtente(rs.getInt(2));
                p.s(rs.getInt(3));
                p.( rs.getDouble(4));
                p.setQuantita(rs.getInt(5));
                carrellos.add(p);
            }


            con.close();
            return carrellos;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return carrellos;
    }*/


    public Carrello getCarrelloByUser(int idUtente){
        PreparedStatement ps;
        try(Connection con = ConPool.getConnection()){
            ps = con.prepareStatement("select Id_sc, Id_usr, Id_prd, nome_prod, costo_prodotto,descrizione_prod,qty_product,Total_price from carrello join prodotto on id_prd = prodotto.id_prodotto where Id_usr=?;");
            ps.setInt(1,idUtente);
            HashMap<Integer, Carrello.ProdottoQuantita> list_product= new HashMap<>();
            Carrello cart = new Carrello();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Prodotto p = new Prodotto();
                cart.setIdcarrello(rs.getInt(1));
                cart.setIdutente(rs.getInt(2));
                p.setNome(rs.getString(4));
                p.setPrezzo(rs.getDouble(5));
                p.setDesc(rs.getString(6));
                p.setIdprod(rs.getInt(3));
                Carrello.ProdottoQuantita prodottoQuantita=new Carrello.ProdottoQuantita(p, rs.getInt(7));
                list_product.put(rs.getInt(3),prodottoQuantita);
                cart.setPrezzoTotCar(rs.getDouble(8));

            }
            cart.setProdotti(list_product);
            return cart;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

  public static void setQuantita(Carrello carrello, int new_qty, int idProdotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(" update carrello  set qty_product=?  where Id_prd=? and Id_usr=?; ");
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
            PreparedStatement ps = con.prepareStatement(" update carrello  set Total_price=?  where Id_prd=? and Id_usr=?; ");
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
