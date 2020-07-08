package com.example.security.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-08 13:25
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Settings {
    private String baseURL="https://github.com/";
    private String witdh="100";
}
