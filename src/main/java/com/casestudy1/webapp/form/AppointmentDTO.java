package com.casestudy1.webapp.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class AppointmentDTO {

    private Integer appointmentId;

    @Length(max = 50, message = "Pet name must be less than 50 characters.")
    @NotEmpty(message = "Pet name is required.")
    private String petName;

    @Length(max = 50, message = "Service name must be less than 50 characters.")
    @NotEmpty(message = "Service name is required.")
    private String serviceName;

    @NotEmpty(message = "Date and time are required.")
    private String dateTime;

    @Length(max = 20, message = "Status must be less than 20 characters.")
    @NotEmpty(message = "Status is required.")
    private String status;
}
