package controller;




import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/AddCategoria")
public class AddCategoria extends HttpServlet { //aggiunta categoria al DB

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //prendo i parametri dati in input dal form
        String nome = (String) req.getParameter("nome");
        String descrizione= (String) req.getParameter("descrizione");
        String immagine= (String) req.getParameter("immagine");//N.B "Str" sta per stringa, che poi convertiremo nella forma di variabile desiderata
        Categoria categoria=new Categoria(nome,descrizione,immagine);
        CategoriaDAO categoriaDAO=new CategoriaDAO();
        categoriaDAO.doSave(categoria);
        resp.sendRedirect("CategorieServlet");

    }
}

