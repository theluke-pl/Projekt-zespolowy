package pl.nakiel.projektZespolowy.resources.dto.getallevents;

import lombok.Data;
import pl.nakiel.projektZespolowy.resources.dto.common.EventDTO;

import java.util.List;

@Data
public class GetAllEventsResponseDTO {
    private List<EventDTO> events;
}
