package controller;

import model.Ordine;
import model.OrdineDAO;
import model.Utente;
import model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //prendi username email e password da input e salva
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession oldSession = req.getSession();
        if (oldSession != null) {
            oldSession.invalidate();}
        HttpSession recentSession = req.getSession();
        UtenteDAO utenteDAO = new UtenteDAO();
           Utente utente = utenteDAO.doRetrieveByUsernameEmailPassword(email, username, password);// controlla del DB se esiste un utente con questi parametri.Se non esiste "utente"=null
            if(utente==null){ //utente non trovato nel db
                throw new MyExceptionServlet("Errore di login!"+"\n"+"Dati errati");
            }

           if (utente!=null) {

             OrdineDAO ordineDAO =new OrdineDAO();
             ArrayList<Ordine> ordiniByuUer = ordineDAO.getAllOrdersByUsr(utente.getId());
             recentSession.setAttribute("listaOrdiniUsr",ordiniByuUer);




                   recentSession.setAttribute("utenteLoggato", utente);


               if (utente.isAdmin() == false) {
                   RequestDispatcher dispatcher = req.getRequestDispatcher("stampa.jsp");
                   dispatcher.forward(req, resp);
               } else {
                   recentSession.setAttribute("AdminLoggeto",utente);
                   RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
                   dispatcher.forward(req, resp);
               }


           }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
