package com.example.SpringBootDemoProject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

@Entity
@Table(name="Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ProductID")
    private Long id;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name="Product_Code")
    private String productCode;

    @Column(name="Release_Date")
    private String releaseDate;

    @Column(name="Description")
    private String description;

    @Column(name="Price")
    private long price;

    @Column(name="Star_Rating")
    private float starRating;

    @Column(name="Image_Url")
    private String imageUrl;

}
