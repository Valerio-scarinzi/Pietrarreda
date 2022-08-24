package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

public class Carrello {
    private int idcarrello, idprodotto, idutente;
    HashMap<Integer, ProdottoQuantità> prod_cart = new HashMap<>();
    private double totalPrice;


    public static class ProdottoQuantità {

        public ProdottoQuantità() {
        }

        public ProdottoQuantità(Prodotto prodotto, int quantita) {
            this.prod = prodotto;
            this.qtyprd = quantita;
        }

        public int getQtyprd() {
            return qtyprd;
        }

        public void setQtyprd(int qtyprd) {
            this.qtyprd = qtyprd;
        }

        private int qtyprd;

        public Prodotto getProd() {
            return prod;
        }

        public void setProd(Prodotto prod) {
            this.prod = prod;
        }

        private Prodotto prod;
    }

    public Carrello() {

    }

    // getters and setters of class Cart's attribute
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIdcarrello() {
        return idcarrello;
    }


    public void setIdcarrello(int idcarrello) {
        this.idcarrello = idcarrello;
    }


    public int getIdprodotto(int id_cliente) {
        return idprodotto;
    }


    public void setIdprodotto(int idprodotto) {
        this.idprodotto = idprodotto;
    }


    public int getIdutente() {
        return idutente;
    }


    public void setIdutente(int idutente) {
        this.idutente = idutente;
    }


// methods of Cart

    public void addProd(Prodotto prod, int qty_add) {
        if (prod_cart.containsKey(prod.getIdprod())) {
            this.totalPrice += (prod.getPrezzo() * qty_add);}
        else {
            this.totalPrice+=(prod.getPrezzo()*qty_add);
            prod_cart.put(prod.getIdprod(),new ProdottoQuantità(prod,qty_add));

        }
    }

    public void removeAll(ProdottoQuantità prodottoQuantita) {
        if (prod_cart.containsValue(prodottoQuantita)) {
            prod_cart.remove(prodottoQuantita.getProd().getIdprod());
            this.totalPrice = 0.0;
        }
    }

    public void removeProd (Prodotto prod,int qty_rmv) {
        if (prod_cart.get(prod.getIdprod()).getQtyprd() >= 0 || prod_cart.get(prod.getIdprod()).getQtyprd() >= qty_rmv) {
            this.totalPrice -= (prod.getPrezzo() * qty_rmv);
            if (prod_cart.get(prod.getIdprod()).getQtyprd()==0)
                prod_cart.remove(prod.getIdprod());
        }
        else {
            int adjust=prod_cart.get(prod.getIdprod()).getQtyprd()+qty_rmv;
            this.totalPrice -=(prod.getPrezzo() *adjust);
            prod_cart.get(prod.getIdprod()).setQtyprd(0);
            if (prod_cart.get(prod.getIdprod()).getQtyprd()==0)
                prod_cart.remove(prod.getIdprod());
        }


    }


    public void setProd_cart(HashMap<Integer,ProdottoQuantità> link) {
        prod_cart=link;
    }
    public ProdottoQuantità getPrdQty(int idprod) {
        return prod_cart.get(idprod);
    }


    public int getSize () {
        return prod_cart.size();
    }


    @Override
    public String toString() {
        return "Carrello [idcarrello=" + idcarrello + ", idprodotto=" + idprodotto + ", idutente=" + idutente
                + ", listaProdotti=" + prod_cart + "prezzototale=" + getSubTotale() + "]";
    }

    public String getSubTotale () {
        Locale locale = new Locale("ITALIAN");
        String pattern = "###.##";

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(totalPrice);
    }
    public Collection<ProdottoQuantità> getProds(){
        return prod_cart.values();
    }

}