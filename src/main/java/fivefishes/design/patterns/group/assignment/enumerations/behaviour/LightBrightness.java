package fivefishes.design.patterns.group.assignment.enumerations.behaviour;

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
