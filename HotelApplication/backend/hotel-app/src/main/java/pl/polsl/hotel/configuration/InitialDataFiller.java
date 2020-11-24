package pl.polsl.hotel.configuration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import pl.polsl.hotel.services.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class InitialDataFiller implements ApplicationRunner {

    private final List<StartUpFiller> startUpFillers = new LinkedList<>();

    public InitialDataFiller(UserService userService, RoleService roleService, ActionStatusService actionStatusService, ObjectTypeService objectTypeService, ActivityTypeService activityTypeService) {
        startUpFillers.addAll(Arrays.asList(userService, roleService, actionStatusService, activityTypeService, objectTypeService));
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
