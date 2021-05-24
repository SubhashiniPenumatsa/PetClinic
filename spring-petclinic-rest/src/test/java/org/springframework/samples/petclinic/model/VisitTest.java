package org.springframework.samples.petclinic.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class VisitTest {

    @Test
    @Temporal(TemporalType.DATE)
    @DateTimeFormat

    public void testGETDate(){
    /*    Visit V = new Visit();
       Date D = new Date();
        D.setDate(21/01/01);

    //Date expected= ("2020/01/01");
    int expected= (21/01/01);
    V.setDate(D);
    Assertions.assertEquals(expected, V.getDate());*/

        Visit V = new Visit();

        Date D = new Date();

          V.setDate(D);
      // Date expected = D.;

        // Assertions.assertEquals(expected, V.getDate());
        System.out.println(V.getDate());

}
/*  Visit V1 = new Visit();
        Visit V2 = new Visit();

        Date D1 = new Date();
        Date D2 = new Date();

          V1.setDate(D1);
          V2.setDate(D2);


         Assertions.assertEquals(V1.getDate(),V2.getDate());
        System.out.println(V1.getDate());*/
@Test
    public void testGETSETDescription()
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
        Visit V = new Visit();
        P.setName("Amer");
        String expected="Amer";
        //P.setId(12);
        //Pet expected ="cat";
        V.setPet(P);
       // System.out.println("Output is "+V.getPet());
       Assertions.assertEquals(expected, V.getPet().getName());
      //  Assertions.assertEquals(expected, P.getOwner());
      //  Assertions.assertEquals(expected, P.getType());

    }


}



