package pl.nakiel.projektZespolowy.resources.dto.addevent;

import lombok.Data;
import pl.nakiel.projektZespolowy.resources.dto.common.EventDTO;

@Data
public class AddEventRequestDTO {
    private EventDTO event;
}
