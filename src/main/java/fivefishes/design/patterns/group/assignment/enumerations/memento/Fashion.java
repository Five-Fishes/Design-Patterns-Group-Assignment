package fivefishes.design.patterns.group.assignment.enumerations.memento;

public enum Fashion {
    White("src/main/java/fivefishes/design/patterns/group/assignment/resources/memento/white.png"),
    Red("src/main/java/fivefishes/design/patterns/group/assignment/resources/memento/red.png"),
    Pink("src/main/java/fivefishes/design/patterns/group/assignment/resources/memento/pink.png"),
    Orange("src/main/java/fivefishes/design/patterns/group/assignment/resources/memento/orange.png");

    private final String imageUrl;

    Fashion(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
