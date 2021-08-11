package com.ismail.unittestone.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "produce")
public class Produce {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;

    public Produce() {
    }

    public Produce(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Produce(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Produce setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Produce setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Produce setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produce produce = (Produce) o;
        return price == produce.price &&
                id.equals(produce.id) &&
                name.equals(produce.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}

