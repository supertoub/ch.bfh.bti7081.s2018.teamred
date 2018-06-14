package Business;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
abstract class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
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

    @Column(length = 128, nullable = false)
    private String salt;

    public User(String name, String surname, String pwd, String salt) {
        this.name = name;
        this.surname = surname;
        this.pwd = pwd;
        this.salt = salt;
    }

    protected User() {
    }

    public long getId() {
        return id;
    }

    public long setId(long id) { return this.id = id; }

    public String getuserName(){ return userName; }

    public String getName() {
        return name;
    }

    public String setUserName(String userName){ return this.userName = userName; }

    public String setName(String name) { return this.name = name; }

    public String getSurname() {
        return surname;
    }

    public String setSurname(String surname) { return this.surname = surname; }

    public String getPwd() {
        return pwd;
    }

    public String setPwd(String pwd) { return this.pwd = BCrypt.hashpw(pwd, salt); }

    public String getSalt() { return salt; }

    public String setSalt() { return this.salt = salt; }
}
