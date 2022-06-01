package solver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ArmorPiece;
import domain.ArmorSet;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@PlanningSolution
public class ArmorSetComboPlanningSolution {

    public List<ArmorPiece> armorPieces;
    public Map<Integer, List<ArmorPiece>> armorByType;

    @ValueRangeProvider(id = "headRange")
    @ProblemFactCollectionProperty
    public List<ArmorPiece> headList;

    @ValueRangeProvider(id = "chestRange")
    @ProblemFactCollectionProperty
    public List<ArmorPiece> chestList;

    @ValueRangeProvider(id = "armsRange")
    @ProblemFactCollectionProperty
    public List<ArmorPiece> armsList;

    @ValueRangeProvider(id = "legsRange")
    @ProblemFactCollectionProperty
    public List<ArmorPiece> legsList;

    @PlanningEntityCollectionProperty
    public List<ArmorSet> armorSets = new ArrayList<>();

    @PlanningScore
    HardSoftScore score;

    ArmorSetComboPlanningSolution() {
    }

    ArmorSetComboPlanningSolution(List<ArmorPiece> armorPieces) {
        this.armorPieces = armorPieces;
        this.armorByType = armorPieces.stream().collect(groupingBy(ArmorPiece::armorCategoryID));
        this.headList = armorByType.get(0);
        this.chestList = armorByType.get(1);
        this.armsList = armorByType.get(2);
        this.legsList = armorByType.get(3);
    }

    public static ArmorSetComboPlanningSolution loadFromJSONFile(File file) throws IOException {
        List<ArmorPiece> armors = new ObjectMapper().readValue(file, new TypeReference<List<ArmorPiece>>() {});
        return new ArmorSetComboPlanningSolution(armors);
    }
}


