package com.brs.hibernate.entity.set;

import java.util.Set;

/**
 * @author Rajasekhar
 */
public class Showroom {

    private long id;
    private String manager;
    private String location;
    private Set<Car> cars;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Showroom showroom = (Showroom) object;

        if (id != showroom.id) return false;
        if (manager != null ? !manager.equals(showroom.manager) : showroom.manager != null) return false;
        if (location != null ? !location.equals(showroom.location) : showroom.location != null) return false;
        return cars != null ? cars.equals(showroom.cars) : showroom.cars == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        return result;
    }
}
