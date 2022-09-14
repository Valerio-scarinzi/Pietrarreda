package controller;

import model.Carrello;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Carrello")
public class CarrelloServlet extends HttpServlet {
    private final ProdottoDAO prodottoDAO=new ProdottoDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Carrello carrello=(Carrello) session.getAttribute("carrello");
        if(carrello==null){
            carrello = new Carrello();
            session.setAttribute("carrello",carrello);
        }
        String prodIdStr = req.getParameter("prodId");
        if (prodIdStr != null) {
            int prodId = Integer.parseInt(prodIdStr);
            String addNumStr = req.getParameter("addNum");
            if (addNumStr != null) {
                int addNum = Integer.parseInt(addNumStr);
                Carrello.ProdottoQuantita prodQuant = carrello.get(prodId);
                if (prodQuant != null) {
                    prodQuant.setQuantita(prodQuant.getQuantita() + addNum);
                } else {
                    carrello.put(prodottoDAO.getProdById(prodId), addNum);
                }
            } else {
                String setNumStr = req.getParameter("setNum");
                if (setNumStr != null) {
                    int setNum = Integer.parseInt(setNumStr);
                    if (setNum <= 0) {
                        carrello.remove(prodId);
                    } else {
                        Carrello.ProdottoQuantita prodQuant = carrello.get(prodId);
                        if (prodQuant != null) {
                            prodQuant.setQuantita(setNum);
                        } else {
                            carrello.put(prodottoDAO.getProdById(prodId), setNum);
                        }
                    }
                }
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("carrello.jsp");
        requestDispatcher.forward(req,resp);
    }



}
