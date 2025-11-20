import java.util.ArrayList;

public class Municipality {
    private String name;
    private ArrayList<City> cities;

    public Municipality(String name) {
        this.name = name;
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public String getName() {
        return name;
    }

    public int calculatePopulation() {
        int total = 0;
        for (City c : cities) {
            total += c.getPopulation();
        }
        return total;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        String result = "  * Municipality: " + name + " (Total Pop: " + calculatePopulation() + ")\n";
        for (City c : cities) {
            result += c.toString() + "\n";
        }
        return result;
    }
}
