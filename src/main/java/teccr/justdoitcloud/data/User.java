package teccr.justdoitcloud.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table("USERS")
public class User {
    @Id
    private Long id;
    @Column("USER_NAME")
    private String userName;
    private String name;
    private String email;
    private Type type;
    @Transient
    @JsonIgnore // No incluir esta propiedad en las respuestas JSON de la API
    private List<Task> tasks;
    @Column("CREATED_AT")
    private LocalDateTime createdAt;

    public enum Type {
        ADMIN,
        REGULAR
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
