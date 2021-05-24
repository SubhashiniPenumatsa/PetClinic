package org.springframework.samples.petclinic.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SpecialtyTest {
    @Test
    public void testgetSpecialty() {
        Specialty S = new Specialty();
        String expected = "Paediatrics";
        S.setSpecialty("Paediatrics");
        Assertions.assertEquals(expected, S.getSpecialty());
    }
}
