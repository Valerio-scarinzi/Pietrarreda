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


import java.util.ArrayList;

@WebServlet("/RicServ")
public class RicercaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name_prod= request.getParameter("search");//prende l input dalla barra di ricerca dell header
        ProdottoDAO prod= new ProdottoDAO();
        ArrayList<Prodotto> prodotti= prod.getProdByName(name_prod); //cerca tramite il DAO i prodotti nel database
        request.setAttribute("search",prodotti);
        RequestDispatcher dispatcher=request.getRequestDispatcher("showSearchPro.jsp");
        dispatcher.forward(request,response);
    }
}