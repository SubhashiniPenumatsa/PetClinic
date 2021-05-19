package org.springframework.samples.petclinic.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class NamedEntityTest {
    @Test
    public void testgetName() {
        NamedEntity entity = new NamedEntity();
        String expected = "test";
        entity.setName("test");
        Assertions.assertEquals(expected, entity.getName());
    }

    @Test
    public void testgetNamenull() {
        NamedEntity entity = new NamedEntity();
        String expected = null;
        Assertions.assertEquals(expected, entity.getName());
    }
}
