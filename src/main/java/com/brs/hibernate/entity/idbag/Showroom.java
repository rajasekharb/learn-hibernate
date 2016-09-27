package com.brs.hibernate.entity.idbag;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rajasekhar
 */
public class Showroom implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String location;
    private String manager;
    private List<Car> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Showroom showroom = (Showroom) object;

        if (id != null ? !id.equals(showroom.id) : showroom.id != null) return false;
        if (location != null ? !location.equals(showroom.location) : showroom.location != null) return false;
        if (manager != null ? !manager.equals(showroom.manager) : showroom.manager != null) return false;
        return cars != null ? cars.equals(showroom.cars) : showroom.cars == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Showroom{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", manager='" + manager + '\'' +
                ", cars=" + cars +
                '}';
    }
}
