package org.springframework.samples.petclinic.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BaseEntityTest {

    @Test
    public void testgetId() {
        BaseEntity entity = new BaseEntity();
        Integer expected = 10;
        entity.setId(10);
        Assertions.assertEquals(expected, entity.getId());
    }

    @Test
    public void testgetIdnull() {
        BaseEntity entity = new BaseEntity();
        Integer expected = null;
        Assertions.assertEquals(expected, entity.getId());
    }
}
