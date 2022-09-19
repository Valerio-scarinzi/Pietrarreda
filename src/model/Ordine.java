package model;

import java.util.ArrayList;

public class Ordine {
  private double prezzoTotale;
  private ArrayList<Carrello.ProdottoQuantita> prodotti;
  private int idOrdine;
  private String nomeOrdine, statusOrdine;
  private int id_usr;
  private String indirizzo;

  public int getId_usr() {
    return id_usr;
  }

  public void setId_usr(int id_usr) {
    this.id_usr = id_usr;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  public String getDataEmissione() {
    return dataEmissione;
  }

  public void setDataEmissione(String dataEmissione) {
    this.dataEmissione = dataEmissione;
  }

  private String dataEmissione;
  public Ordine(){
    prezzoTotale=0;
    prodotti= new ArrayList<>();
    dataEmissione = "";
  }


  public ArrayList<Carrello.ProdottoQuantita> getProdotti() {
    return prodotti;
  }

  public void setProdotti(ArrayList<Carrello.ProdottoQuantita> prodotti) {
    this.prodotti = prodotti;
  }


  public int getIdOrdine(){
    return idOrdine;
  }
  public void setIdOrdine(int idOrdine){
    this.idOrdine=idOrdine;
  }

  public String getNomeOrdine(){
    return nomeOrdine;
  }
  public void setNomeOrdine(String nomeOrdine){
    this.nomeOrdine=nomeOrdine;
  }

  public String getStatusOrdine(){
    return statusOrdine;
  }
  public void setStatusOrdine(String statusOrdine){
    this.statusOrdine=statusOrdine;
  }

  public double getPrezzoTotale() {
    return prezzoTotale;
  }

  public void setPrezzoTotale(double prezzoTotale) {
    this.prezzoTotale = prezzoTotale;
  }


}
