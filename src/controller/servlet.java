package controller;

import model.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet") // vedi index form action
public class servlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req,resp);



  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String nome = (String) req.getAttribute("nome");
    String cognome = (String) req.getAttribute("cognome");
    String username = (String) req.getAttribute("username");

    Utente utente = new Utente(nome,cognome,username);

    req.setAttribute("utente",utente); //manda questo utente come oggetto al server tramite richiesta (metti utente sul server)


    RequestDispatcher dispatcher = req.getRequestDispatcher("/stampa.jsp"); //Dispatcher prende richiesta da URL,

    dispatcher.forward(req,resp);



  }
}
