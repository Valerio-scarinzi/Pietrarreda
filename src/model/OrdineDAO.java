package model;




import controller.ConPool;
import controller.MyExceptionServlet;

import java.sql.*;
import java.util.GregorianCalendar;

public class OrdineDAO {
  private static final ProdottoDAO prodttoDao = new ProdottoDAO();


  public void doSave(int usr_id, String status, Carrello carrello,String indirizzo) {
    try (Connection con = ConPool.getConnection()) {
      String name_ordine = "Ordine dell'utente con id:" + usr_id;
      GregorianCalendar dataTmp = new GregorianCalendar();
      int giorno = dataTmp.get(GregorianCalendar.DAY_OF_MONTH);
      int mese = dataTmp.get(GregorianCalendar.MONTH);
      int anno = dataTmp.get(GregorianCalendar.YEAR);
      String data = giorno + "/" + mese + "/" + anno;
      PreparedStatement ps = con.prepareStatement("INSERT INTO ordine(Id_usr,name_ordine,tot_price,data_ordine,stato_ordine,indirizzo_sped) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, usr_id);
      ps.setString(6,indirizzo);
      ps.setString(2, name_ordine);
      ps.setString(4, data);
      ps.setString(5, status);
      ps.setDouble(3,carrello.getPrezzotot());
      if (ps.executeUpdate() != 1)
        throw new MyExceptionServlet("errore nel salvataggio del ordine");
      ResultSet rs=ps.getGeneratedKeys();
      rs.next();
      int idord=rs.getInt(1);



      PreparedStatement ps2= con.prepareStatement("INSERT INTO OrderProd(Id_ordine, Id_prod, qty_ord_prod) values (?,?,?)");
      for(Carrello.ProdottoQuantita prd:carrello.getProdotti()){
        int prodDisp =  prd.getProdotto().getDisponibilita();
        int changeProdDisp = prodDisp -=prd.getQuantita();
        System.out.println(prodDisp);
        System.out.println(changeProdDisp);
    //aggiustare img problema in complilazione
        ps2.setInt(1,idord);
        ps2.setInt(2,prd.getProdotto().getIdprod());
        ps2.setInt(3,prd.getQuantita());
        ps2.addBatch();
        prd.getProdotto().setDisponibilita(changeProdDisp);

System.out.println(carrello.getProds());
System.out.println(idord);
        System.out.println("debug img"+ prd.getProdotto().getImgPath_prod());
        prodttoDao.doUpdateCart(prd.getProdotto().getIdprod(),prd.getProdotto().getNome(),prd.getProdotto().getDesc(),prd.getProdotto().getPrezzo(),prd.getProdotto().getDisponibilita());

      }
      ps2.executeBatch();
     CarrelloDAO carrelloDAO = new CarrelloDAO();



    } catch (MyExceptionServlet | SQLException e) {
      e.printStackTrace();
    }
  }



}
