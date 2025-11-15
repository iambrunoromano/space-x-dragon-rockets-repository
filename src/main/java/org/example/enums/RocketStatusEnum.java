package java.org.example.enums;

public enum RocketStatusEnum {
  ON_GROUND("On Ground"),
  IN_SPACE("In Space"),
  IN_REPAIR("In Repair");

  private String value;

  RocketStatusEnum(String value) {
    this.value = value;
  }
}
