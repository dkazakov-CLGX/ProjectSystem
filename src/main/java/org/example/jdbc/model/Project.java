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
@Entity(name = "projects")
public class Project implements Serializable, BaseModel<Long> {

    @Serial
    private static final long serialVersionUID = 1928374651928374654L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "company_id")
    private Long companyID;

    @Column(name = "customer_id")
    private Long customerID;

    @Column(name = "cost")
    private Long cost;

    @Column(name = "firstDate")
    private String firstDate;
}
