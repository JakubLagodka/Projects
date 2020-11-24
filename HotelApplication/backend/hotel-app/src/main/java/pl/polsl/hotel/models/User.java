package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class User  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "surname", nullable = false)
    @NonNull
    private String surname;

    @Column(name = "email", nullable = false)
    @NonNull
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    @NonNull
    private String username;

    @Column(name = "password", nullable = false)
    @NonNull
    private String password;

    @ManyToOne
    @Nullable
    private Role role;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getSurname() {
        return surname;
    }

    public void setSurname(@NonNull String surname) {
        this.surname = surname;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @Nullable
    public Role getRole() {
        return role;
    }

    public void setRole(@Nullable Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
