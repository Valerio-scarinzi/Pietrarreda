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
import java.util.List;

@WebServlet("/RicServ")
public class RicercaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name_prod= request.getParameter("search");
        ProdottoDAO prod= new ProdottoDAO();
    //   List<Prodotto> products= prod.SearchProdByName(name_prod);
      // request.setAttribute("showprodsearch",products);
        RequestDispatcher dispatcher=request.getRequestDispatcher("");
        dispatcher.forward(request,response);
    }
}
