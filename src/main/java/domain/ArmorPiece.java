package domain;

public record ArmorPiece (
        String name,
        Integer itemID,
        Integer sortID,
        Integer setID,
        Integer armorID,
        Integer armorCategoryID,
        Integer sortGroupID,
        Integer slotType,
        Integer weight,
        Integer poise,
        Double physical,
        Double strike,
        Double slash,
        Double pierce,
        Double magic,
        Double fire,
        Double lightning,
        Double holy,
        Integer immunity,
        Integer robustness,
        Integer focus,
        Integer vitality
) {

}
