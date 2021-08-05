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
@Entity(name = "developers")
public class Developer implements BaseModel<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = 1928374651928374656L;

    @Id
    @Column(name = "id")
    private Long developerID;

    @Column(name = "name", table = "developers")
    private String name;

    @Column(name = "age", table = "developers")
    private Long age;

    @Column(name = "gender", table = "developers")
    private String gender;

    @Column(name = "email", table = "developers")
    private String email;

    @Column(name = "number_phone", table = "developers")
    private Long numberPhone;

    @Column(name = "company_id", table = "developers")
    private Long companyID;

    @Column(name = "salary", table = "developers")
    private Long salary;

    @Override
    public Long getId() {
        return developerID;
    }
}
