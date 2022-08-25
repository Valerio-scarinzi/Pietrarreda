

package model;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Utente {


  private int id;
  private String nome;
  private String cognome;
  private String username;
  private String password;
  private String email;
  private boolean admin;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) { // password è    inserita dall’utente
  this.password = password;
    /*  try {
      MessageDigest digest =
          MessageDigest.getInstance("SHA-1");
      digest.reset();
      digest.update(password.getBytes(StandardCharsets.UTF_8));
      this.password = String.format("%040x", new
          BigInteger(1, digest.digest()));
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }*/
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Utente(){

  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
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

  @Override
  public String toString() {
    return "Utente{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", cognome='" + cognome + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
        ", admin='" + admin + '\'' +
        '}';
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