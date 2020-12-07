package fivefishes.design.patterns.group.assignment.enumerations.decorator;

public enum HouseImage {
  DefaultHouse("src/main/java/fivefishes/design/patterns/group/assignment/resources/decorator/house.png"),
  LanternsDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/decorator/lanternsdecorator.png"),
  CandlesDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/decorator/candlesdecorator.png"),
  FlagsDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/decorator/flagsdecorator.png"),
  FireworkDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/decorator/fireworkdecorator.png");

  private final String imageUrl;

  HouseImage(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
