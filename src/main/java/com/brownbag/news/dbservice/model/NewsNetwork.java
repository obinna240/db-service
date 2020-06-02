package com.brownbag.news.dbservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Data
public class NewsNetwork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer serialId;

    private String id;
    private String name;
}

