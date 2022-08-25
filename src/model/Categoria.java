package model;

public class Categoria {
    private int id ;
    private String categoria_nome;
    private String dscrizione;
    private String img;

    public Categoria(int id, String categoria_nome, String dscrizione) {
        this.id = id;
        this.categoria_nome = categoria_nome;
        this.dscrizione = dscrizione;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", categoria_nome='" + categoria_nome + '\'' +
                ", dscrizione='" + dscrizione + '\'' +
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

    public String getDscrizione() {
        return dscrizione;
    }

    public void setDscrizione(String dscrizione) {
        this.dscrizione = dscrizione;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
