package com.rabbitMQ.entity;

import lombok.*;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by nichaurasia on Thursday, January/23/2020 at 1:28 PM
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements Serializable {
	
	@Id
    private Long id;
	@Column(name="name")
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
