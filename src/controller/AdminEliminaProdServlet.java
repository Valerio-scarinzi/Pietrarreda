package controller;


import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/DeleteProdotto") //rimozione prodotto dal DB
public class AdminEliminaProdServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    int id=Integer.parseInt(req.getParameter("id")); //prendi l id del prodotto passato dalla request
    ProdottoDAO prodottoDAO=new ProdottoDAO(); //crea DAO
    prodottoDAO.doDelete(id); //DAO usa do delete con id del prodotto
    resp.sendRedirect("ProdottoServlet"); // rindirizzare al pannello admin dei prodotti dopo ogni operazione
  }
}