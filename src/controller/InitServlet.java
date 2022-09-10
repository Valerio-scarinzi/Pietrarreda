package controller;

import model.Categoria;
import model.CategoriaDAO;
import model.Prodotto;
import model.ProdottoDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InitServlet",urlPatterns = {"/InitServ"},loadOnStartup = 0)
public class InitServlet extends HttpServlet {
  // inizializza il sito con estraendo tutte le categorie dal DB
  @Override
  public void init() throws ServletException {
    ArrayList<Categoria> categories= new ArrayList<>();
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    categories =  categoriaDAO.doRetrieveAllCategory();
    getServletContext().setAttribute("categorie",categories);

    ArrayList<Prodotto> prodottos= new ArrayList<Prodotto>();
    ProdottoDAO prodottoDAO = new ProdottoDAO();
    prodottos = prodottoDAO.getAllProdotti();
    getServletContext().setAttribute("prodotti",prodottos);



    super.init();
  }
}
