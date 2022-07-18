package controller;

import model.Utente;
import model.UtenteDAO;

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
        String nome= (String) req.getAttribute("nome");
        String cognome= (String) req.getAttribute("cognome");
        String username= (String) req.getAttribute("username");
        String password= (String) req.getAttribute("password");
        String email= (String) req.getAttribute("email");

        Utente utente=new Utente(nome,cognome,username,password,email);

        UtenteDAO utenteDAO=new UtenteDAO();
        utenteDAO.doSave(utente);


    }








    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
