package controller;

import model.*;
import org.json.Cookie;
import org.json.HTTP;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ShowCategoria")
public class ShowCategoriaClient extends HttpServlet {



  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String idstr = (String) req.getParameter("id");
    int id = Integer.parseInt(idstr);

    // gestione prodottoCategoria creo l'array list poi faccio la selzione per l'id della categoria
    ArrayList<ProdottoCategoria> listprodottoCategoria = new ArrayList<ProdottoCategoria>();
    ProdottoCategoriaDAO prodottoCategoriaDAO = new ProdottoCategoriaDAO();
    listprodottoCategoria = prodottoCategoriaDAO.getProdByCatId(id);// prendo tutti gli id dei prodotti legati all id della catgoria scelta dla client
    ArrayList<Prodotto> listprodFromCat = new ArrayList<Prodotto>();
    ProdottoDAO prodottoDAO = new ProdottoDAO();

    for(ProdottoCategoria p :listprodottoCategoria){
      Prodotto prodotto =  prodottoDAO.getProdById(p.getId_prod());
      listprodFromCat.add(prodotto);
    }


    for(Prodotto p :listprodFromCat){
     p.getNome();

    }

    req.setAttribute("ProdottiFromCat",listprodFromCat);// invio gli id dei prodotti per poi prendere i prodotti dal prodotto dao




    /*ArrayList<Categoria> categorie = (ArrayList<Categoria>) getServletContext().getAttribute("categorie");
    for (Categoria c :categorie) {
      if(c.getId() == id){
        req.setAttribute("ShowCategoria", c);
      }
    }*/

    RequestDispatcher dispatcher = req.getRequestDispatcher("categoriaClient.jsp");
    dispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
