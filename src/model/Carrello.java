
package model;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class Carrello {
    private int idutente;
    private int idcarrello;
    private int idprodotto;
    private double prezzotot;
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

        public double getPrezzoTot() {
            return quantita * prodotto.getPrezzo();
        }

    }

    public Carrello() {

    }

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

    public double getPrezzotot() {

        /*for (int i=0;i<=prodotti.size();i++){
            int e = pr
           setPrezzotot(prezzotot += e);

        }*/

        return prezzotot;
    }

    public void setPrezzotot(double prezzotot) {
        this.prezzotot = prezzotot;
    }


    //Metodi carrello
    public void addProdotto(Prodotto prod,int quant){
        if(prodotti.containsKey(prod.getIdprod())){
            this.prezzotot=(prod.getPrezzo()*quant);
            this.prezzoTotCar+=this.prezzotot;
        }

        else {
            this.prezzotot+=(prod.getPrezzo()*quant);
            prodotti.put(prod.getIdprod(),new ProdottoQuantita(prod,quant));
        }
    }

    public void removeAll(ProdottoQuantita prodottoQuantita) {
        if ( prodotti.containsValue(prodottoQuantita)) {
            prodotti.remove(prodottoQuantita.getProdotto().getIdprod());
            this.prezzotot = 0.0;
        }
    }

    public void removeProd (Prodotto prod,int quant) {
        if (prodotti.get(prod.getIdprod()).getQuantita() >= 0 || prodotti.get(prod.getIdprod()).getQuantita() >= quant) {
            this.prezzotot -= (prod.getPrezzo() * quant);
            if (prodotti.get(prod.getIdprod()).getQuantita()==0)
                prodotti.remove(prod.getIdprod());
        }
        else {
            int adjust=prodotti.get(prod.getIdprod()).getQuantita()+quant;
            this.prezzotot -=(prod.getPrezzo() *adjust);
            prodotti.get(prod.getIdprod()).setQuantita(0);
            if (prodotti.get(prod.getIdprod()).getQuantita()==0)
                prodotti.remove(prod.getIdprod());
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
                ", prezzotot=" + prezzotot +
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


