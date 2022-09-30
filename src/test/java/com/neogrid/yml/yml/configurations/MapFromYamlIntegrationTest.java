package com.neogrid.yml.yml.configurations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapFromYamlIntegrationTest {

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private PersonConfiguration personConfiguration;

    @Test
    public void whenYamlFileProvidedThenInjectSimpleMap() {
        assertThat(serverProperties.getApplication())
            .containsOnlyKeys("name", "url", "description");

        assertThat(serverProperties.getApplication()
            .get("name")).isEqualTo("InjectMapFromYAML");
    }

    @Test
    public void whenYamlFileProvidedThenInjectComplexMap() {
        assertThat(serverProperties.getConfig()).hasSize(2);

        assertThat(serverProperties.getConfig()
            .get("ips")
            .get(0)).isEqualTo("10.10.10.10");

        assertThat(serverProperties.getUsers()
            .get("root")
            .getUsername()).isEqualTo("user01");
    }

    @Test
    public void whenYamlFileProvidedThenInjectPersonConfiguration() {
        assertThat(personConfiguration.getHobby().get(0)).isEqualTo("ride a bike");
        assertThat(personConfiguration.getName()).isEqualTo("user03");
        assertThat(personConfiguration.getGender()).isEqualTo(PersonConfiguration.Gender.MALE);
    }

}
