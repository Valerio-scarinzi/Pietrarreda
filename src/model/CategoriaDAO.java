package model;

import controller.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO  {


    public static ArrayList<Categoria> doRetrieveAllCategory;

    public ArrayList<Categoria> doRetrieveAllCategory() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Categoria");

            ArrayList<Categoria> categoriaList= new ArrayList<>();
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Categoria p = new Categoria();
                p.setId(rs.getInt(1));
                p.setCategoria_nome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setImg(rs.getString(4));


                categoriaList.add(p);

            }
            con.close();
            return categoriaList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
