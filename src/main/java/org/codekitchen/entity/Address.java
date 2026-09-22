package org.codekitchen.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="street", nullable = false)
    private String street;

    @Column(name="building_number", nullable = false, length = 50)
    private int buildingNumber;

    @Column(name="apartment_number", nullable = false)
    private int apartmentNumber;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Address() {}

    public Address(String street, int buildingNumber, int apartmentNumber) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
