package tour;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class TourState implements State {
	final Set<City> visitedCities;
	final City currentCity;
	
	public TourState(City startCity) {
		this.visitedCities = Collections.emptySet();
		this.currentCity = startCity;
	}
	public TourState(Set<City> visitedCities, City currentCity) {
		this.visitedCities = visitedCities;
		this.currentCity = currentCity;
	}
	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;
	}
	public State getActionResult(Action action) {
		Road road = (Road)action;
		Set<City> newVisitedCities = new LinkedHashSet<City>(visitedCities);
		newVisitedCities.add(road.targetCity);
		return new TourState(newVisitedCities, road.targetCity);
	}

	@Override
	public boolean equals(Object t){
		return (this == t ||
				t instanceof TourState &&
				this.visitedCities.equals(((TourState)t).visitedCities) &&
				this.currentCity.equals(((TourState)t).currentCity)
		);
	}

	@Override
	public int hashCode() {
		return visitedCities.hashCode();
	}
}
