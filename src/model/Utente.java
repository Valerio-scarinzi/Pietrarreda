

package model;

public class Utente {


  private int id;
  private String nome;
  private String cognome;
  private String username;
  private String password;
  private String email;

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

  public Utente(){

  }


  public Utente(String nome, String cognome, String username){
    this.nome = nome;
    this.cognome = cognome;
    this.username = username;
  }


  //costruttore per registrazione
  public Utente(String nome, String cognome, String username, String password, String email) {
    this.nome = nome;
    this.cognome = cognome;
    this.username = username;
    this.email=email;
    this.password=password;
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



}