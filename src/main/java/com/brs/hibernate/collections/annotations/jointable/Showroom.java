package com.brs.hibernate.collections.annotations.jointable;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Rajasekhar
 */
@Entity
@Table(name = "t_showroom_annotation_join_table")
public class Showroom implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "f_showroom_id")
    private Long id;

    @Column(name = "f_showroom_manager")
    private String manager;

    @Column(name = "f_showroom_location")
    private String location;

    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "t_showroom_car_set_join_table", joinColumns = @JoinColumn(name = "f_showroom_id"))
    private List<Car> cars;

    public Showroom() {
    }

    //Not providing any getters and setters to show that they are not required.
    public Showroom(String manager, String location, List<Car> cars) {
        this.manager = manager;
        this.location = location;
        this.cars = cars;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Showroom showroom = (Showroom) object;

        if (id != null ? !id.equals(showroom.id) : showroom.id != null) return false;
        if (manager != null ? !manager.equals(showroom.manager) : showroom.manager != null)
            return false;
        if (location != null ? !location.equals(showroom.location) : showroom.location != null)
            return false;
        return cars != null ? cars.equals(showroom.cars) : showroom.cars == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Showroom{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
