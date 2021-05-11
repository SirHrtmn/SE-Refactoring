package main;

import main.pricing.Price;

public class Movie
{    
    private String title;
    private Price price;

    public Movie(String newtitle, int newpriceCode)
    {
        price = Price.getNewPriceObject(newpriceCode);
        title = newtitle;
    }


    public int getPriceCode()
    {
        return price.getPriceCode();
    }


    public void setPriceCode(int arg)
    {
        price = Price.getNewPriceObject(arg);
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
