import java.util.ArrayList;

public class Country {
    private String name;
    private ArrayList<Province> provinces;

    public Country(String name) {
        this.name = name;
        this.provinces = new ArrayList<>();
    }

    public void addProvince(Province p) {
        provinces.add(p);
    }

    public String getName() {
        return name;
    }

    public int calculateTotalPopulation() {
        int total = 0;
        for (Province p : provinces) {
            total += p.calculatePopulation();
        }
        return total;
    }

    public ArrayList<Province> getProvinces() {
        return provinces;
    }

    @Override
    public String toString() {
        String result = "=== Country: " + name + " ===\n";
        result += "Total Population: " + calculateTotalPopulation() + "\n";
        result += "-----------------------------\n";
        for (Province p : provinces) {
            result += p.toString() + "\n";
        }
        return result;
    }
}
