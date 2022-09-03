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

@WebServlet("/Registrazione")
public class RegistrazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = (String) req.getParameter("nome");
        String cognome= (String) req.getParameter("cognome");
        String username= (String) req.getParameter("username");
        String password= (String) req.getParameter("password");
        String email= (String) req.getParameter("email");

        Utente utente=new Utente(nome,cognome,username,password,email);
        utente.setPassword(password);

        utente.toString();

        UtenteDAO utenteDAO=new UtenteDAO();
        utente.setAdmin(false);
        utenteDAO.doSave(utente);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req,resp);


    }









    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
