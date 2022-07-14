package model;

public class Prodotto {
    private String idprod; //id del prodotto
    private String nome; //nome del prodotto
    private  int quantprodotto; //quantita' del prodotto
    private String desc; //descrizione del prodotto
    private double prezzo; // prezzo del prodotto
    private int disponibilita; //disponibilità del prodotto (non ho capito a che serve) 

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public Prodotto(String name){
        nome=name;
    }

    public Prodotto(String name, int qty) {
        quantprodotto = qty;
        nome = name;
    }
    public Prodotto(String name, int qty, int id) {
        idprod = Integer.toString(id);
        quantprodotto = qty;
        nome = name;
    }

    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantprodotto() {
        return quantprodotto;
    }

    public void setQuantprodotto(int quantprodotto) {
        this.quantprodotto = quantprodotto;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Prodotto(int id, String nome, String desc, double price) {
        this.idprod = Integer.toString(id);
        this.nome = nome;
        this.desc = desc;
        this.prezzo = price;

    }

}
