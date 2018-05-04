package pl.nakiel.projektZespolowy.resources.dto.getevent;

import lombok.Data;
import pl.nakiel.projektZespolowy.resources.dto.common.EventDTO;

@Data
public class GetEventResponseDTO {
    private EventDTO event;
}
