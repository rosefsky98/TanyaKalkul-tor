import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Village {

    private final Map<String, Building> buildings = new HashMap<>();
    private final Map<String, Unit> units = new HashMap<>();

    public Village() {
        for (String name : Building.getSupportedBuildingNames()) {
            buildings.put(name.toLowerCase(), new Building(name, 0));
        }
    }

    public static String[] getSupportedUnitNames() {
        return new String[] {
                "lándzsás", "kardforgató", "bárdos", "íjász", "kém",
                "könnyűlovas", "lovas íjász", "nehézlovas", "faltörő kos", "katapult",
                "lovag", "főnemes", "milícia"
        };
    }

    public void setBuildingLevel(String name, int level) {
        name = name.toLowerCase();
        if (buildings.containsKey(name)) {
            buildings.put(name, new Building(name, level));
        } else {
            System.out.println("Ismeretlen épület: " + name);
        }
    }

    public int getBuildingLevel(String name) {
        name = name.toLowerCase();
        if (buildings.containsKey(name)) {
            return buildings.get(name).getLevel();
        }
        return -1;
    }

    public void addUnit(String name, int count, int populationPerUnit) {
        units.put(name.toLowerCase(), new Unit(name, count, populationPerUnit));
    }

    public int getTotalUnitPopulation() {
        int sum = 0;
        for (Unit unit : units.values()) {
            sum += unit.getTotalPopulationCost();
        }
        return sum;
    }

    public int getTotalUsedPopulation() {
        int sum = 0;
        for (Building building : buildings.values()) {
            sum += building.getPopulationCost();
        }
        sum += getTotalUnitPopulation();
        return sum;
    }

    public int getMaxPopulation() {
        Building farm = buildings.get("tanya");
        return farm != null ? Building.getFarmCapacity(farm.getLevel()) : 0;
    }

    public boolean isPopulationWithinLimit() {
        return getTotalUsedPopulation() <= getMaxPopulation();
    }

    public void printOverview() {
        printOverviewTo(null, null);
    }

    public void printOverviewTo(JTextArea area) {
        printOverviewTo(area, null);
    }

    public void printOverviewTo(JTextArea area, String[] buildingOrder) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Falu összegzés ===\n");

        if (buildingOrder != null) {
            for (String name : buildingOrder) {
                Building b = buildings.get(name.toLowerCase());
                sb.append(String.format("%s (szint: %d) - %d hely\n",
                        capitalize(name), b.getLevel(), b.getPopulationCost()));
            }
        } else {
            for (String name : buildings.keySet()) {
                Building b = buildings.get(name);
                sb.append(String.format("%s (szint: %d) - %d hely\n",
                        capitalize(name), b.getLevel(), b.getPopulationCost()));
            }
        }

        sb.append("--- Egységek ---\n");
        for (Unit unit : units.values()) {
            sb.append(String.format("%s: %d db - %d hely\n",
                    capitalize(unit.getName()), unit.getCount(), unit.getTotalPopulationCost()));
        }
        sb.append("------------------------\n");
        sb.append("Összesen használt tanyahely: ").append(getTotalUsedPopulation()).append("\n");
        sb.append("Tanya kapacitása: ").append(getMaxPopulation()).append("\n");
        sb.append("Belefér? ").append(isPopulationWithinLimit() ? "Igen ✅" : "Nem ❌");

        if (area != null) {
            area.setText(sb.toString());
        } else {
            System.out.println(sb);
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    static class Unit {
        private String name;
        private int count;
        private int populationCost;

        public Unit(String name, int count, int populationCost) {
            this.name = name;
            this.count = count;
            this.populationCost = populationCost;
        }

        public int getTotalPopulationCost() {
            return count * populationCost;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }

        public int getPopulationCost() {
            return populationCost;
        }
    }
}
