package controller;

import model.Utente;
import model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");


        boolean email_bool = false;
            boolean password_bool = false;

        UtenteDAO utenteDAO = new UtenteDAO();
        ArrayList<Utente> listUtente = utenteDAO.doRetrieveAll();

        Utente utente = null ;


        for(int i = 0 ; i<= listUtente.size()-1; i++){

            utente = listUtente.get(i);
            email_bool=email.equals(utente.getEmail());
                if(email_bool==true){System.out.println("email corretta = "+email_bool+" "+utente.getEmail()); }

            password_bool=password.equals(utente.getPassword());
                if(password_bool==true){System.out.println("password corretta"+password_bool+" "+utente.getPassword());}


            if(email_bool != true &&password_bool !=true) {
                System.out.println("Utente non trovato!" + "  " + password_bool + " " + email_bool + " " + utente.getEmail() + " " + utente.getPassword());
            }
        }


        if(email_bool == true &&password_bool ==true){

            HttpSession oldSession = req.getSession();
            if(oldSession != null){
             oldSession.invalidate();

            HttpSession recentSession = req.getSession();
            recentSession.setAttribute("utenteLoggato",utente);

        }
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req,resp);

        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
