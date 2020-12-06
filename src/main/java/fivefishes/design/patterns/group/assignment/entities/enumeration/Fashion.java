package fivefishes.design.patterns.group.assignment.entities.enumeration;

public enum Fashion {
    White("src/main/java/fivefishes/design/patterns/group/assignment/resources/ChangEr/white.png"),
    Red("src/main/java/fivefishes/design/patterns/group/assignment/resources/ChangEr/red.png"),
    Pink("src/main/java/fivefishes/design/patterns/group/assignment/resources/ChangEr/pink.png"),
    Orange("src/main/java/fivefishes/design/patterns/group/assignment/resources/ChangEr/orange.png");

    private final String imageUrl;

    Fashion(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
