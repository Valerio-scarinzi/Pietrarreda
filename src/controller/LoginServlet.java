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

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");



        UtenteDAO utenteDAO = new UtenteDAO();

        Utente utente  = utenteDAO.doRetrieveByUsernamePassword(username, password);
        System.out.println(utente);
        boolean user_bool = username.equals(utente.getUsername());
        boolean password_bool = password.equals(utente.getPassword());
        boolean admin_bool = utente.isAdmin();

        


        //Fai un altro if che controlla se l utente è admin (booleano),se admin -> indirizzare a jsp admin (da creare)
        if(user_bool==true&&password_bool==true){

            HttpSession oldSession = req.getSession();
            if(oldSession != null){
             oldSession.invalidate();

            HttpSession recentSession = req.getSession();
            recentSession.setAttribute("utenteLoggato",utente);

        }
            if(admin_bool==false){
            RequestDispatcher dispatcher = req.getRequestDispatcher("stampa.jsp");
            dispatcher.forward(req,resp);}
            else{
                RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
                dispatcher.forward(req,resp);
            }




        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
