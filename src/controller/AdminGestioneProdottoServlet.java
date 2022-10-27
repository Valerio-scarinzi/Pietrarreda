package controller;

import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GestioneProdottoServlet")
public class AdminGestioneProdottoServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    String newNome = (String) req.getParameter("cambiaNome");
    String newDesc = (String) req.getParameter("cambiaDesc");
    String newimg =(String) req.getParameter("cambiaImg");

    String newPrezzo = (String) req.getParameter("cambiaPrezzo");
    double prezzo = Double.parseDouble(newPrezzo);
    String newDisp = req.getParameter("cambiaDisp");
    int disp = Integer.parseInt(newDisp);

    HttpSession recentSession = req.getSession();
    ArrayList<Prodotto> lista = (ArrayList<Prodotto>) recentSession.getAttribute("listProdotti");
    Prodotto prod = new Prodotto();
    ProdottoDAO prodottoDAO = new ProdottoDAO();
    int id=Integer.parseInt(req.getParameter("id"));
      prodottoDAO.doUpdate(id,newNome,newimg,newDesc,prezzo,disp);
    // rindirizzare al pannello admin dei prodotti dopo ogni operazione
    resp.sendRedirect("ProdottoServlet");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

}
