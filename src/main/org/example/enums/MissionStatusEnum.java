package org.example.enums;

public enum MissionStatusEnum {
  SCHEDULED("Scheduled"),
  PENDING("Pending"),
  IN_PROGRESS("In Progress"),
  ENDED(
      "Ended"); // I point here out how there is no way to make rockets land and therefore end the
                // mission. I saw that the ENDED status should be assigned when the mission has no
                // rocket assigned anymore, but it is out of scope of the library methods to make
                // rockets land and mission end (no methods ddescribed for that).

  private String value;

  MissionStatusEnum(String value) {
    this.value = value;
  }
}
