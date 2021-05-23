package org.springframework.samples.petclinic.model;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


public class VetTest {
    Vet vetTest = new Vet();
    Specialty surgery = new Specialty();

    @Test
    public void getNrOfSpec() {
        surgery.setName("Surgery");
        Assertions.assertEquals(0, vetTest.getNrOfSpecialties());
        vetTest.addSpecialty(surgery);
        Assertions.assertEquals(1, vetTest.getNrOfSpecialties());
    }
    @Test
    public void addSpec() {
        surgery.setName("Surgery");
        vetTest.addSpecialty(surgery);
        Assertions.assertEquals(1, vetTest.getNrOfSpecialties());
    }
    @Test
    public void clearSpec() {
        surgery.setName("Surgery");
        vetTest.addSpecialty(surgery);
        Assertions.assertEquals(1, vetTest.getNrOfSpecialties());
        vetTest.clearSpecialties();
        Assertions.assertEquals(0, vetTest.getNrOfSpecialties());
    }

}
