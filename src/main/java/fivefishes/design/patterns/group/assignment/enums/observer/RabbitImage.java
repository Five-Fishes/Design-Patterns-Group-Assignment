package fivefishes.design.patterns.group.assignment.enums.observer;

public enum RabbitImage {
    Dancing("src/main/java/fivefishes/design/patterns/group/assignment/resources/observer/rabbit1.gif"),
    Singing("src/main/java/fivefishes/design/patterns/group/assignment/resources/observer/rabbit2.gif");

    private final String imageUrl;

    RabbitImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}