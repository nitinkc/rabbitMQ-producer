package com.rabbitMQ.client.LearningRMQ;

import lombok.*;

import java.io.Serializable;

/**
 * Created by nichaurasia on Thursday, January/23/2020 at 1:28 PM
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
