package tour;

import search.*;

import java.util.HashSet;

public class TourHeuristic implements NodeFunction {

    private HashSet<City> allCities;
    private City goalCity;

    public TourHeuristic(HashSet<City> allCities, City goal){
        this.allCities = allCities;
        this.goalCity = goal;
    }

    public int cost(Node node) {

        HashSet<City> unvisitedCities = new HashSet<>(allCities);
        unvisitedCities.removeAll(((TourState)node.state).visitedCities);
        int max = 0;
        for (City city : unvisitedCities) {
            max = Math.max(max, ((TourState)node.state).currentCity.getShortestDistanceTo(city) + city.getShortestDistanceTo(goalCity));
        }
        return max;
    }
}
