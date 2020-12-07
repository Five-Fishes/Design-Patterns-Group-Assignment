package fivefishes.design.patterns.group.assignment.enumerations.strategy;

public enum LightBrightness {

    NoLight("No Light"),
    Dim("Dim"),
    Normal("Normal"),
    Bright("Bright");

    private final String value;

    LightBrightness(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
