package demo.api.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
@MappedSuperclass
public class IdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    @Column(name="id")
    private int id;

    public int getId() {
        return id;
    }
}
