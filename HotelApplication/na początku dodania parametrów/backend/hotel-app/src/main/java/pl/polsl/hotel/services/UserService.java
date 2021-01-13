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
public class UserService extends MySession implements StartUpFiller {

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


    public UserView createUser(UserView userPost) {

       /* if (!(user instanceof Admin))
            throw new ForbiddenAccessException(Admin.class);*/
        if (userRepository.findByUsername(userPost.getUsername()).isPresent())
            throw new UsernameAlreadyUsedException(userPost.getUsername());
        User user = map(userPost);

        if (userPost.getRoleCode() != null)
            user.setRole(roleRepository.getById(userPost.getRoleCode()));
        UserView userView = map(userRepository.save(user));
       // if (userView.getRoleCode() != null)
           // userRepository.updateRole(userView.getId(), getClassName(userView.getRoleCode()));
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
         //   userRepository.updateRole(user.getId(), getClassName(user.getRole().getCode()));

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


        //if(this.session.get(Admin.class.getSimpleName(),1) == null)
        if("tak" != null)
         {
            Admin admin = new Admin();
            admin.setEmail("glownyAdmin@gmail.com");
            admin.setName("Główny");
            admin.setSurname("Admin");
            admin.setUsername("admin1");
            admin.setPassword(bCryptPasswordEncoder.encode("admin1"));
            admin.setRole(roleRepository.getOne("ADM"));
            userRepository.save(admin);

            Client client = new Client();
            client.setEmail("klient@gmail.com");
            client.setName("Jan");
            client.setSurname("Kowalski");
            client.setUsername("klient1");
            client.setPassword(bCryptPasswordEncoder.encode("klient1"));
            client.setRole(roleRepository.getOne("CLI"));
            userRepository.save(client);

            Worker worker = new Worker();
            worker.setEmail("recepcjonista@gmail.com");
            worker.setName("Janusz");
            worker.setSurname("Nowak");
            worker.setUsername("recepcjonista1");
            worker.setPassword(bCryptPasswordEncoder.encode("recepcjonista1"));
            worker.setRole(roleRepository.getOne("WOR"));
            userRepository.save(worker);

            Manager manager = new Manager();
            manager.setEmail("menadzer@gmail.com");
            manager.setName("Władysław");
            manager.setSurname("Władczy");
            manager.setUsername("menadzer1");
            manager.setPassword(bCryptPasswordEncoder.encode("menadzer1"));
            manager.setRole(roleRepository.getOne("MAN"));
            userRepository.save(manager);
        }
    }
    public User map(UserView userView) {
        User user = new User();
        user.setUsername(userView.getUsername());
        user.setSurname(userView.getSurname());
        user.setEmail(userView.getEmail());
        user.setName(userView.getName());
        user.setPassword(bCryptPasswordEncoder.encode(userView.getPassword()));
        return user;
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
