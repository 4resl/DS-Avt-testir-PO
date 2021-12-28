import plane.ExperimentalPlane;
import model.MilitaryType;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.AbstractPlane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends AbstractPlane> planes;

    public Airport(List<? extends AbstractPlane> planes) {
        this.planes = planes;
    }

    public List<? extends AbstractPlane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(PassengerPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(MilitaryPlane.class::cast)
                .collect(Collectors.toList());
    }


    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return Collections
                .max(getPassengerPlanes(),Comparator.comparing(plane -> plane.getPassengersCapacity()));
    }

    public List<MilitaryPlane> getMilitaryPlanesByType(MilitaryType militaryType) {
        return  getMilitaryPlanes().stream()
                .filter(plane -> plane.getType() == militaryType)
                .collect(Collectors.toList());
    }


    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(ExperimentalPlane.class::cast)
                .collect(Collectors.toList());
    }

    public void sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(AbstractPlane::getMaxFlightDistance));
    }

    public void sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(AbstractPlane::getMaxSpeed));
    }

    public void sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(AbstractPlane::getMaxLoadCapacity));
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
