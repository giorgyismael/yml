package com.neogrid.yml.yml.configurations;

import com.neogrid.yml.yml.data.Credential;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private Map<String, String> application;
    private Map<String, List<String>> config;
    private Map<String, Credential> users;
}


