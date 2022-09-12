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

@WebServlet("/GestioneUtenteServlet")
public class AdminGestioneUtenteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String newNome = (String) req.getParameter("cambiaNome");
        String newCognome = (String) req.getParameter("cambiaCognome");
        String newUser =(String) req.getParameter("cambiaUsername");
        String newPass =(String) req.getParameter("cambiaPass");
        String newEmail =(String) req.getParameter("cambiaEmail");
        String newadmin =(String) req.getParameter("cambiaAdmin");
        boolean admin = false;

        if (newadmin!=null) {
            admin = true;
        }



        UtenteDAO utenteDAO=new UtenteDAO();

        int id=Integer.parseInt(req.getParameter("id"));






        if(newEmail==null&&newadmin==null){
            utenteDAO.doUpdate(id,newNome,newCognome,newUser,newPass);
            Utente utente=utenteDAO.doRetriveById(id);
            HttpSession recentSession=req.getSession();
            recentSession.setAttribute("utenteLoggato",utente);
            RequestDispatcher dispatcher=req.getRequestDispatcher("pagUtente.jsp");
            dispatcher.forward(req,resp);
        }
        else {
            utenteDAO.doUpdate(id,newNome,newCognome,newUser,newPass,newEmail,admin);
            // rindirizzare al pannello utenti dei prodotti dopo ogni operazione
            resp.sendRedirect("UtentiServlet");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
