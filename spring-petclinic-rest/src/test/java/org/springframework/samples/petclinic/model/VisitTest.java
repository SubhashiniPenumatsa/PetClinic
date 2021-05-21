package org.springframework.samples.petclinic.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class VisitTest {

@Test
    public void testDate(){
    Visit V = new Visit();
    String expected= "2002/01/01";
    V.setDate("2002/01/01");
    Assertions.assertEquals(expected, V.getDate());
}

@Test
    public void testDescription()
{
    Visit V = new Visit();
    String expected = "Soft Wound";
    V.setDescription("Soft Wound");
    Assertions.assertEquals(expected,V.getDescription());
}
    @Test
    public void testPet()
    {
        Pet P = new Pet();
        //Visit V = new Visit();
        //Pet expected ="cat";

        Assertions.assertEquals(expected, P.getBirthDate());
        Assertions.assertEquals(expected, P.getOwner());
        Assertions.assertEquals(expected, P.getType());

    }


}



