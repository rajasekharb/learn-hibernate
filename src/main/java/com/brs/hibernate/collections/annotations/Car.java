package com.brs.hibernate.collections.annotations;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Rajasekhar
 */
@Entity
@Table(name = "t_car_annotation")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "f_car_id")
    private Long id;

    @Column(name = "f_car_name")
    private String name;

    @Column(name = "f_car_color")
    private String color;

    public Car() {
    }

    //Not providing any getters and setters to show that they are not required.
    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Car car = (Car) object;

        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        if (name != null ? !name.equals(car.name) : car.name != null) return false;
        return color != null ? color.equals(car.color) : car.color == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
