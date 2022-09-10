package controller;


import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/DeleteProdotto")
public class AdminEliminaProdServlet extends HttpServlet {
  private Prodotto prodotto; //rimozione prodotto dal DB
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    int id=Integer.parseInt(req.getParameter("id"));
    ProdottoDAO prodottoDAO=new ProdottoDAO();
    prodottoDAO.doDelete(id);
    resp.sendRedirect("ProdottoServlet"); // rindirizzare al pannello admin dei prodotti dopo ogni operazione
  }
}