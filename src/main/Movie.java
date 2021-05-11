package main;

import main.pricing.Price;

public class Movie
{    
    private String title;
    private int priceCode;
    private Price price;

    public Movie(String newtitle, int newpriceCode)
    {
        title = newtitle;
        priceCode = newpriceCode;
    }


    public int getPriceCode()
    {
        return priceCode;
    }


    public void setPriceCode(int arg)
    {
        priceCode = arg;
    }


    public String getTitle()
    {
        return title;
    }


    public double getCharge(int daysRented)
    {
        double result = 0.0;
        switch (getPriceCode())
        {
            case Price.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case Price.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Price.CHILDRENS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }


    public int getFrequentRenterPoints(int daysRented)
    {
        int resultPoints = 1;

        if ((getPriceCode() == Price.NEW_RELEASE) && daysRented > 1)
        {
            resultPoints++;
        }

        return resultPoints;
    }
}
