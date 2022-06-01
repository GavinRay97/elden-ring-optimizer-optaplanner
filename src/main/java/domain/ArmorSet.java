package domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.Objects;

@PlanningEntity
public final class ArmorSet {

    @PlanningId
    private Long id;

    @PlanningVariable(valueRangeProviderRefs = "headRange")
    private ArmorPiece head;

    @PlanningVariable(valueRangeProviderRefs = "chestRange")
    private ArmorPiece chest;

    @PlanningVariable(valueRangeProviderRefs = "armsRange")
    private ArmorPiece arms;

    @PlanningVariable(valueRangeProviderRefs = "legsRange")
    private ArmorPiece legs;

    public ArmorSet(Long id, ArmorPiece head, ArmorPiece chest, ArmorPiece arms, ArmorPiece legs) {
        this.id = id;
        this.head = head;
        this.chest = chest;
        this.arms = arms;
        this.legs = legs;
    }

    public Integer getTotalWeight() {
        return head.weight() + chest.weight() + arms.weight() + legs.weight();
    }

    public Integer getTotalPoise() {
        return head.poise() + chest.poise() + arms.poise() + legs.poise();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArmorPiece getHead() {
        return head;
    }

    public void setHead(ArmorPiece head) {
        this.head = head;
    }

    public ArmorPiece getChest() {
        return chest;
    }

    public void setChest(ArmorPiece chest) {
        this.chest = chest;
    }

    public ArmorPiece getArms() {
        return arms;
    }

    public void setArms(ArmorPiece arms) {
        this.arms = arms;
    }

    public ArmorPiece getLegs() {
        return legs;
    }

    public void setLegs(ArmorPiece legs) {
        this.legs = legs;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ArmorSet) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.head, that.head) &&
               Objects.equals(this.chest, that.chest) &&
               Objects.equals(this.arms, that.arms) &&
               Objects.equals(this.legs, that.legs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, head, chest, arms, legs);
    }

    @Override
    public String toString() {
        return "ArmorSet[" +
               "id=" + id + ", " +
               "head=" + head + ", " +
               "chest=" + chest + ", " +
               "arms=" + arms + ", " +
               "legs=" + legs + ']';
    }

}
