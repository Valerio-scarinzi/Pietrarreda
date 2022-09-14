package model;
import controller.ConPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ProdottoCategoriaDAO {

    public ArrayList<Categoria> getAllCategoriesFromProdID(int id_prod){
        ArrayList<Categoria> cat_prod= new ArrayList<>();
        try(Connection con= ConPool.getConnection()) {
            PreparedStatement ps=con.prepareStatement("SELECT DISTINCT nome_cat,descrizione_cat,img_categoria,Id_categoria \n"+
                    "FROM Categoria,ProdottoCategoria,Prodotto WHERE Id_prodotto=? and Id_categoria=id_Cat and id_prodotto=Id_prod"+
                    " ORDER BY category_name ");
            ps.setInt(1,id_prod);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Categoria cat= new Categoria(rs.getInt("Id_category"),rs.getString("category_name"),rs.getString(2),rs.getString(3));
                cat_prod.add(cat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cat_prod;
    }

}