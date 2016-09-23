package com.brs.hibernate.entity;

import java.util.List;

/**
 * @author Rajasekhar
 */
public class Showroom {

    private long id;
    private String manager;
    private String location;
    private List<Car> carList;

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

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Showroom showroom = (Showroom) other;

        if (id != showroom.id) return false;
        if (manager != null ? !manager.equals(showroom.manager) : showroom.manager != null) return false;
        if (location != null ? !location.equals(showroom.location) : showroom.location != null) return false;
        return carList != null ? carList.equals(showroom.carList) : showroom.carList == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (carList != null ? carList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Showroom{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", carList=" + carList +
                '}';
    }
}
