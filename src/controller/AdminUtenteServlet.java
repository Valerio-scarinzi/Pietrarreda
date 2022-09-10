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

@WebServlet("/UtentiServlet")
public class AdminUtenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Utente> listutenti = new ArrayList<Utente>();
        UtenteDAO utenteDAO = new UtenteDAO();
        listutenti     =    utenteDAO.doRetrieveAll();
        HttpSession recentSession = req.getSession();
        recentSession.setAttribute("listUtenti", listutenti );

        RequestDispatcher dispatcher = req.getRequestDispatcher("gestioneUtente.jsp");
        dispatcher.forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}


