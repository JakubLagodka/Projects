package pl.polsl.hotel.configuration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import pl.polsl.hotel.models.Parameter;
import pl.polsl.hotel.services.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class InitialDataFiller implements ApplicationRunner {

    private final List<StartUpFiller> startUpFillers = new LinkedList<>();

    public InitialDataFiller( RoomTypeService roomTypeService, UserService userService, RoleService roleService, ParameterService parameterService) {
        startUpFillers.addAll(Arrays.asList(roomTypeService, userService, roleService, parameterService));
    }

    @Override
    public void run(ApplicationArguments args) {
        for(StartUpFiller startUpFiller: startUpFillers) {
            try {
                startUpFiller.createInitialData();
            } catch (Exception ignore) {

            }
        }
    }

}
