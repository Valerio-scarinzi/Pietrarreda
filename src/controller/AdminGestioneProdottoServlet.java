package controller;

import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
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
    String newQuant =(String) req.getParameter("cambiaQuant");
    int quant = Integer.parseInt(newQuant);
    String newPrezzo = (String) req.getParameter("cambiaPrezzo");
    double prezzo = Double.parseDouble(newPrezzo);
    String newDisp = req.getParameter("cambiaDisp");
    int disp = Integer.parseInt(newDisp);

    HttpSession recentSession = req.getSession();
    ArrayList<Prodotto> lista = (ArrayList<Prodotto>) recentSession.getAttribute("listProdotti");
    Prodotto prod = new Prodotto();
    int id= Integer.parseInt(req.getParameter("id"));
    String newElimina = (String) req.getParameter("elimina");


    ProdottoDAO prodottoDAO = new ProdottoDAO();

    if(newElimina == null){
      prodottoDAO.doUpdate(id,newNome,quant,newDesc,prezzo,disp);
    }
    else{prodottoDAO.doDelete(id);}



    // rindirizzare al pannello admin dopo ogni operazione
    RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

}
