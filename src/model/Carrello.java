
package model;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class Carrello {
    private int idutente;
    private int idcarrello;
    private int idprodotto;
    private double prezzoTotCar;
    private  HashMap<Integer, ProdottoQuantita> prodotti = new HashMap<>();



    public static class ProdottoQuantita {
        private Prodotto prodotto;
        private int quantita;

        public ProdottoQuantita(Prodotto prodotto, int quantita) {
            this.prodotto = prodotto;
            this.quantita = quantita;
        }
        private ProdottoQuantita() {
        }

        public  String getImgPath_prod(){return  prodotto.getImgPath_prod();}
        public  void setImgPath_prod(String newPath){ prodotto.setImgPath_prod(newPath);}

        public int getQuantita() {
            return quantita;
        }

        public void setQuantita(int quantita) {
            this.quantita = quantita;
        }

        public Prodotto getProdotto() {
            return prodotto;
        }

        public void setProdotto(Prodotto prodotto) {
            this.prodotto = prodotto;
        }
    }

    public Carrello() {

    }
//getters e setters della classe carrello
    public Double getPrezzoTotCar() {
        return prezzoTotCar;
    }

    public void setPrezzoTotCar(Double prezzoTotCar) {
        this.prezzoTotCar = prezzoTotCar;
    }

    public int getIdutente() {
        return idutente;
    }

    public void setIdutente(int idutente) {
        this.idutente = idutente;
    }

    public int getIdcarrello() {
        return idcarrello;
    }

    public void setIdcarrello(int idcarrello) {
        this.idcarrello = idcarrello;
    }

    public int getIdprodotto() {
        return idprodotto;
    }

    public void setIdprodotto(int idprodotto) {
        this.idprodotto = idprodotto;
    }






    //Metodi carrello
    public void addProdotto(Prodotto prod,int quant){// aggiungiamo un prodotto al carrello in quantita' >=1

        if (prodotti.containsKey(prod.getIdprod())) { //se tra la lista di prodotti c'è il prodotto con  la key  allora->
            /*prodotti.get(prod.getIdprod()).setQuantita( prodotti.get(prod.getIdprod()).getQuantita()+quant);
            prodotti.get(prod.getIdprod()).getPrezzoTotProd();*/
            this.prezzoTotCar += (prod.getPrezzo() * quant);}
    else {
            prodotti.put((prod.getIdprod()),new ProdottoQuantita(prod,quant));
            this.prezzoTotCar+=(prod.getPrezzo()*quant);
            //prodotti.get(prod.getIdprod()).getPrezzoTotProd();
        }

    }

    public void removeAll(ProdottoQuantita prodottoQuantita) {
        if ( prodotti.containsValue(prodottoQuantita)) {
            prodotti.remove(prodottoQuantita.getProdotto().getIdprod());

           // this.prezzoTotCar = 0.0;
        }
    }

    public void removeProd (Prodotto prod,int quant) {
        //se la quantita del prod e maggiore di 0 e maggiore della quantita da eliminare
        if (prodotti.get((prod.getIdprod())).getQuantita() >= 0 || prodotti.get((prod.getIdprod())).getQuantita() >= quant) {
            this.prezzoTotCar -= (prod.getPrezzo() * quant);
            if (prodotti.get((prod.getIdprod())).getQuantita()==0)
                prodotti.remove((prod.getIdprod()));
        }
        else {
            int adjust=prodotti.get((prod.getIdprod())).getQuantita()+quant;
            this.prezzoTotCar -=(prod.getPrezzo() *adjust);
            prodotti.get((prod.getIdprod())).setQuantita(0);
            if (prodotti.get((prod.getIdprod())).getQuantita()==0)
                prodotti.remove((prod.getIdprod()));
        }





    }

    public void setProdotti(HashMap<Integer,ProdottoQuantita> link){
        prodotti=link;
    }

    public ProdottoQuantita getProdQuant(int idprod) {
        return prodotti.get(idprod);
    }

    public int getSize(){
        return prodotti.size();
    }

    @Override
    public String toString() {
        return "Carrello{" +
                "idutente=" + idutente +
                ", idcarrello=" + idcarrello +
                ", idprodotto=" + idprodotto +
                ", prezzotot=" + prezzoTotCar +
                ", prodotti=" + prodotti +
                '}';
    }

    public Collection<Carrello.ProdottoQuantita> getProdotti(){
        return prodotti.values();
    }

    public Collection<Carrello.ProdottoQuantita> getProds(){
        return prodotti.values();
    }
}


