package pl.polsl.hotel.services;

import org.springframework.lang.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.ForbiddenAccessException;
import pl.polsl.hotel.exceptions.NotImplementedException;
import pl.polsl.hotel.exceptions.UsernameAlreadyUsedException;
import pl.polsl.hotel.models.*;
import pl.polsl.hotel.repositories.RoleRepository;
import pl.polsl.hotel.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService implements  StartUpFiller {

    private final UserRepository userRepository;
    private final AuthenticationTokenService authenticationService;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, AuthenticationTokenService authenticationService, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public UserView createUser(String token, User user) {
        User currentUser = authenticationService.getUserFromToken(token);
        if (!(currentUser instanceof Admin))
            throw new ForbiddenAccessException(Admin.class);
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new UsernameAlreadyUsedException(user.getUsername());

        if (user.getRole().getCode() != null)
            user.setRole(roleRepository.getById(user.getRole().getCode()));
        UserView userView = map(userRepository.save(user));
        if (userView.getRoleCode() != null)
            userRepository.updateRole(userView.getId(), getClassName(userView.getRoleCode()));
        return userView;
    }


    public UserView getUser(String token) {
        return map(authenticationService.getUserFromToken(token));
    }


    public UserView getPatchedUser(String token, Long userId, User user) {
        User currentUser = authenticationService.getUserFromToken(token);
        User userToUpdate = userRepository.getById(userId);
        if (!(currentUser instanceof Admin))
            throw new ForbiddenAccessException(Admin.class);
        if (userToUpdate instanceof Admin)
            throw new ForbiddenAccessException("Cannot change other administrator");

        if(user.getPassword() != null)
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            if(user.getRole().getCode() != null)
                user.setRole(roleRepository.getById(user.getRole().getCode()));
            else
                user.setRole(null);
            userRepository.updateRole(user.getId(), getClassName(user.getRole().getCode()));

            return map(userRepository.save(user));
    }

    private String getClassName(@Nullable String roleCode) {
        if (roleCode == null)
            return User.class.getSimpleName();
        switch (roleCode) {
            case "MAN":
                return Manager.class.getSimpleName();
            case "CLI":
                return Client.class.getSimpleName();
            case "ADM":
                return Admin.class.getSimpleName();
            case "WOR":
                return Worker.class.getSimpleName();
            default:
                throw new NotImplementedException("Missing implementation for role with code " + roleCode);
        }
    }


    public List<UserView> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::map).collect(Collectors.toList());
    }

    public void createInitialData() throws RuntimeException {
        Admin admin = new Admin();
        admin.setEmail("primaryAdmin@wp.pl");
        admin.setName("Primary");
        admin.setSurname("Admin");
        admin.setUsername("admin1");
        admin.setPassword(bCryptPasswordEncoder.encode("admin1"));
        admin.setRole(roleRepository.getOne("ADM"));
        userRepository.save(admin);

        Client client = new Client();
        client.setEmail("client@wp.pl");
        client.setName("Josh");
        client.setSurname("Clint");
        client.setUsername("client1");
        client.setPassword(bCryptPasswordEncoder.encode("client1"));
        client.setRole(roleRepository.getOne("CLI"));
        userRepository.save(client);

        Worker worker = new Worker();
        worker.setEmail("worker@wp.pl");
        worker.setName("Bob");
        worker.setSurname("Worens");
        worker.setUsername("worker1");
        worker.setPassword(bCryptPasswordEncoder.encode("worker1"));
        worker.setRole(roleRepository.getOne("WOR"));
        userRepository.save(worker);

        Manager manager = new Manager();
        manager.setEmail("manager@wp.pl");
        manager.setName("Lucian");
        manager.setSurname("Maners");
        manager.setUsername("manager1");
        manager.setPassword(bCryptPasswordEncoder.encode("manager1"));
        manager.setRole(roleRepository.getOne("MAN"));
        userRepository.save(manager);
    }

    public UserView map(User user) {
        UserView userView = new UserView();
        if (user.getRole() != null)
            userView.setRoleCode(user.getRole().getCode());
        userView.setId(user.getId());
        userView.setEmail(user.getEmail());
        userView.setName(user.getName());
        userView.setSurname(user.getSurname());
        userView.setUsername(user.getUsername());
        return userView;
    }
}
