import org.testng.annotations.BeforeClass;
import plane.ExperimentalPlane;
import model.ClassificationLevel;
import model.ExperimentalType;
import model.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.AbstractPlane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static Airport airport;
    private static Airport airportWithPlanesToSort;
    private static MilitaryType MILITARY_TYPE = MilitaryType.TRANSPORT;

    private static List<AbstractPlane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.TRANSPORT),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static List<AbstractPlane> planesToSort = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222)
    );

    private static List<AbstractPlane> planesSortedByMaxLoadCapacityActual = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222)
    );

    private static List<AbstractPlane> transportMilitaryPlanesActual = Arrays.asList(
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.TRANSPORT),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
    );

    private static PassengerPlane planeWithMaxPassengerCapacityActual = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @BeforeClass
    public void airportInitialization(){
        airport = new Airport(planes);
        airportWithPlanesToSort = new Airport(planesToSort);
    }

    @Test
    public void getMilitaryPlanesByTypeTest() {
        List<MilitaryPlane> transportMilitaryPlanesExpected = airport.getMilitaryPlanesByType(MILITARY_TYPE);
        Assert.assertEquals(transportMilitaryPlanesExpected,transportMilitaryPlanesActual);
    }

    @Test
    public void getPassengerPlaneWithMaxCapacityTest() {
        PassengerPlane planeWithMaxPassengersCapacityExpected = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengersCapacityExpected, planeWithMaxPassengerCapacityActual);
    }

    @Test
    public void sortByMaxLoadCapacityTest() {
        airportWithPlanesToSort.sortByMaxLoadCapacity();
        Assert.assertEquals(airportWithPlanesToSort.getPlanes(),planesSortedByMaxLoadCapacityActual);
    }
}
