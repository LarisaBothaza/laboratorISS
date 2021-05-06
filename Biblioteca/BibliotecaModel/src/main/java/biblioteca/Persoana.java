package biblioteca;

import java.io.Serializable;

public class Persoana implements Entity<Integer>, Serializable {

    private String nume;
    private String username;
    private String parola;
    private String email;
    private int id;

    public Persoana(){

    }

    public Persoana(String nume, String username, String parola, String email) {
        this.nume = nume;
        this.username = username;
        this.parola = parola;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                ", id=" + id +
                '}';
    }
}
