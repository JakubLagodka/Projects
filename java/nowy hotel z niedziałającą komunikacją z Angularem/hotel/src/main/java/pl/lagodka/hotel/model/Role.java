package pl.lagodka.hotel.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Table(name = "roles")
@Entity

public class Role extends CodeName {


    @OneToMany(mappedBy = "role")
    @NonNull
    private List<User> users = new LinkedList<>();


    @NonNull
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(@NonNull List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +

                ", users=" + users +
                '}';
    }

    public Role() {
    }
}
