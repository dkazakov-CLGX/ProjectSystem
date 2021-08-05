package org.example.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "developers_skills")
public class DeveloperSkill implements BaseModel<Long> , Serializable {

    @Serial
    private static final long serialVersionUID = 1928374651923773356L;

    @Id
    @Column(name = "developer_id")
    private Long developerID;

    @Column(name = "skill_id")
    private Long skillID;

    @Override
    public Long getId() {
        return developerID;
    }
}
