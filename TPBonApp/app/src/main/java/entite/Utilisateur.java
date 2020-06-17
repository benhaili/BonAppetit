package entite;
public class Utilisateur {
    private int IdUtilisateur;
    private String nom;
    private String email;
    private String tel;
    private  String password;
    public Utilisateur(int idUtilisateur, String nom, String email, String tel, String password) {
        IdUtilisateur = idUtilisateur;
        this.nom = nom;
        this.email = email;
        this.tel = tel;
        this.password = password;
    }
    public Utilisateur() {
    }
    public int getIdUtilisateur() {
        return IdUtilisateur;
    }
    public void setIdUtilisateur(int idUtilisateur) {
        IdUtilisateur = idUtilisateur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
