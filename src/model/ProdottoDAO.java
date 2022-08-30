package model;

import controller.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDAO {

    public ArrayList<Prodotto> getAllProdotti() {
        try (Connection con = ConPool.getConnection()) {
            ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Prodotto;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Prodotto p=new Prodotto();
                p.setIdprod(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDesc(rs.getString(3));
                p.setPrezzo(rs.getDouble(4));
                p.setQuantprodotto(rs.getInt(5));
                p.setDisponibilita(rs.getInt(6));

                prodotti.add(p);
            }
            con.close();
            return prodotti;
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    } //restituisci tutti i prodotti dal database

    public ArrayList<Prodotto> getProdByName(String name_prod) {
        try (Connection con = ConPool.getConnection()) {
            ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Prodotto where nome_prod=?;");
            ResultSet rs = ps.executeQuery();

            con.close();
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void doUpdate(int idprod,String nome,int quantprodotto,String descr,double prezzo,int disponibilita){
        try(Connection connection=ConPool.getConnection()) {
            PreparedStatement ps=connection.prepareStatement("UPDATE prodotto set idprod=?, nome=?,quantprodotto=?,descr=?,prezzo=?,disponibilita=?,where Id_product=?;");
            ps.setInt(1,idprod);
            ps.setString(2,nome);
            ps.setString(3,descr);
            ps.setDouble(4,prezzo);
            ps.setInt(5,disponibilita);
      
            ps.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }


    public void doDelete(int parseInt) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Prodotto WHERE `Idprod` = ?;");
            ps.setInt(1, parseInt);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("errore nella cancellazione");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
