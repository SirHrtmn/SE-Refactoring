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
    public static final int REGULAR_CODE = 0;
    public static final int NEW_RELEASE_CODE = 1;
    public static final int CHILDRENS_CODE = 2;
    
    public abstract double getPrice(int daysRented);
    
    public static Price getPriceObject(int priceCode)
    {
        switch (priceCode)
        {
            case REGULAR_CODE:
                return new RegularPrice();
            case NEW_RELEASE_CODE:
                return new NewReleasePrice();
            case CHILDRENS_CODE:
                return new ChildrensPrice();
            default:
                return null;
        }
    }

    public static class RegularPrice extends Price
    {
        public int getPriceCode()
        {
            return Price.REGULAR_CODE;
        }
        
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

    public static class NewReleasePrice extends Price
    {
        public int getPriceCode()
        {
            return Price.NEW_RELEASE_CODE;
        }

        @Override
        public double getPrice(int daysRented)
        {
            return daysRented * 3.0;
        }

    }

    public static class ChildrensPrice extends Price
    {
        public int getPriceCode()
        {
            return Price.CHILDRENS_CODE;
        }

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
