package hibernate.lesson8.homework8_1.model.types;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "FP_USER_TYPE")
public class UserType {
    @Id
    @SequenceGenerator(name = "USER_TYPE_SEQ", sequenceName = "FP_USER_TYPE_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_TYPE_SEQ")
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
