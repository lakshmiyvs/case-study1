package com.casestudy1.webapp.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
@Getter
@Setter
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serviceid")
    private Integer serviceId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 150)
    private String description;

    @Column(name = "price")
    private Integer price;

    @Override
    public String toString() {
        return "Services{" +
                "serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

