package controller;

import model.Categoria;
import model.CategoriaDAO;
import model.Prodotto;
import model.ProdottoDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

@WebServlet(name = "InitServlet",urlPatterns = {"/InitServ"},loadOnStartup = 0)
public class InitServlet extends HttpServlet {
  // inizializza il sito con estraendo tutte le categorie dal DB
  @Override
  public void init() throws ServletException {
    ArrayList<Categoria> categories= new ArrayList<>();
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    categories =  categoriaDAO.doRetrieveAllCategory();
    getServletContext().setAttribute("categorie",categories);




    System.out.println("ciao");
    System.out.println("ciao");

    String c = "ciao";
    System.out.println(c);

    super.init();
  }
}
