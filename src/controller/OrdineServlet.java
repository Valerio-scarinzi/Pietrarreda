package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Ordine")
public class OrdineServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  doGet(req, resp);
}

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String indirizzo= req.getParameter("IndirizzoSpedizione");
     String conferma= req.getParameter("conferma");
      Utente usr= (Utente) req.getSession().getAttribute("utenteLoggato");
    HttpSession session  = req.getSession();
      Carrello cart = (Carrello) session.getAttribute("carrello");


      if(!conferma.isEmpty()){
        if(cart.getProds().isEmpty())
          throw new MyExceptionServlet("Carrello vuoto impossibile completare l'ordine");
        OrdineDAO ordineDAO=new OrdineDAO();
        int n=0;
        //aggiungere la riduzione della quantita dal prodotto esvuotare il carrello
        ordineDAO.doSave(usr.getId(),"Ordine in lavorazione",cart,indirizzo);
        req.setAttribute("notifica","Ordine creato con successo");
        //cart.getProdQuant().getQuantita();
        ArrayList<Ordine> ordiniByuUer = ordineDAO.getAllOrdersByUsr(usr.getId());
        Ordine ordineAttuale = null;
        for (Ordine o : ordiniByuUer){
          if(n<=o.getIdOrdine()){
           n=o.getIdOrdine();
          ordineAttuale=o;}
        }
        session.setAttribute("odrineAttuale",ordineAttuale);
        session.setAttribute("listaOrdiniUsr",ordiniByuUer);
        model.CarrelloDAO.doDeleteAll(cart);


        RequestDispatcher dispatcher=req.getRequestDispatcher("ordineSuccesso.jsp");
        dispatcher.forward(req,resp);

      }
      else
        throw new MyExceptionServlet("Errore nella ordinazione");
    }






  }

