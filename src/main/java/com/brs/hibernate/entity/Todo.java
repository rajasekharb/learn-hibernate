package com.brs.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Rajasekhar
 */
@Entity
@Table(name = "t_todo")
public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "f_id")
    @GeneratedValue()
    private long id;
    @Column(name = "f_title")
    private String title;
    @Column(name = "f_description")
    private String description;

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Todo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Todo todo = (Todo) other;

        if (id != todo.id) return false;
        if (title != null ? !title.equals(todo.title) : todo.title != null) return false;
        return description != null ? description.equals(todo.description) : todo.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
