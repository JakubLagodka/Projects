package pl.polsl.hotel.mappers;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.ActionStatus;
import pl.polsl.hotel.models.CodeEntity;
import pl.polsl.hotel.views.ActionStatusView;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActionStatusMapper {


    public ActionStatusView map(ActionStatus actionStatus) {
        ActionStatusView actionStatusView = new ActionStatusView();
        actionStatusView.setCode(actionStatus.getCode());
        actionStatusView.setName(actionStatus.getName());
        List<String> childrenCodes = actionStatus
                .getChildActionStatuses()
                .stream()
                .map(CodeEntity::getCode)
                .collect(Collectors.toList());
        actionStatusView.setChildrenCodes(childrenCodes);
        return actionStatusView;
    }

}
