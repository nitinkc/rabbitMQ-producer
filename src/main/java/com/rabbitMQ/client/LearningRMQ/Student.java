package com.rabbitMQ.client.LearningRMQ;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
