package com.buyacar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lookup")
public class LookUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lookup_category_id")
    private LookUpCategory category;
    // e.g., "PETROL", "MANUAL"
    private String value;   // e.g., "Petrol", "Manual"

    public LookUp() {}
    public LookUp(LookUpCategory category, String code, String value) {
        this.category = category;
        this.value = value;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LookUpCategory getCategory() { return category; }
    public void setCategory(LookUpCategory category) { this.category = category; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}


