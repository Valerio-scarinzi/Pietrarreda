package model;
public class ProdottoCategoria {


    private int id_cat;
    private int id_prod;
    public ProdottoCategoria(int id_cat,int id_prod){
        this.id_cat=id_cat;
        this.id_prod=id_prod;
    }


    public int getId_cat(){
        return id_cat;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }
}