package org.example;

public class Main {
  public static void main(String[] args) throws Exception {
    // Runs all tests
    DragonRocketsRepositoryTest.addNewRocketTest();
    DragonRocketsRepositoryTest.addNewMissionTest();
    DragonRocketsRepositoryTest.assignRocketToMissionTest_GoodRocket_GoodMission();
    DragonRocketsRepositoryTest.assignRocketToMissionTest_GoodRocket_GoodMission_Rocketsinplace();
    DragonRocketsRepositoryTest.changeRocketStatusToTest();
    DragonRocketsRepositoryTest.changeMissionStatusToTest();
  }
}
