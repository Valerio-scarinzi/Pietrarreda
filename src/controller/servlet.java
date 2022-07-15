package controller;

import model.Utente;
import model.UtenteDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class servlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req,resp);



  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String nome = (String) req.getAttribute("nome");
    String cognome = (String) req.getAttribute("cognome");
    String username = (String) req.getAttribute("username");
    String passsword = (String) req.getAttribute("password");
    String email = (String) req.getAttribute("email");




    Utente utente = new Utente(nome,cognome,username,passsword,email);

    UtenteDao utenteDao = new UtenteDao();

    utenteDao.doSave(utente);





    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/results/login.jsp/");

    dispatcher.forward(req,resp);



  }
}
