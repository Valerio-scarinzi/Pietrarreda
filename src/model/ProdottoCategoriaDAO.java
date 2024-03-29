package model;
import controller.ConPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ProdottoCategoriaDAO {

    public ArrayList<Categoria> getAllCategoriesFromProdID(int id_prod) {
        ArrayList<Categoria> cat_prod = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT nome_cat,descrizione_cat,img_categoria,Id_categoria \n" +
                "FROM Categoria,ProdottoCategoria,Prodotto WHERE Id_prodotto=? and Id_categoria=id_Cat and id_prodotto=Id_prod" +
                " ORDER BY category_name ");
            ps.setInt(1, id_prod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria(rs.getInt("Id_category"), rs.getString("category_name"), rs.getString(2), rs.getString(3));
                cat_prod.add(cat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cat_prod;
    }

    public ArrayList<ProdottoCategoria> doRetrieveAllProdCat() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM ProdottoCategoria");

            ArrayList<ProdottoCategoria> categoriaList = new ArrayList<>();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProdottoCategoria p = new ProdottoCategoria();
                p.setId_prod(rs.getInt(1));
                p.setId_cat(rs.getInt(2));


                categoriaList.add(p);

            }
            con.close();
            return categoriaList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<ProdottoCategoria> getProdByCatId(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM ProdottoCategoria  WHERE id_cat=?");
            ArrayList<ProdottoCategoria> categoriaList = new ArrayList<>();
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ProdottoCategoria p = new ProdottoCategoria();
                p.setId_prod(rs.getInt(1));
                p.setId_cat(rs.getInt(2));


                categoriaList.add(p);

            }

            con.close();
            return categoriaList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}