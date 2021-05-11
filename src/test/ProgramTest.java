/*
 * ProgramTest.java
 *
 * created at 2021-05-06 by n.hartmann n.hartmann@seeburger.de
 * 
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package test;


import org.junit.Assert;
import org.junit.Test;

import main.Customer;
import main.Movie;
import main.Rental;


public class ProgramTest
{

    private static final String PROGRAM_RESULT = "Rental Record for joe\n" + 
                    "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n" +
                    "\t" + "movie1" + "\t" + "\t" + "10" + "\t" + "30.0" + "\n" +
                    "\t" + "movie2" + "\t" + "\t" + "5" + "\t" + "4.5" + "\n" +
                    "Amount owed is 34.5\n" + 
                    "You earned 3 frequent renter points";

    @Test
    public void testProgram()
    {
        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(r1);
        c1.addRental(r2);
        
        Assert.assertEquals(PROGRAM_RESULT, c1.statement());
        
    }

}
