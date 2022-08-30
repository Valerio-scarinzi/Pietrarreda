package model;

public class Prodotto {
    private int idprod; //id del prodotto
    private String nome; //nome del prodotto
    private  int quantprodotto; //quantita' del prodotto
    private String desc; //descrizione del prodotto
    private double prezzo; // prezzo del prodotto
    private int disponibilita; //disponibilità del prodotto (non ho capito a che serve)

    //inizio costruttori
    public Prodotto(String name){
        nome=name;
    }

    public Prodotto(String name, int qty) {
        this.quantprodotto = qty;
        this.nome = name;
    }
    public Prodotto(String name, int qty, int id) {
        this.idprod = id;
        this.quantprodotto = qty;
        this.nome = name;
    }

    public Prodotto() {

    }

    //inizio getter and setter
    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
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

    public Prodotto(int id, String nome,int quantprodotto, String desc, double price,int disp) {
        this.idprod = id;
        this.nome = nome;
        this.quantprodotto = quantprodotto;
        this.desc = desc;
        this.prezzo = price;
        this.disponibilita=disp;

    }

}
