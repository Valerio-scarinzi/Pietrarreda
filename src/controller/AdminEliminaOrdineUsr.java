package controller;

import model.OrdineDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOrdine")
public class AdminEliminaOrdineUsr extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    OrdineDAO ordineDAO = new OrdineDAO();
    String idDelete= req.getParameter("idDelete");

    if(idDelete==null){
      int id = Integer.parseInt(idDelete);
      ordineDAO.doDelete(id);
    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
