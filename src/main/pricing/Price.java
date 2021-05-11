/*
 * Price.java
 *
 * created at 2021-05-07 by n.hartmann n.hartmann@seeburger.de
 * 
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package main.pricing;


public abstract class Price
{
    public abstract double getPrice(int daysRented);

    public class RegularPrice extends Price
    {

        @Override
        public double getPrice(int daysRented)
        {
            double result = 2.0;
            if (daysRented > 2)
            {
                result += (daysRented - 2) * 1.5;
            }
            return result;
        }

    }

    public class NewReleasePrice extends Price
    {

        @Override
        public double getPrice(int daysRented)
        {
            return daysRented * 3.0;
        }

    }

    public class ChildrensPrice extends Price
    {

        @Override
        public double getPrice(int daysRented)
        {
            double result = 1.5;
            if (daysRented > 3)
            {
                result += (daysRented - 3) * 1.5;
            }
            return result;
        }

    }
}
