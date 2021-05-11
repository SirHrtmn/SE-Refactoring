package main;

import main.pricing.Price;

public class Movie
{    
    private String title;
    private int priceCode;
    private Price price;

    public Movie(String newtitle, int newpriceCode)
    {
        price = Price.getPriceObject(newpriceCode);
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
        return price.getPrice(daysRented);
    }


    public int getFrequentRenterPoints(int daysRented)
    {
        int resultPoints = 1;

        if ((getPriceCode() == Price.NEW_RELEASE_CODE) && daysRented > 1)
        {
            resultPoints++;
        }

        return resultPoints;
    }
}
