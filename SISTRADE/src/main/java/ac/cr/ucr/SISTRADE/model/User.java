package ac.cr.ucr.SISTRADE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, length = 3)
    private Integer age;

    public User(){

        this.name = "";
        this.password =  "";
        this.address =  "";
        this.age = 0;
        this.id  = 0;

    }

    public User(String name, String password, String address, Integer age, Integer id) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.age = age;
        this.id = 0;
    }

    public User(String name, String password){
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + ", address=" + address + ", age=" + age + ", id=" + id + '}';
    }
}
