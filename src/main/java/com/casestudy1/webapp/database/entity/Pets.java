package com.casestudy1.webapp.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
@Getter
@Setter
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petid")
    private Integer petid;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    @Column(name = "breed", length = 100)
    private String breed;

    @Column(name = "age")
    private Integer age;

    //---------One User can have Many Pets----------
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    private Users user;

    @Column(name = "userid")
    private Integer userid;
    //------------------------------------------------

    @Override
    public String toString() {
        return "Pets{" +
                "petId=" + petid +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", userId=" + userid +
                '}';
    }
}

