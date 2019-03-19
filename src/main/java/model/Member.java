/*
 * BB version of member class
 * 2911118
 */
package model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.jetbrains.annotations.*;
//import javafx.beans.NamedArg;
//import java.io.Serializable;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;


@RequestScoped
@ManagedBean
public class Member implements Serializable {

    @Id
    @GeneratedValue
    private Long id;



    //@Pattern(regexp = "[^0-9]*", message = "Must not contain ANY numbers")
    private String name;

    @NotNull
  //  @Size(min = 2, max = 25)
  //  @Email
    private String email;

    @NotNull
  //  @Size(min = 1, max = 12)
  //  @Digits(fraction = 0, integer = 12)
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @NotNull
  //  @Size(min = 5, max = 20)
    @Column(name = "bburlstr")
    private String bburlstr;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBburlstr() {
        return bburlstr;
    }

    public void setBburlstr(String bburlstr) {
        this.bburlstr = bburlstr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
