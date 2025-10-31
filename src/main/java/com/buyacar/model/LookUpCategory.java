package com.buyacar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lookup_category")
public class LookUpCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // e.g., "FUEL_TYPE"
    private String name;    // e.g., "Fuel Type"

    public LookUpCategory() {}
    public LookUpCategory(String code, String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
