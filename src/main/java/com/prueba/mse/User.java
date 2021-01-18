package com.prueba.mse;

import java.util.Objects;
import org.springframework.data.annotation.Id;

/**
 *
 * @author msubiza
 */
public class User {
    
    @Id
    private String email;
    private String password;
    private int age;
    private String name;

    public User() {
    }

    public User(String email, String password, int age, String name) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", sge=" + age + ", name=" + name + '}';
    }
    
    
    
}
