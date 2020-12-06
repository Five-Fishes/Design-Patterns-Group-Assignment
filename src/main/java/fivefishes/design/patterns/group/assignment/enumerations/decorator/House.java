package fivefishes.design.patterns.group.assignment.enumerations.decorator;

public enum House {
  DefaultHouse("src/main/java/fivefishes/design/patterns/group/assignment/resources/house.png"),
  LanternsDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/lanternsdecorator.png"),
  CandlesDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/candlesdecorator.png"),
  FlagsDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/flagsdecorator.png"),
  FireworkDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/fireworkdecorator.png");

  private final String imageUrl;

  House(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
