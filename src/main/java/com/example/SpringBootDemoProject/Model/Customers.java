package com.example.SpringBootDemoProject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

@Entity
@Table(name="Customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="CustomerID")
    private Long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @Column(name="Branch")
    private String branch;

}
