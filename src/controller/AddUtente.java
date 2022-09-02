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

@WebServlet("/AddUtente")
public class AddUtente extends HttpServlet { //aggiunta utente al DB

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    UtenteDAO utenteDAO = new UtenteDAO();
    ArrayList<Utente> list = utenteDAO.doRetrieveAll();
    Utente utenti = list.get(1);

    String nome = (String) req.getParameter("nome");
    String cognome = (String) req.getParameter("cognome");
    String username = (String) req.getParameter("username");
    String password = (String) req.getParameter("password");
    String email = (String) req.getParameter("email");
    String newadmin = (String) req.getParameter("admin");
    boolean admin = false;

      if (newadmin!=null) {
        admin = true;
      }


      Utente utente = new Utente(nome, cognome, username, password, email, admin);
      utenteDAO.doSave(utente);


      resp.sendRedirect("UtentiServlet");



  }}
