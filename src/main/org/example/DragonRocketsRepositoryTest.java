package org.example;

import org.example.entity.Mission;
import org.example.entity.Rocket;
import org.example.enums.MissionStatusEnum;
import org.example.enums.RocketStatusEnum;
import java.util.ArrayList;
import java.util.List;

public class DragonRocketsRepositoryTest {

  public static void addNewRocketTest() throws Exception {
    Rocket actualRocket = DragonRocketsRepository.addNewRocket();
    assertOrThrow(actualRocket.getRocketStatusEnum(), RocketStatusEnum.ON_GROUND, "Add new rocket");
  }

  public static void addNewMissionTest() throws Exception {
    Mission actualMission = DragonRocketsRepository.addNewMission();
    assertOrThrow(
        actualMission.getMissionStatusEnum(), MissionStatusEnum.SCHEDULED, "Add new mission");
  }

  public static void assignRocketToMissionTest_GoodRocket_GoodMission() throws Exception {
    Rocket rocket =
        DragonRocketsRepository
            .addNewRocket(); // In this case if the test for addNewRocket() fails, the current test
    // will not be executed
    Mission mission =
        DragonRocketsRepository
            .addNewMission(); // In this case if the test for addNewRocket() fails, the current test
    // will not be executed
    Mission actualMission = DragonRocketsRepository.assignRocketToMission(rocket, mission);
    Rocket actualRocket =
        rocket; // Rocket should have been edited in mission reference by assignRocketToMission
    assertOrThrow(actualRocket.getMission(), actualMission, "Assign Rocket to Mission");
    assertOrThrow(actualMission.getRockets(), List.of(actualRocket), "Assign Rocket to Mission");
    // TODO: test case with mission with multiple rockets already in place
    // TODO: test mission status change?
  }

  public static void changeRocketStatusToTest() throws Exception {
    Rocket rocket =
        DragonRocketsRepository
            .addNewRocket(); // In this case if the test for addNewRocket() fails, the current test
    // will not be executed
    changeRocketStatusAssert(rocket, RocketStatusEnum.IN_REPAIR);
    changeRocketStatusAssert(rocket, RocketStatusEnum.IN_SPACE);
    changeRocketStatusAssert(rocket, RocketStatusEnum.ON_GROUND);
  }

  private static void changeRocketStatusAssert(Rocket rocket, RocketStatusEnum rocketStatusEnum)
      throws Exception {
    Rocket actualRocket = DragonRocketsRepository.changeRocketStatusTo(rocket, rocketStatusEnum);
    assertOrThrow(actualRocket.getRocketStatusEnum(), rocketStatusEnum, "Change rocket status");
  }

  public static void changeMissionStatusToTest() throws Exception {
    Mission mission =
        DragonRocketsRepository
            .addNewMission(); // In this case if the test for addNewRocket() fails, the current test
    // will not be executed
    changeMissionStatusAssert(mission, MissionStatusEnum.PENDING);
    changeMissionStatusAssert(mission, MissionStatusEnum.IN_PROGRESS);
    changeMissionStatusAssert(mission, MissionStatusEnum.ENDED);
    changeMissionStatusAssert(mission, MissionStatusEnum.SCHEDULED);
  }

  private static void changeMissionStatusAssert(
      Mission mission, MissionStatusEnum missionStatusEnum) throws Exception {
    Mission actualMission =
        DragonRocketsRepository.changeMissionStatusTo(mission, missionStatusEnum);
    assertOrThrow(actualMission.getMissionStatusEnum(), missionStatusEnum, "Change mission status");
  }

  public static void assignRocketsToMissionTest() throws Exception {
    List<Rocket> rocketList = new ArrayList<>();
    rocketList.add(DragonRocketsRepository.addNewRocket());
    rocketList.add(DragonRocketsRepository.addNewRocket());
    rocketList.add(
        DragonRocketsRepository
            .addNewRocket()); // In this case if the test for addNewRocket() fails, the current test
    // will not be executed
    Mission mission =
        DragonRocketsRepository
            .addNewMission(); // In this case if the test for addNewRocket() fails, the current test
    // will not be executed
    Mission actualMission = DragonRocketsRepository.assignRocketsToMission(rocketList, mission);
    List<Rocket> actualRocketList =
        rocketList; // Rocket should have been edited in mission reference by assignRocketToMission
    for (Rocket actualRocket : actualRocketList) {
      assertOrThrow(actualRocket.getMission(), actualMission, "Assign Rockets to Mission");
    }
    assertOrThrow(actualMission.getRockets(), actualRocketList, "Assign Rockets to Mission");
    // TODO: test case with mission with multiple rockets already in place
    // TODO: test mission status change?
  }

  public static void getSummaryTest() throws Exception {
    Mission mission =
        DragonRocketsRepository
            .addNewMission(); // In this case if the test for addNewRocket() fails, the current test
    // will not be executed
    changeMissionStatusAssert(mission, MissionStatusEnum.PENDING);
    changeMissionStatusAssert(mission, MissionStatusEnum.IN_PROGRESS);
    changeMissionStatusAssert(mission, MissionStatusEnum.ENDED);
    changeMissionStatusAssert(mission, MissionStatusEnum.SCHEDULED);
  }

  private static void assertOrThrow(Object actual, Object expected, String testName)
      throws Exception {
    if (actual != expected) {
      String exceptionMessage =
          String.format(
              "[%s test] Failed: actual [%s] - expected [%s]", testName, actual, expected);
      throw new Exception(exceptionMessage);
    }
    System.out.println(
        String.format("[%s test] Passed: actual [%s] - expected [%s]", testName, actual, expected));
  }
}
