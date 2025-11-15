package org.example.entity;

import org.example.enums.MissionStatusEnum;
import java.util.ArrayList;
import java.util.List;

public class Mission {
  private MissionStatusEnum missionStatusEnum;
  private List<Rocket> rocketList;

  public Mission(MissionStatusEnum missionStatusEnum) {
    this.missionStatusEnum = missionStatusEnum;
    this.rocketList = new ArrayList<>();
  }

  public MissionStatusEnum getMissionStatusEnum() {
    return this.missionStatusEnum;
  }

  public void setMissionStatusEnum(MissionStatusEnum missionStatusEnum) {
    this.missionStatusEnum = missionStatusEnum;
  }

  public List<Rocket> getRockets() {
    return this.rocketList;
  }

  public void setRockets(List<Rocket> rocketList) {
    this.rocketList = rocketList;
  }
}
