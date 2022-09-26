package controller;

import model.Ordine;
import model.OrdineDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GestioneOrdini")
public class AdminOrdineUsrServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    OrdineDAO ordineDAO = new OrdineDAO();
    ArrayList<Ordine> ordineArrayList = null;
    String ids= req.getParameter("id");
    if(ids != null ){
    int id = Integer.parseInt(ids);
      ordineArrayList = ordineDAO.getAllOrdersByUsr(id);}

    HttpSession session = req.getSession();
    if(ordineArrayList != null) {
      session.setAttribute("listaOrdiniUsrAdmin", ordineArrayList);
    }

    System.out.println(ordineArrayList);

    RequestDispatcher dispatcher = req.getRequestDispatcher("gestioneOrdine.jsp");
    dispatcher.forward(req, resp);





  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
