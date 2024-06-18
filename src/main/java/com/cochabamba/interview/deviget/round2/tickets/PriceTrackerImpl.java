package com.cochabamba.interview.deviget.round2.tickets;

import com.cochabamba.interview.deviget.round2.services.AirlinesInfoServices;

import java.util.List;
//import com.codesignal.services.AirlinesInfoServices;

public class PriceTrackerImpl implements PriceTracker {

    private final AirlinesInfoServices airlinesInfoServices;

    public PriceTrackerImpl(AirlinesInfoServices airlinesInfoServices) {
        this.airlinesInfoServices = airlinesInfoServices;
    }

    @Override
    public int getCheapestTicketPrice(String originAirport, String destinationAirport) {
        // Use the provided services in order to get the price of the cheapest DIRECT flight.
        List<String> airlines = airlinesInfoServices.getAvailableAirlines();

        int tmpPrice;
        int cheapestPrice=0;
        if(airlines.isEmpty())  {
            return -1;
        }
        for(int i=0;i<airlines.size();i++)    {
            tmpPrice = airlinesInfoServices.getTicketPrice(airlines.get(i), originAirport, destinationAirport);

            if(i==0 || (tmpPrice!=-1 && tmpPrice<cheapestPrice))    {
                cheapestPrice=tmpPrice;
            }
            System.out.println(airlines.get(i)+", tmpPrice:"+tmpPrice+", cheapestPrice:"+cheapestPrice);
        }
        return cheapestPrice;
    }
}
