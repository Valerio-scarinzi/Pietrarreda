package controller;

import model.OrdineDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOrdine") //rimozione ordine dal DB
public class AdminEliminaOrdineUsr extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    OrdineDAO ordineDAO = new OrdineDAO(); //crea DAO
    int id=Integer.parseInt(req.getParameter("idDelete")); //prendi id dell'ordine passato dalla request
    ordineDAO.doDelete(id); //DAO usa do delete by id dell'ordine
    resp.sendRedirect("UtentiServlet");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
