package model;

import controller.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO  {




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


    public void doUpdate(int idcat,String nome,String descr,String imgCat) {
        try(Connection connection=ConPool.getConnection()) {
            PreparedStatement ps=connection.prepareStatement("UPDATE Categoria set  nome_cat=?,descrizione_cat=?,img_categoria=? where Id_categoria=?;");
            ps.setString(1,nome);
            ps.setString(2,descr);
            ps.setString(3,imgCat);
            ps.setInt(4,idcat);
            ps.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doSave(Categoria categoria) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT into Categoria (nome_cat,descrizione_cat,img_categoria) VALUES (?,?,?);");
            ps.setString(1, categoria.getCategoria_nome());
            ps.setString(2, categoria.getDescrizione());
            ps.setString(3, categoria.getImg());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore nell'inserimento");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void doDelete(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Categoria WHERE `Id_categoria` = ?;");
            ps.setInt(1, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("errore nella cancellazione");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
