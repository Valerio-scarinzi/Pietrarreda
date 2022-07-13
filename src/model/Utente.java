package model;

public class Utente {
  private  int id;
  private String nome;
  private String cognome;
  private String username;
  private String password;
  private String email;
  private boolean admin;
  private String indirizzo;


  //costruttore vuoto
    public Utente(){};
  //prova
  public Utente( String nome, String cognome, String username){
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.username = username;


  }
  // costruttore con admin
  public Utente(int id, String nome, String cognome, String username, String password, String email, boolean admin, String indirizzo) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.username = username;
    this.password = password;
    this.email = email;
    this.admin = admin;
    this.indirizzo = indirizzo;
  }
  // costruttore senza admin
  public Utente(int id, String nome, String cognome, String username, String password, String email, String indirizzo) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.username = username;
    this.password = password;
    this.email = email;
    this.admin = false;
    this.indirizzo = indirizzo;
  }




  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }
}
