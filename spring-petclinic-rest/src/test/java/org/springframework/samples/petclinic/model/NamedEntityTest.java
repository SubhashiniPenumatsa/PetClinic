package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NamedEntityTest {
    @Test
    public void testName() {
        NamedEntity name = new NamedEntity();
        String expected = "Jonna";
        name.setName("Jonna");
        Assertions.assertEquals(expected, name.getName());
        Assertions.assertEquals("Jonna", name.toString());
    }
}
