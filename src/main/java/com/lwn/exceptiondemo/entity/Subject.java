package com.lwn.exceptiondemo.entity;

import lombok.CustomLog;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import java.io.Serializable;

/**
 * @author lwnlwn987
 */

@Data
@Table(name= "Subject")
public class Subject implements Serializable {
    @Id
    @NotNull
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "attribute")
    private String attribute;

    @NotNull
    @Column(name = "status")
    private Integer status;


}
