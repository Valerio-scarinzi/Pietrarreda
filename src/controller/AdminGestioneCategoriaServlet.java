package controller;

import model.Categoria;
import model.CategoriaDAO;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GestioneCategoriaServlet")
public class AdminGestioneCategoriaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String newNome = (String) req.getParameter("cambiaNome");
        String newDesc = (String) req.getParameter("cambiaDesc");
        String newImg =(String) req.getParameter("cambiaImg");



        HttpSession recentSession = req.getSession();
        ArrayList<Categoria> lista = (ArrayList<Categoria>) recentSession.getAttribute("listCategorie");
        Categoria cat=new Categoria();


        CategoriaDAO categoriaDAO=new CategoriaDAO();
        int id=Integer.parseInt(req.getParameter("id"));

        categoriaDAO.doUpdate(id,newNome,newDesc,newImg);
        





        // rindirizzare al pannello admin delle categorie dopo ogni operazione
        resp.sendRedirect("CategorieServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
