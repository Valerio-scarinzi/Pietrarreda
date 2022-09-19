package controller;

import model.Carrello;
import model.OrdineDAO;
import model.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
      Carrello cart = (Carrello) req.getSession().getAttribute("carrello");


      if(!conferma.isEmpty()){
        if(cart.getProds().isEmpty())
          throw new MyExceptionServlet("Carrello vuoto impossibile completare l'ordine");
        OrdineDAO ordineDAO=new OrdineDAO();
        //aggiungere la riduzione della quantita dal prodotto
        ordineDAO.doSave(usr.getId(),"Ordine in lavorazione",cart,indirizzo);
        req.setAttribute("notifica","Ordine creato con successo");
        RequestDispatcher dispatcher=req.getRequestDispatcher("ordineSuccesso.jsp");
        dispatcher.forward(req,resp);

      }
      else
        throw new MyExceptionServlet("Errore nella ordinazione");
    }



  }

