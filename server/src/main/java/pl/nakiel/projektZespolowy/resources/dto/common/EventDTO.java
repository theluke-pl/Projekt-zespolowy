package pl.nakiel.projektZespolowy.resources.dto.common;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Data
public class EventDTO {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private Long id;
    private String title;
    private String description;
    private String date;
    private LocalizationDTO localization;
    private Integer type;
    private Long views;
    private UserDTO author;
    private List<UserDTO> followingUsers;
    private List<CommentDTO> comments;
    private List<ImageDTO> images;
    private Boolean active;

    public Date getSubmissionDateConverted() throws ParseException {
        return dateFormat.parse(this.date);
    }

    public void setSubmissionDate(Date date) {
        this.date = dateFormat.format(date);
    }

}

