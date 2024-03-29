package model;

public class Categoria {
    private int id ;
    private String categoria_nome;
    private String descrizione;
    private String img;
    //costruttore pieno
    public Categoria(int id, String categoria_nome, String descrizione,String img) {
        this.id = id;
        this.categoria_nome = categoria_nome;
        this.descrizione = descrizione;
        this.img=img;
    }
    //costruttore senza id
    public Categoria( String categoria_nome, String descrizione,String img) {
        this.categoria_nome = categoria_nome;
        this.descrizione = descrizione;
        this.img=img;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", categoria_nome='" + categoria_nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public Categoria(){ }














    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria_nome() {
        return categoria_nome;
    }

    public void setCategoria_nome(String categoria_nome) {
        this.categoria_nome = categoria_nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
