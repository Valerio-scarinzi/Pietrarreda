package controller;

import model.Categoria;
import model.Prodotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ShowProdotto")
public class ShowProdottoServlet extends HttpServlet {
    private Prodotto prodotto;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idstr = (String) req.getParameter("id");
        int id = Integer.parseInt(idstr);
        ArrayList<Prodotto> prodotti=(ArrayList<Prodotto>) getServletContext().getAttribute("prodotti");
        for (Prodotto p :prodotti) {
            if(p.getIdprod() == id){
                req.setAttribute("ShowProdotto", p);
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("prodotto.jsp");
        dispatcher.forward(req,resp);
    }
}
