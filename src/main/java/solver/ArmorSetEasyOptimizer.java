package solver;

import domain.ArmorSet;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

/**
 * SCORING DOES NOT WORK CURRENTLY
 *
 * Calculate score by optimizing for the following criteria:
 * - Poise
 * - Physical Defense
 *
 * Minimize:
 * - Weight
 */
public class ArmorSetEasyOptimizer implements EasyScoreCalculator<ArmorSetComboPlanningSolution, HardSoftScore> {

    private int targetPoise;
    private int maxWeight;

    public ArmorSetEasyOptimizer() {
    }

    public ArmorSetEasyOptimizer(int targetPoise, int maxWeight) {
        this.targetPoise = targetPoise;
        this.maxWeight = maxWeight;
    }

    @Override
    public HardSoftScore calculateScore(ArmorSetComboPlanningSolution solution) {
        int hardScore = 0;
        int softScore = 0;

        for (ArmorSet a : solution.armorSets) {
            for (ArmorSet b : solution.armorSets) {
                if (a != b) {
                    if (a.getTotalPoise() < targetPoise) {
                        hardScore--;
                    }
                    if (b.getTotalPoise() < targetPoise) {
                        hardScore--;
                    }
                    if (a.getTotalPoise() > b.getTotalPoise()) {
                        softScore--;
                    }
                }
            }
        }

        return HardSoftScore.of(hardScore, softScore);
    }
}
