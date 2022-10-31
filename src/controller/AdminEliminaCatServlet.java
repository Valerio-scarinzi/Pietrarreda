package controller;



import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/DeleteCategoria")//rimozione categoria dal DB
public class AdminEliminaCatServlet extends HttpServlet {
    private Categoria categoria;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id=Integer.parseInt(req.getParameter("id"));// prendi id passato
        CategoriaDAO categoriaDAO=new CategoriaDAO();
        categoriaDAO.doDelete(id);//elimina dal DB la categoria attraverso l id

        resp.sendRedirect("CategorieServlet"); //rindirizzare al pannello admin delle categorie dopo ogni operazione
    }
}