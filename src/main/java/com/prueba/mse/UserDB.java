package com.prueba.mse;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author msubiza
 */
@Entity
@Table(name = "UserDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDB.findAll", query = "SELECT u FROM UserDB u"),
    @NamedQuery(name = "UserDB.findByEmail", query = "SELECT u FROM UserDB u WHERE u.email = :email"),
    @NamedQuery(name = "UserDB.findByName", query = "SELECT u FROM UserDB u WHERE u.name = :name"),
    @NamedQuery(name = "UserDB.findByAge", query = "SELECT u FROM UserDB u WHERE u.age = :age"),
    @NamedQuery(name = "UserDB.findByPassword", query = "SELECT u FROM UserDB u WHERE u.password = :password")})
public class UserDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public UserDB() {
    }

    public UserDB(String email) {
        this.email = email;
    }

    public UserDB(String email, String name, int age, String password) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDB)) {
            return false;
        }
        UserDB other = (UserDB) object;
        return !((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email)));
    }

    @Override
    public String toString() {
        return "com.prueba.mse.UserDB[ email=" + email + " ]";
    }
}
