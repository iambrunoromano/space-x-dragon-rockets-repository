package java.org.example.entity;

import java.org.example.enums.RocketStatusEnum;

public class Rocket {
  private RocketStatusEnum rocketStatusEnum;

  public Rocket(RocketStatusEnum rocketStatusEnum) {
    this.rocketStatusEnum = rocketStatusEnum;
  }

  public RocketStatusEnum getRocketStatusEnum() {
    return rocketStatusEnum;
  }

  public void setRocketStatusEnum(RocketStatusEnum rocketStatusEnum) {
    this.rocketStatusEnum = rocketStatusEnum;
  }
}
