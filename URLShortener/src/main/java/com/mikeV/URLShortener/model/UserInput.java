package com.mikeV.URLShortener.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="urltable")
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "originURL", columnDefinition = "text")
    private String originURL;

    @Column(name = "shortURL", columnDefinition = "text")
    private String shortURL;

    @Column(name="usersUsed")
    private Long usersUsed;
}
