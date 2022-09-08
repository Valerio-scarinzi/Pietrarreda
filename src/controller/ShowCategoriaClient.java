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
import java.io.IOException;

@WebServlet("/ShowCategoria")
public class ShowCategoriaClient extends HttpServlet {

  Cookie cookie = new Cookie();

  public Cookie getCookie() {

    return cookie;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String idstr = (String) req.getParameter("idCat");
    int id = Integer.parseInt(idstr);

    CategoriaDAO categoriaDAO = new CategoriaDAO();
 //   Categoria categoria = categoriaDAO.doRetrieveById(id);

   // req.setAttribute("categoria",categoria);


    RequestDispatcher dispatcher = req.getRequestDispatcher("showCategoriaClient.jsp");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
