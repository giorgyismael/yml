package com.neogrid.yml.yml.configurations;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@ConfigurationProperties("person")
public class PersonConfiguration {
    String name;
    String birthDays;
    Gender gender;
    List<String> hobby; 

    enum Gender  {MALE, FEMALE, OTHER }
}
