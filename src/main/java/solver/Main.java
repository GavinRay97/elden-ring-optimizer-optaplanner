package solver;

import domain.ArmorSet;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.SolverConfig;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Main {

    public static void main(String[] args) throws IOException {
        SolverFactory<ArmorSetComboPlanningSolution> solverFactory = SolverFactory.create(
                new SolverConfig()
                        .withSolutionClass(ArmorSetComboPlanningSolution.class)
                        .withEntityClasses(ArmorSet.class)
                        .withEasyScoreCalculatorClass(ArmorSetEasyOptimizer.class)
                        .withTerminationSpentLimit(Duration.ofSeconds(10)));

        // Load the data
        File file = new File("src/main/resources/armor.json");
        ArmorSetComboPlanningSolution armorSetCombo = ArmorSetComboPlanningSolution.loadFromJSONFile(file);

        // Solve the problem
        var solver = solverFactory.buildSolver();
        var solution = solver.solve(armorSetCombo);

        // Print the solution
        System.out.println(solution.score);
        System.out.println(solution.armorSets);
    }
}
