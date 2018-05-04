package pl.nakiel.projektZespolowy.resources.dto.addcomment;

import lombok.Data;
import pl.nakiel.projektZespolowy.resources.dto.common.CommentDTO;
import pl.nakiel.projektZespolowy.resources.dto.common.EventDTO;

@Data
public class AddCommentRequestDTO {
    private EventDTO event;
    private CommentDTO comment;
}
