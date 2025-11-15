package java.org.example.entity;

import java.org.example.enums.RocketStatusEnum;

public class Rocket {
  private RocketStatusEnum rocketStatusEnum;
  private Mission mission;

  public Rocket(RocketStatusEnum rocketStatusEnum) {
    this.rocketStatusEnum = rocketStatusEnum;
  }

  public RocketStatusEnum getRocketStatusEnum() {
    return this.rocketStatusEnum;
  }

  public void setRocketStatusEnum(RocketStatusEnum rocketStatusEnum) {
    this.rocketStatusEnum = rocketStatusEnum;
  }

  public Mission getMission() {
    return this.mission;
  }

  public void setMission(Mission mission) {
    this.mission = mission;
  }
}
