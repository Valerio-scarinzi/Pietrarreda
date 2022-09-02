package controller;



import model.Utente;
import model.UtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/DeleteUtente")//rimozione utente dal DB
public class AdminEliminaUtenteServlet extends HttpServlet {
    private Utente utente;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id=Integer.parseInt(req.getParameter("id"));
        UtenteDAO utenteDAO=new UtenteDAO();
        utenteDAO.doDelete(id);

        resp.sendRedirect("UtentiServlet"); //rindirizzare al pannello admin degli utenti dopo ogni operazione
    }
}