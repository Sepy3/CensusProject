import java.util.ArrayList;

public class Province {
    private String name;
    private ArrayList<Municipality> municipalities;

    public Province(String name) {
        this.name = name;
        this.municipalities = new ArrayList<>();
    }

    public void addMunicipality(Municipality m) {
        municipalities.add(m);
    }

    public String getName() {
        return name;
    }

    public int calculatePopulation() {
        int total = 0;
        for (Municipality m : municipalities) {
            total += m.calculatePopulation();
        }
        return total;
    }

    public ArrayList<Municipality> getMunicipalities() {
        return municipalities;
    }

    @Override
    public String toString() {
        String result = " + Province: " + name + " (Total Pop: " + calculatePopulation() + ")\n";
        for (Municipality m : municipalities) {
            result += m.toString(); 
        }
        return result;
    }
}
