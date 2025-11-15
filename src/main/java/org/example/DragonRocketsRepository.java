package java.org.example;

import java.org.example.entity.Mission;
import java.org.example.entity.Rocket;
import java.org.example.enums.MissionStatusEnum;
import java.org.example.enums.RocketStatusEnum;
import java.util.List;

public class DragonRocketsRepository {

  public static Rocket addNewRocket() {
    // TODO: write impl
    return new Rocket(null);
  }

  public static Mission assignRocketToMission(Rocket rocket, Mission mission) {
    // TODO: write impl
    return new Mission(null);
  }

  public static Rocket changeRocketStatusTo(Rocket rocket, RocketStatusEnum rocketStatusEnum) {
    // TODO: write impl
    return new Rocket(null);
  }

  public static Mission addNewMission() {
    // TODO: write impl
    return new Mission(null);
  }

  public static Mission assignRocketsToMission(List<Rocket> rocketList, Mission mission) {
    // TODO: write impl
    return new Mission(null);
  }

  public static Mission changeMissionStatusTo(
      Mission mission, MissionStatusEnum missionstatusEnum) {
    // TODO: write impl
    return new Mission(null);
  }

  public static List<Mission> getSummary() {
    // TODO: write impl
    return List.of();
  }
}
