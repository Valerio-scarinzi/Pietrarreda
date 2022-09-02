package controller;



import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/DeleteCategoria")
public class AdminEliminaCatServlet extends HttpServlet {
    private Categoria categoria; //rimozione categoria dal DB
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id=Integer.parseInt(req.getParameter("id"));
        CategoriaDAO categoriaDAO=new CategoriaDAO();
        categoriaDAO.doDelete(id);

        resp.sendRedirect("CategorieServlet"); // rindirizzare al pannello admin delle categorie dopo ogni operazione
    }
}