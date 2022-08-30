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
import java.util.ArrayList;

@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Categoria categoria1,categoria2,categoria3;
        ArrayList<Categoria> catList = new ArrayList<Categoria>();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        catList = categoriaDAO.doRetrieveAllCategory();

        categoria1=catList.get(0);req.setAttribute("Categoria1",categoria1);
        categoria2=catList.get(1);req.setAttribute("Categoria2",categoria2);
        categoria3=catList.get(2);req.setAttribute("Categoria3",categoria3);
        RequestDispatcher dispatcher=req.getRequestDispatcher("categoria.jsp");
        dispatcher.forward(req,resp);




    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}