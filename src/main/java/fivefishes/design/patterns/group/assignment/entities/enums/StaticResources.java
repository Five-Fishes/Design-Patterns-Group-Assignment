package fivefishes.design.patterns.group.assignment.entities.enums;

public enum StaticResources {
  DefaultHouse("src/main/java/fivefishes/design/patterns/group/assignment/resources/house.png"),
  LanternsDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/lanternsdecorator.png"),
  CandlesDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/candlesdecorator.png"),
  FlagsDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/flagsdecorator.png"),
  FireworkDecorator("src/main/java/fivefishes/design/patterns/group/assignment/resources/fireworkdecorator.png");
 
  public final String label;

  private StaticResources(String label) {
      this.label = label;
  }
}
