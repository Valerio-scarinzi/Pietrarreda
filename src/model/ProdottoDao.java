package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDao {

    public ArrayList<Prodotto> getAllProdotti() {
        try (Connection con = ConPool.getConnection()) {
            ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
            PreparedStatement ps = con.prepareStatement("SELECT id_prodotto,nome_prod,descrizione_prod,costo_prodotto,quantita_prod,disponibilita_prod FROM Prodotto;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

            }
            //da continuare
            //da continuare
            //da continuare
            //da continuare

            return prodotti;
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

    }


}
