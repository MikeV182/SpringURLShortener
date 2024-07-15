package com.mikeV.URLShortener.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInput {
    private Long id;
    private String originURL;
    private String shortURL;
}
