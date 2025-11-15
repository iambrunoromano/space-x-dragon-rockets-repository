package org.example.entity;

import org.example.enums.MissionStatusEnum;
import java.util.ArrayList;
import java.util.Collections;
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
    return Collections.unmodifiableList(this.rocketList); // Gemini suggested this
  }

  public void setRockets(List<Rocket> rocketList) {
    // Gemini suggested this
    if (rocketList != null) {
      this.rocketList = new ArrayList<>(rocketList);
    } else {
      this.rocketList = new ArrayList<>();
    }
  }

  public void addRockets(List<Rocket> rocketList) {
    // Gemini suggested this
    if (rocketList != null && !rocketList.isEmpty()) {
      this.rocketList.addAll(rocketList);
    }
  }
}
