package org.springframework.samples.petclinic.model;

<<<<<<< HEAD
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
=======
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
>>>>>>> 04d78e615f2c102125fd093cece9d2594f2ff5fc
    }
}
