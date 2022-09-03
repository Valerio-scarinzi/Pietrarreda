package controller;

import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@WebServlet("/AddProdotto")//aggiunta prodotto al DB
public class AddProdotto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //prendo i parametri dati in input dal form
        String nome = (String) req.getParameter("nome");
        String descrizione= (String) req.getParameter("descrizione");
        String Strprezzo= (String) req.getParameter("prezzo"); //N.B "Str" sta per stringa, che poi convertiremo nella forma di variabile desiderata
        double prezzo=Double.parseDouble(Strprezzo); //Convertiamo
        String  Strquantita= (String) req.getParameter("quantita");//N.B "Str" sta per stringa, che poi convertiremo nella forma di variabile desiderata
        int quantita=Integer.parseInt(Strquantita); //Convertiamo
        String Strdisponibilita= (String) req.getParameter("disponibilita");//N.B "Str" sta per stringa, che poi convertiremo nella forma di variabile desiderata
        int disponibilita=Integer.parseInt(Strdisponibilita);//Convertiamo
        Prodotto prodotto=new Prodotto(nome,descrizione,quantita,prezzo,disponibilita);

        ProdottoDAO prodottoDAO=new ProdottoDAO();
        prodottoDAO.doSave(prodotto);
        resp.sendRedirect("ProdottoServlet");

    }
}

