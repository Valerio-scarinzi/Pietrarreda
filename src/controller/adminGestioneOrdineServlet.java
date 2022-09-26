package controller;

import model.OrdineDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminGestioneOrdine")
public class adminGestioneOrdineServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=0;
    String modificaIndirizzo = req.getParameter("modificaIndirizzo");
    String idOrdine = req.getParameter("id");

    if(idOrdine!=null){ id = Integer.parseInt(idOrdine);}
    String option = req.getParameter("option0");


    OrdineDAO ordineDAO = new OrdineDAO();
    ordineDAO.doUpdateStatoIndirizzo(id,option,modificaIndirizzo);



    resp.sendRedirect("GestioneOrdini");

  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
