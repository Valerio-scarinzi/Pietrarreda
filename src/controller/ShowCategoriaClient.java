package controller;

import model.Categoria;
import model.CategoriaDAO;
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


    ArrayList<Categoria> categorie = (ArrayList<Categoria>) getServletContext().getAttribute("categorie");
    for (Categoria c :categorie) {
      if(c.getId() == id){
        req.setAttribute("ShowCategoria", c);

      }

    }


    RequestDispatcher dispatcher = req.getRequestDispatcher("categoriaClient.jsp");
    dispatcher.forward(req,resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
