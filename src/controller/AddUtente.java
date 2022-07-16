package controller;

import model.Utente;
import model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddServlet")
public class AddUtente extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    /*String nome = (String) req.getAttribute("nome");
    String cognome = (String) req.getAttribute("cognome");
    String username = (String) req.getAttribute("username");

    Utente utente = new Utente(nome,cognome,username);*/

    UtenteDAO utenteDAO = new UtenteDAO();
    ArrayList<Utente> list=utenteDAO.doRetrieveAll();
    Utente utente = list.get(1);

    String nome = utente.getNome();
    String cognome = utente.getCognome();
    String username = utente.getUsername();

    req.setAttribute("nome",nome);
    req.setAttribute("cognome",cognome);
    req.setAttribute("username",username);


    RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/result/stampa.jsp");

    dispatcher.forward(req,resp);



  }
}
