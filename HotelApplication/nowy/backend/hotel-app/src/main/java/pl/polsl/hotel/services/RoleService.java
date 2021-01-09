package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.*;
import pl.polsl.hotel.repositories.RoleRepository;

import java.util.Arrays;

@Component
public class RoleService implements StartUpFiller {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public Iterable<Role> getRoles() {
        return roleRepository.findAll();
    }


    public void createInitialData() throws RuntimeException {

        //if(this.session.get(Admin.class.getSimpleName(),1) == null)
        if("tak" != null)
        {
            Role adminRole = new Role();
            adminRole.setCode("ADM");
            adminRole.setName(Admin.class.getSimpleName());

            Role clientRole = new Role();
            clientRole.setCode("CLI");
            clientRole.setName(Client.class.getSimpleName());

           /* Role managerRole = new Role();
            managerRole.setCode("MAN");
            managerRole.setName(Manager.class.getSimpleName());*/

            Role workerRole = new Role();
            workerRole.setCode("WOR");
            workerRole.setName(Worker.class.getSimpleName());

            roleRepository.saveAll(Arrays.asList(adminRole, clientRole, /*managerRole,*/ workerRole));
        }

    }

}
