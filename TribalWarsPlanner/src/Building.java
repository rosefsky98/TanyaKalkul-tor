public class Building {

    private String name;
    private int level;

    // ===== FŐHADISZÁLLÁS =====
    private static final int[] hqPopulationPerLevel = {
            0,  // 0
            5, 1, 1, 1, 1,     // 1–5
            2, 2, 2, 3, 3,     // 6–10
            4, 5, 6, 7, 8,     // 11–15
            9, 10, 11, 12, 13, // 16–20
            14, 15, 16, 17, 18,// 21–25
            19, 20, 21, 22, 23 // 26–30
    };

    // ===== AGYAGBÁNYA =====
    private static final int[] clayPitPopulationPerLevel = {
            0,   // 0
            10, 1, 2, 2, 2,      // 1–5
            3, 3, 3, 4, 4,       // 6–10
            5, 5, 6, 7, 8,       // 11–15
            8, 10, 12, 13, 16,   // 16–20
            16, 20, 22, 25, 28,  // 21–25
            28, 32, 37, 42, 48   // 26–30
    };

    // ===== FATELEP =====
    private static final int[] sawMillPopulationPerLevel = {
            0,   // 0
            5, 1, 1, 1, 1,       // 1–5
            1, 2, 2, 2, 2,       // 6–10
            3, 3, 4, 5, 5,       // 11–15
            5, 7, 8, 9, 10,      // 16–20
            12, 14, 16, 19, 21,  // 21–25
            24, 29, 33, 38, 43   // 26–30
    };

    // ==== VASBÁNYA ====
    private static final int[] ironPitPopulationPerLevel = {
            0, // 0
            10, 2, 2, 2, 3,         // 1-5
            3, 4, 4, 5, 6,          // 6-10
            7, 8, 10, 11, 13,       // 11-15
            15, 18, 21, 25, 28,     // 16-20
            34, 39, 46, 54, 63,     // 21-25
            74, 86, 100, 118, 138   // 26-30

    };

    // ===== BARAKK =====
    private static final int[] barracksPopulationPerLevel = {
            0,  // 0. szint
            7, 1, 2, 1, 2,        // 1–5
            2, 3, 3, 4, 4,        // 6–10
            5, 5, 7, 8, 9,        // 11–15
            9, 11, 12, 15, 17,    // 16–20
            20, 24, 27, 32, 38, 44 // 21–25
    };

    // ===== ISTÁLLÓ =====
    private static final int[] stablePopulationPerLevel = {
            0,  // 0
            8, 1, 2, 2, 2,         // 1–5
            3, 3, 3, 4, 5,         // 6–10
            5, 6, 7, 7, 8,         // 11–15
            8, 9, 10, 11, 12, 13   // 16–20
    };

    // ===== MŰHELY =====
    private static final int[] workshopPopulationPerLevel = {
            0,  // 0
            8, 1, 2, 2, 2,        // 1–5
            3, 3, 3, 4, 5,        // 6–10
            5, 6, 7, 8, 9, 10     // 11–15
    };

    // ===== KOVÁCSMŰHELY =====
    private static final int[] smithyPopulationPerLevel = {
            0,  // 0
            20, 3, 4, 5, 5,         // 1–5
            7, 7, 8, 9, 11,         // 6–10
            13, 14, 17, 19, 22,     // 11–15
            26, 31, 36, 42, 57      // 16–20
    };

    // ===== PIAC =====
    private static final int[] marketPopulationPerLevel = {
            0,  // 0
            20, 3, 4, 5, 5,         // 1–5
            7, 7, 9, 10, 12,        // 6–10
            14, 16, 20, 22, 26,     // 11–15
            31, 36, 42, 49, 57,     // 16–20
            67, 79, 92, 107, 126    // 21–25
    };

    // ===== AKADÉMIA =====
    private static final int[] academyPopulationPerLevel = {
            0,   // 0
            80, 14, 16  // 1–3
    };

    // ===== FAL =====
    private static final int[] wallPopulationPerLevel = {
            0,  // 0
            5, 1, 1, 1, 1,         // 1–5
            2, 2, 2, 2, 3,         // 6–10
            3, 4, 5, 5, 6,         // 11–15
            6, 7, 8, 10, 15        // 16–20
    };

    // ===== ŐRTORONY =====
    private static final int[] watchtowerPopulationPerLevel = {
            0,    // 0
            500, 90, 106, 120, 147,     // 1–5
            175, 206, 243, 286, 339,    // 6–10
            399, 471, 556, 656, 774,    // 11–15
            905, 1_078, 1_275, 1_501, 1_770 // 16–20
    };

    // ===== REJTEKHELY =====
    private static final int[] hideoutPopulationPerLevel = {
            0,  // 0
            2, 0, 1, 0, 1,   // 1–5
            1, 1, 1, 1, 1    // 6–10
    };

    // ===== SZOBOR =====
    private static final int[] statuePopulationPerLevel = {
            0,  // 0
            10  // 1
    };

    // ===== TEMPLOM (max 3) =====
    private static final int[] templePopulationPerLevel = {
            0,                 // 0
            5000, 2750, 4263   // 1-3
    };

    // ===== ELSŐ TEMPLOM =====
    private static final int[] firstTemplePopulationPerLevel = {
            0,  // 0. szint
            5   // 1. szint
    };

    // ===== TANYA !!! kapacitás !!! =====
    private static final int[] farmCapacityPerLevel = {
            0,    // 0. szint
            240, 281, 329, 386, 452,     // 1–5
            530, 622, 729, 854, 1002,    // 6–10
            1174, 1376, 1613, 1891, 2216, // 11–15
            2598, 3045, 3569, 4183, 4904, // 16–20
            5748, 6737, 7896, 9255, 10843, // 21–25
            12715, 14904, 17469, 20476, 24000 // 26–30
    };

    public static int getFarmCapacity(int level) {
        return level >= 0 && level < farmCapacityPerLevel.length
                ? farmCapacityPerLevel[level]
                : 0;
    }

    // ===== Konstruktor =====
    public Building(String name, int level) {
        this.name = name;
        this.level = level;
    }

    // ===== Getterek =====
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    // ===== Tanyahely számítás =====
    public int getPopulationCost() {
        if (name.equalsIgnoreCase("főhadiszállás")) {
            return sumPopulation(level, hqPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("agyagbánya")) {
            return sumPopulation(level, clayPitPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("fatelep")) {
            return sumPopulation(level, sawMillPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("vasbánya")) {
            return sumPopulation(level, ironPitPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("barakk")) {
            return sumPopulation(level, barracksPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("istálló")) {
            return sumPopulation(level, stablePopulationPerLevel);
        }

        if (name.equalsIgnoreCase("gyülekezőhely")) {
            return 0;
        }

        if (name.equalsIgnoreCase("műhely")) {
            return sumPopulation(level, workshopPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("kovácsműhely")) {
            return sumPopulation(level, smithyPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("piac")) {
            return sumPopulation(level, marketPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("akadémia")) {
            return sumPopulation(level, academyPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("fal")) {
            return sumPopulation(level, wallPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("őrtorony")) {
            return sumPopulation(level, watchtowerPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("raktár")) {
            return 0;
        }

        if (name.equalsIgnoreCase("rejtekhely")) {
            return sumPopulation(level, hideoutPopulationPerLevel);
        }

        if (name.equalsIgnoreCase("szobor")) {
            return sumPopulation(level, statuePopulationPerLevel);
        }

        if (name.equalsIgnoreCase("templom")) {
            return sumPopulation(level, templePopulationPerLevel);
        }

        if (name.equalsIgnoreCase("első templom")) {
            return sumPopulation(level, firstTemplePopulationPerLevel);
        }

        if (name.equalsIgnoreCase("tanya")) {
            return 0; // Nem foglal tanyahelyet!
        }

        return 0; // ismeretlen épület
    }

    public static String[] getSupportedBuildingNames() {
        return new String[] {
                "főhadiszállás",
                "agyagbánya",
                "fatelep",
                "vasbánya",
                "barakk",
                "istálló",
                "műhely",
                "kovácsműhely",
                "piac",
                "akadémia",
                "templom",
                "első templom",
                "szobor",
                "rejtekhely",
                "őrtorony",
                "fal",             // <<< EZ az új sor
                "gyülekezőhely",
                "raktár",
                "tanya"
        };
    }

    // ===== Közös összegző metódus =====
    private int sumPopulation(int level, int[] populationArray) {
        int sum = 0;
        for (int i = 1; i <= level && i < populationArray.length; i++) {
            sum += populationArray[i];
        }
        return sum;
    }
}
