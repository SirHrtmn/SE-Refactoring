/*
 * RegularPrice.java
 *
 * created at 2021-05-07 by n.hartmann n.hartmann@seeburger.de
 * 
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package main.pricing;


public class RegularPrice extends Price
{
    public RegularPrice()
    {
        super();
    }
    
    @Override
    public double getPrice(int daysRented)
    {
        double result = 2.0;
        result += daysRented > 2 ? (daysRented - 2) * 1.5 : 0.0;
        return result;
    }
}



