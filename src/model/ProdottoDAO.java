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
            PreparedStatement ps=connection.prepareStatement("UPDATE Prodotto set  nome_prod=?,descrizione_prod=?,costo_prodotto=?,quantita_prod=?,disponibilita_prod=? where Id_prodotto=?;");
            ps.setString(1,nome);
            ps.setString(2,descr);
            ps.setDouble(3,prezzo);
            ps.setInt(4, quantprodotto);
            ps.setInt(5,disponibilita);
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
            PreparedStatement ps = con.prepareStatement("INSERT into Prodotto (nome_prod,descrizione_prod,costo_prodotto,quantita_prod,disponibilita_prod) VALUES (?,?,?,?,?);");
            ps.setString(1, prodotto.getNome());
            ps.setString(2, prodotto.getDesc());
            ps.setDouble(4, prodotto.getPrezzo());
            ps.setInt(3, prodotto.getQuantprodotto());
            ps.setInt(5, prodotto.getDisponibilita());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore nell'inserimento");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
