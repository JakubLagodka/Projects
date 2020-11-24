package pl.polsl.hotel.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.hotel.models.Role;
import pl.polsl.hotel.services.RoleService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Role> getRoles() {
        return roleService.getRoles();
    }


}
