package controller;


import com.mysql.cj.Session;
import model.Categoria;
import model.CategoriaDAO;
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

@WebServlet("/ProdottoServlet")
public class AdminProdottoServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    ArrayList<Prodotto> listProdotti = new ArrayList<Prodotto>();
    ProdottoDAO prodottoDAO = new ProdottoDAO();
    listProdotti = prodottoDAO.getAllProdotti();
    HttpSession recentSession = req.getSession();
    recentSession.setAttribute("listProdotti", listProdotti);

    RequestDispatcher dispatcher = req.getRequestDispatcher("gestioneProdotto.jsp");
        dispatcher.forward(req,resp);



  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
