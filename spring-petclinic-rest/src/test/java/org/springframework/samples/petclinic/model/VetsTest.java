package org.springframework.samples.petclinic.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

public class VetsTest {
        @Test
        public void testGetList() {                /* creating empty list */
         Vets v = new Vets();
         Assertions.assertEquals(0,v.getVetList().size());
        }
        @Test
        public void testGetVetsListWithAdded(){         /* Adding a veterinarian to veterinarian list */
            Vets v = new Vets();
            Vet V1 = new Vet();
            V1.setFirstName("Shilpa");
            v.getVetList().add(V1);
            System.out.println(v.getVetList().size());
            Assertions.assertEquals(1,v.getVetList().size());
        }
        @Test
        public void testDate(){
            Visit V = new Visit();
            Visit V1 = new Visit();
            Date D = new Date();
            Date D1 = new Date();
            V.setDate(D);
            V1.setDate(D1);
            Assertions.assertEquals(V.getDate(),V1.getDate());

        }
}

