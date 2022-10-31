package model;

public class Prodotto {
    private int idprod; //id del prodotto
    private String nome; //nome del prodotto

    private String desc; //descrizione del prodotto
    private double prezzo; // prezzo del prodotto
    private int disponibilita; //disponibilità del prodotto
    private String imgPath_prod; // path dell immagine
    //inizio costruttori
    public Prodotto(String name){
        this.nome=name;
    }

    public Prodotto(String name, int disponibilita, int id) {
        this.idprod = id;
        this.disponibilita = disponibilita;
        this.nome = name;
    }

    public Prodotto() {
    }
    //costruttore con agiunta imgpath
    public Prodotto(int idprod, String nome, String desc, double prezzo, int disponibilita, String imgPath_prod) {
        this.idprod = idprod;
        this.nome = nome;
        this.desc = desc;
        this.prezzo = prezzo;
        this.disponibilita = disponibilita;
        this.imgPath_prod = imgPath_prod;
    }
    public Prodotto( String nome, String desc, double prezzo, int disponibilita, String imgPath_prod) {

        this.nome = nome;
        this.desc = desc;
        this.prezzo = prezzo;
        this.disponibilita = disponibilita;
        this.imgPath_prod = imgPath_prod;
    }
    //costruttore per aggiunta prodotto

    public Prodotto( String nome,String desc, double price,int disp) {

        this.nome = nome;
        this.desc = desc;
        this.prezzo = price;
        this.disponibilita=disp;

    }

    //inizio getter and setter
    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public String getImgPath_prod() {
        return imgPath_prod;
    }

    public void setImgPath_prod(String imgPath_prod) {
        this.imgPath_prod = imgPath_prod;
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
    //costruttore senza img
    public Prodotto(int id, String nome, String desc, double price,int disp) {
        this.idprod = id;
        this.nome = nome;

        this.desc = desc;
        this.prezzo = price;
        this.disponibilita=disp;

    }

}