public class FantasyCalculator {
    private static final double POINTS_PER_POINT = 0.5;
    private static final double POINTS_PER_REBOUND = 1.0;
    private static final double POINTS_PER_ASSIST = 1.0;
    private static final double POINTS_PER_STEAL = 2.0;
    private static final double POINTS_PER_BLOCK = 2.0;
    private static final double POINTS_PER_TURNOVER = -1.0;
    private static final double POINTS_PER_DOUBLE_DOUBLE = 1.0;
    private static final double POINTS_PER_TRIPLE_DOUBLE = 1.0;
    private static final double POINTS_PER_THREE_POINTER = 0.5; 
    private static final double POINTS_PER_40_POINT_BONUS = 2.0;
    private static final double POINTS_PER_15_ASSIST_BONUS = 1.0;
    private static final double POINTS_PER_20_REBOUND_BONUS = 2.0;

    public static double calculateFantasyPoints(double pts, double reb, double ast, double stl, double blk, double to, 
                                                 boolean doubleDouble, boolean tripleDouble, int threePointersMade, 
                                                 boolean fortyPointBonus, boolean fifteenAssistBonus, boolean twentyReboundBonus) {
        double points = pts * POINTS_PER_POINT;
        double rebounds = reb * POINTS_PER_REBOUND;
        double assists = ast * POINTS_PER_ASSIST;
        double steals = stl * POINTS_PER_STEAL;
        double blocks = blk * POINTS_PER_BLOCK;
        double turnovers = to * POINTS_PER_TURNOVER;

        double bonuses = 0;

        // dis for bonuses
        if (doubleDouble) {
            bonuses += POINTS_PER_DOUBLE_DOUBLE;
        }
        if (tripleDouble) {
            bonuses += POINTS_PER_TRIPLE_DOUBLE;
        }
        bonuses += threePointersMade * POINTS_PER_THREE_POINTER;

        if (fortyPointBonus && pts >= 40) {
            bonuses += POINTS_PER_40_POINT_BONUS;
        }
        if (fifteenAssistBonus && ast >= 15) {
            bonuses += POINTS_PER_15_ASSIST_BONUS;
        }
        if (twentyReboundBonus && reb >= 20) {
            bonuses += POINTS_PER_20_REBOUND_BONUS;
        }

        return points + rebounds + assists + steals + blocks + turnovers + bonuses;
    }

    public static void main(String[] args) {
        // example 4 now
        double pts = 25;
        double reb = 10;
        double ast = 7;
        double stl = 2;
        double blk = 1;
        double to = 3;

        // bonus stuff
        boolean doubleDouble = false; // Change based on actual stats
        boolean tripleDouble = false;  // Change based on actual stats
        int threePointersMade = 3;     // Change based on actual stats
        boolean fortyPointBonus = false; // Change based on actual stats
        boolean fifteenAssistBonus = false; // Change based on actual stats
        boolean twentyReboundBonus = false; // Change based on actual stats

        double fantasyPoints = calculateFantasyPoints(pts, reb, ast, stl, blk, to, doubleDouble, tripleDouble, threePointersMade, fortyPointBonus, fifteenAssistBonus, twentyReboundBonus);
        System.out.println("Fantasy Points: " + fantasyPoints);
    }
}
