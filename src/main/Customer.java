package main;


import java.util.Enumeration;
import java.util.Vector;


public class Customer
{
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String newname)
    {
        name = newname;
    }


    public void addRental(Rental arg)
    {
        rentals.addElement(arg);
    }


    public String getName()
    {
        return name;
    }


    public String htmlStatement()
    {
        String result = "<1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";
        for (Rental rental : rentals)
        {
            result += rental.getMovie().getTitle() + ": " + String.valueOf(rental.getCharge()) + "<BR>\n";
        }
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
    }


    public String statement()
    {
        Enumeration<Rental> enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements())
        {
            Rental rental = enum_rentals.nextElement();

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + rental.getCharge() + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }


    private double getTotalCharge()
    {
        double result = 0.0;
        for (Rental rental : rentals)
        {
            result += rental.getCharge();
        }
        return result;
    }


    private int getTotalFrequentRenterPoints()
    {
        int result = 0;
        for (Rental rental : rentals)
        {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

}
