package java.org.example.entity;

import org.example.enums.MissionStatusEnum;

public class Mission {
  private MissionStatusEnum MissionStatusEnum;

  public Mission(MissionStatusEnum missionStatusEnum) {
    MissionStatusEnum = missionStatusEnum;
  }

  public MissionStatusEnum getMissionStatusEnum() {
    return MissionStatusEnum;
  }

  public void setMissionStatusEnum(MissionStatusEnum missionStatusEnum) {
    MissionStatusEnum = missionStatusEnum;
  }
}
