package model;

import controller.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDao {

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
}
