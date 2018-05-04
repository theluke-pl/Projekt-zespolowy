package pl.nakiel.projektZespolowy.resources.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CommentDTO {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private Long id;
    private String comment;
    private String date;
    private UserDTO user;

    @JsonIgnore
    public Date getSubmissionDateConverted() throws ParseException {
        return dateFormat.parse(this.date);
    }

    public void setSubmissionDate(Date date) {
        this.date = dateFormat.format(date);
    }
}
