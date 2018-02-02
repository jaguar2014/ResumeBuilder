package com.ashu.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=1,message = "please enter school")
    private String school;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date gradYear;

    @NotNull
    @Size(min=1,message = "please enter degree type eg. BSc , MSc")
    private String degreeType;

    @NotNull
    @Size(min=1,message = "Please enter degree name")
    private String degreeName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public Date getGradYear() {
        return gradYear;
    }

    public void setGradYear(Date gradYear) {
        this.gradYear = gradYear;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
