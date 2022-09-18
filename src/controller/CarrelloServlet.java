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

@WebServlet("/Carrello")
public class CarrelloServlet extends HttpServlet {
    private final ProdottoDAO prodottoDAO = new ProdottoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession();
        Utente utenteLog = (Utente) session.getAttribute("utenteLoggato");
        Carrello carrello;
        CarrelloDAO carrelloDao=(CarrelloDAO)new CarrelloDAO();

        if(utenteLog!=null) {//recupero carrello dell utente
            carrello = carrelloDao.getCarrelloByUser(utenteLog.getId());
            if (carrello == null) { // se l'utente loggato non ha mai messo nulla devo creare il carrello.
                carrello = new Carrello();
                synchronized (session) {
                    session.setAttribute("carrello", carrello);
                }
            }
        }else
                throw new MyExceptionServlet("Utente non loggato impossibile accedere al carrello");// valutare eccezione o gestione utente non loggato


        String addProd= req.getParameter("addNum");
        if(addProd!=null) {                        // utente vuole aggiungere prodotto al carrello
            String idprod=req.getParameter("prodId");
            int id;
            try {
                id =Integer.parseInt(idprod);
            }
            catch (NumberFormatException e) {
                throw new MyExceptionServlet("formato id sbagliato");
            }
            String numAggiunte= req.getParameter("addNum");
            int numProd;
            try {
                numProd=Integer.parseInt(numAggiunte);
            }
            catch (NumberFormatException e ){
                throw new MyExceptionServlet("formato numero prodotti da aggiungere errato");
            }

            if(!idprod.isEmpty() && !numAggiunte.isEmpty()){
                Carrello.ProdottoQuantita prodottoQuantita=carrello.getProdQuant(id);
                if(prodottoQuantita!=null) {
                    prodottoQuantita.setQuantita(prodottoQuantita.getQuantita()+numProd);
                    carrello.addProdotto(prodottoQuantita.getProdotto(),numProd); // fa aggiornamento dell ProdQty dentro addProd
                    CarrelloDAO.setQuantita(carrello,prodottoQuantita.getQuantita(),id);
                    CarrelloDAO.setPrezzo(carrello,carrello.getPrezzotot(),id);
                    session.setAttribute("carrello", carrello);
                    //valutare aggiornamento tabella Product se non lo fa in automatico SQL tramite le chiavi referenziali
                }
                else{
                    ProdottoDAO prodottoDAO=new ProdottoDAO();
                    Prodotto prodotto=prodottoDAO.getProdById(id);
                    carrello.addProdotto(prodotto,numProd);
                    model.CarrelloDAO.doSave(utenteLog.getId(),id,carrello.getProdQuant(id).getQuantita(),carrello);
                    session.setAttribute("carrello", carrello);
                }
            }

        }

/*
        String removeProd=req.getParameter("rimuovi-prod");
        if(removeProd!=null){
            String idprod=req.getParameter("prodId");
            int id;
            try {
                id=Integer.parseInt(idprod);
            }
            catch (NumberFormatException e){
                throw new MyExceptionServlet("Formato id prodotto errato");

            }
            String numRemove= request.getParameter("numero-rimossi");
            int removeNum;
            try {
                removeNum=Integer.parseInt(numRemove);
            }
            catch (NumberFormatException e){
                throw new MyExceptionServlet("Formato rimozione errato");
            }
            if(!idprod.isEmpty()&& !numRemove.isEmpty()){
                Carrello.ProdottoQuantità prodottoQuantita=car.getPrdQty(id);
                if(prodottoQuantita!=null){
                    prodottoQuantita.setQtyprd(prodottoQuantita.getQtyprd()-removeNum);
                    car.removeProd(prodottoQuantita.getProd(),removeNum); // fa aggiormaneto dentro remove prod
                    CarrelloDao.setQuantita(car,prodottoQuantita.getQtyprd(),id);
                    CarrelloDao.setPrezzo(car, car.getTotalPrice(),id);
                    if(prodottoQuantita.getQtyprd()==0)
                        CarrelloDao.deleteProdotto(car.getIdutente(),id);

                }

            }
        }

        String rmvall=request.getParameter("pulisci-carrello");
        if (rmvall!=null){
            Collection<Carrello.ProdottoQuantità> lista_prod=car.getProds();
            ArrayList<Carrello.ProdottoQuantità> remove_list=new ArrayList<>(lista_prod);
            Model.CarrelloDao.doDeleteAll(car);

            for(int i=0; i<remove_list.size();i++){
                car.removeAll(remove_list.get(i));
            }
            session.setAttribute("carrello",car);

        }

        // String show=request.getParameter("showCart"); // quando viene cliccato dalla navbar per rispiarmiare ulteriore servlet.
        // if(show!=null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/carrello.jsp");
        dispatcher.include(request, response);
        // }
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/carrello.jsp");
        dispatcher.include(request, response);*/


    }

}

           /* String prodIdStr = req.getParameter("prodId");
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
                    carrelloDao.doSave(utenteLog.getId(),prodId,carrello.getPrezzotot(),addNum);
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
                            carrelloDao.doSave(utenteLog.getId(),prodId,carrello.getPrezzotot(),setNum);
                        }
                    }
                }
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("carrello.jsp");
        requestDispatcher.forward(req,resp);
    }


    }*/

