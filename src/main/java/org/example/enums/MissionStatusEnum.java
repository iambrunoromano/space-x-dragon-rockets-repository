package java.org.example.enums;

public enum MissionStatusEnum {
  SCHEDULED("Scheduled"),
  PENDING("Pending"),
  IN_PROGRESS("In Progress"),
  ENDED("Ended");

  private String value;

  MissionStatusEnum(String value) {
    this.value = value;
  }
}
