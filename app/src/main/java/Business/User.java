package Business;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import static javax.persistence.GenerationType.AUTO;

@MappedSuperclass
abstract class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(length = 64, nullable = false)
    private String userName;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private String surname;

    @Column(length = 128, nullable = false)
    private String pwd;

    public User(String name, String surname, String pwd) {
        this.name = name;
        this.surname = surname;
        this.pwd = pwd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getuserName(){ return userName; }

    public String getName() {
        return name;
    }

    public void setUserName(String userName){ this.userName = userName;}

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
