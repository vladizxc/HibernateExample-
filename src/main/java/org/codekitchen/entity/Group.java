package org.codekitchen.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_number", nullable = false, length = 10)
    private String groupNumber;

    @Column(name = "facultyType", nullable = false)
    private FacultyType facultyType;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;

    public Group() {}

    public Group(String groupNumber, FacultyType facultyType) {
        this.groupNumber = groupNumber;
        this.facultyType = facultyType;
    }

    public void addStudentToGroup(Student student){
        if (students == null) students = new ArrayList<>();
        students.add(student);
        student.setGroup(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public FacultyType getFacultyType() {
        return facultyType;
    }

    public void setFacultyType(FacultyType facultyType) {
        this.facultyType = facultyType;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber='" + groupNumber + '\'' +
                ", facultyType=" + facultyType +
                ", id=" + id +
                '}';
    }
}
