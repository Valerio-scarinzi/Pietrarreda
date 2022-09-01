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
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AdminCategoria")
public class AdminCetegoriaServlet  extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    ArrayList<Categoria> listCategorie = new ArrayList<Categoria>();
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    listCategorie = categoriaDAO.doRetrieveAllCategory();
    HttpSession recentSession = req.getSession();
    recentSession.setAttribute("listCategorie", listCategorie);

    RequestDispatcher dispatcher = req.getRequestDispatcher("gestioneCategoria.jsp");
    dispatcher.forward(req,resp);



  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}

