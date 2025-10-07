package com.vehiclesSystem.models;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Vehicle {
    private String id;
    private String brand;
    private Type type;
}
