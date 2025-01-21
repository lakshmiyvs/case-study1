package com.casestudy1.webapp.database.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentid")
    private Integer appointmentid;

    //---------One User can have Many Appointments----------
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    private Users user;

    @Column(name = "userid")
    private Integer userid;
    //-------------------------------------------------------

    //---------One Pet can have Many Appointments-----------
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "petid", nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    private Pets pet;

    @Column(name = "petid")
    private Integer petid;
    //-------------------------------------------------------

    //---------One Service can have Many Appointments--------
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "serviceid", nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    private Services service;

    @Column(name = "serviceid")
    private Integer serviceid;
    //--------------------------------------------------------

    @Column(name = "date", columnDefinition = "VARCHAR(45)")
    private String date;

    @Column(name = "time", columnDefinition = "VARCHAR(45)")
    private String time;

    @Column(name = "status", columnDefinition = "VARCHAR(100)")
    private String status;

    @Column(name = "message", columnDefinition = "VARCHAR(200)")
    private String message;

    @Override
    public String toString() {
        return "Appointments{" +
                "appointmentId=" + appointmentid +
                ", userId=" + userid +
                ", petId=" + petid +
                ", serviceId=" + serviceid +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


}

