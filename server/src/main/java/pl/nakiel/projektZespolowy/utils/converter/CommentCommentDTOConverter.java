package pl.nakiel.projektZespolowy.utils.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nakiel.projektZespolowy.domain.events.Comment;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.resources.dto.common.CommentDTO;

@Service
public class CommentCommentDTOConverter {
    @Autowired
    private UserUserDTOConverter userUserDTOConverter;

    public CommentDTO toCommentDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setComment(comment.getComment());
        commentDTO.setSubmissionDate(comment.getDate());
        commentDTO.setId(comment.getId());
        commentDTO.setUser(userUserDTOConverter.toUserDTO(comment.getCommentsAuthor()));
        return commentDTO;
    }
}
