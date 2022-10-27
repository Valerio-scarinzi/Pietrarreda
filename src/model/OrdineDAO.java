package model;




import controller.ConPool;
import controller.MyExceptionServlet;

import java.sql.*;
import java.util.ArrayList;
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
      ps.setDouble(3,carrello.getPrezzoTotCar());
      if (ps.executeUpdate() != 1)
        throw new MyExceptionServlet("errore nel salvataggio del ordine");
      ResultSet rs=ps.getGeneratedKeys();
      rs.next();
      int idord=rs.getInt(1);



      PreparedStatement ps2= con.prepareStatement("INSERT INTO OrderProd(Id_order, Id_prod, qty_ord_prod) values (?,?,?)");
      for(Carrello.ProdottoQuantita prd:carrello.getProdotti()){
        int prodDisp =  prd.getProdotto().getDisponibilita();

        if(prodDisp == 0){prd.setProdotto(prodttoDao.getProdById(prd.getProdotto().getIdprod())); prodDisp = prd.getProdotto().getDisponibilita();}
        int changeProdDisp = prodDisp -prd.getQuantita();
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


  private static ArrayList<Carrello.ProdottoQuantita> getProdottiOrd(Connection con, int idordine) throws SQLException {
    PreparedStatement ps=con.prepareStatement("SELECT qty_ord_prod,Id_prodotto, nome_prod,descrizione_prod,costo_prodotto,disponibilita_prod,imgPath_prod FROM ordine,orderprod,prodotto where Id_prodotto=Id_prod and  Id_order=Id_ordine and Id_ordine=?;");
    ps.setInt(1,idordine);
    ResultSet rs= ps.executeQuery();
    ArrayList<Carrello.ProdottoQuantita> list_prdqty=new ArrayList<>();
    while (rs.next()){
      Prodotto prodotto=new Prodotto();
      prodotto.setIdprod((rs.getInt(2)));
      prodotto.setNome(rs.getString(3));
      prodotto.setDesc(rs.getString(4));
      prodotto.setPrezzo(rs.getDouble(5));
      prodotto.setDisponibilita(rs.getInt(6));
      prodotto.setImgPath_prod(rs.getString(7));

      Carrello.ProdottoQuantita prdqty= new Carrello.ProdottoQuantita(prodotto,rs.getInt(1));
      list_prdqty.add(prdqty);
    }
    return list_prdqty;
  }





  public ArrayList<Ordine> getAllOrdersByUsr(int id_usr) {

    ArrayList<Ordine> list_ord = new ArrayList<>();
    PreparedStatement ps = null;
    try (Connection connection = ConPool.getConnection()) {
      ps = connection.prepareStatement("SELECT name_ordine,data_ordine,Id_ordine,stato_ordine,Id_usr,indirizzo_sped,tot_price from ordine,Utente where Id_user=Id_usr and Id_user=?;");
      ps.setInt(1,id_usr);
      ResultSet rs= ps.executeQuery();
      while (rs.next()){
        Ordine ordine= new Ordine();
        ordine.setIdOrdine(rs.getInt(3));
        ordine.setNomeOrdine(rs.getString(1));
        ordine.setDataEmissione(rs.getString(2));
        ordine.setId_usr(rs.getInt(5));
        ordine.setIndirizzo(rs.getString(6));
        ordine.setPrezzoTotale(rs.getDouble(7));
        ordine.setProdotti(OrdineDAO.getProdottiOrd(connection,ordine.getIdOrdine())); //funzione privata dato che join con 4 tabella era scomoda che gestisce il recupero dal DB dei prodotti
        list_ord.add(ordine);
      }
    } catch (SQLException e) {
      throw  new RuntimeException(e);
    }
    return list_ord;
  }


  public ArrayList<Ordine> getAllOrdini() {
    try (Connection con = ConPool.getConnection()) {
      ArrayList<Ordine> ordines = new ArrayList<Ordine>();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM ordine;");
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        Ordine ordine= new Ordine();
        ordine.setIdOrdine(rs.getInt(3));
        ordine.setNomeOrdine(rs.getString(1));
        ordine.setDataEmissione(rs.getString(2));
        ordine.setId_usr(rs.getInt(5));
        ordine.setIndirizzo(rs.getString(6));
        ordine.setPrezzoTotale(rs.getDouble(7));
        ordine.setProdotti(OrdineDAO.getProdottiOrd(con,ordine.getIdOrdine())); //funzione privata dato che join con 4 tabella era scomoda che gestisce il recupero dal DB dei prodotti

        ordines.add(ordine);
      }
      con.close();
      return ordines;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doUpdateStatoIndirizzo(int id,String stato,String indirizzo){
    try(Connection connection=ConPool.getConnection()) {
      PreparedStatement ps=connection.prepareStatement("UPDATE ordine set  stato_ordine=?,indirizzo_sped=? where Id_ordine=?;");
      ps.setString(1,stato);
      ps.setString(2,indirizzo);
      ps.setDouble(3,id);



      ps.executeUpdate();
    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }




  }


  public void doDelete(int idOrdine) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps1 = con.prepareStatement("DELETE  FROM orderprod WHERE id_order = ?;");
      ps1.setInt(1, idOrdine);
      ps1.executeUpdate();/*
      if (ps1.executeUpdate() <=1) {
        throw new RuntimeException("errrrrrrrore nella cancellazione");
      }*/
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE   FROM ordine WHERE Id_ordine = ?;");
      ps.setInt(1, idOrdine);
      ps.executeUpdate();
      /*
      if (ps.executeUpdate() <= 1) {
        throw new RuntimeException("errore nella cancellazione");
      }*/
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


}
