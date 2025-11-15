package org.example;

import org.example.entity.Mission;
import org.example.entity.Rocket;
import org.example.enums.MissionStatusEnum;
import org.example.enums.RocketStatusEnum;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DragonRocketsRepository {

  // I chosed to use hashmaps because in this way I can search for a rocket or mission fast by the
  // hashcode of the object, instead of traversing a list
  private static HashMap<Integer, Rocket> rockets = new HashMap();
  private static HashMap<Integer, Mission> missions = new HashMap();

  public static Rocket addNewRocket() {
    Rocket newRocket = new Rocket(RocketStatusEnum.ON_GROUND);
    rockets.put(newRocket.hashCode(), newRocket);
    return newRocket;
  }

  public static Mission assignRocketToMission(Rocket rocket, Mission mission) throws Exception {
    Rocket rocketCopy = rockets.get(rocket.hashCode());
    Mission missionCopy = missions.get(mission.hashCode());
    if (rocketCopy != null && missionCopy != null) {
      rocketCopy.setMission(missionCopy);
      rocketCopy.setRocketStatusEnum(RocketStatusEnum.IN_SPACE);
      List<Rocket> missionCopyRockets = missionCopy.getRockets();
      missionCopyRockets.add(rocket);
      if (RocketStatusEnum.IN_REPAIR.equals(rocket.getRocketStatusEnum())) {
        missionCopy.setMissionStatusEnum(MissionStatusEnum.PENDING);
      } else {
        missionCopy.setMissionStatusEnum(MissionStatusEnum.IN_PROGRESS);
      }
      missionCopy.setRockets(missionCopyRockets);
      rockets.put(rocket.hashCode(), rocketCopy);
      missions.put(missionCopy.hashCode(), missionCopy);
      mission = missionCopy;
    } else {
      // I assumed in this case that if the rocket is constructed and passed from outside I force
      // the use of the addNewRocket() method
      throw new Exception(
          "Please use addNewRocket to create rockets and addNewMission to create missions");
    }
    return mission;
  }

  public static Rocket changeRocketStatusTo(Rocket rocket, RocketStatusEnum rocketStatusEnum)
      throws Exception {
    Rocket rocketCopy = rockets.get(rocket.hashCode());
    if (rocketCopy == null) {
      throw new Exception("Please use addNewRocket to create rockets");
    }
    if (RocketStatusEnum.IN_REPAIR.equals(rocketStatusEnum)) {
      if (rocket.getMission() == null
          | !MissionStatusEnum.PENDING.equals(rocket.getMission().getMissionStatusEnum())) {
        throw new Exception("You can't set rocket status to repair if mission is not in pending");
      }
    }
    rocketCopy.setRocketStatusEnum(rocketStatusEnum);
    rockets.put(rocketCopy.hashCode(), rocketCopy);
    return rocketCopy;
  }

  public static Mission addNewMission() {
    Mission newMission = new Mission(MissionStatusEnum.SCHEDULED);
    missions.put(newMission.hashCode(), newMission);
    return newMission;
  }

  public static Mission assignRocketsToMission(List<Rocket> rocketList, Mission mission)
      throws Exception {
    List<Rocket> rocketCopyList = new ArrayList<>();
    Boolean rocketInRepair = Boolean.FALSE;
    for (Rocket rocket : rocketList) {
      Rocket rocketCopy = rockets.get(rocket.hashCode());
      if (rocketCopy == null) {
        throw new Exception("Please use addNewRocket to create rockets");
      } else {
        if (RocketStatusEnum.IN_REPAIR.equals(rocketCopy)) {
          rocketInRepair = Boolean.TRUE;
        }
        rocketCopyList.add(rocketCopy);
      }
    }
    Mission missionCopy = missions.get(mission.hashCode());
    if (missionCopy != null) {
      List<Rocket> missionCopyRockets = missionCopy.getRockets();
      missionCopyRockets.addAll(rocketList);
      missionCopy.setRockets(missionCopyRockets);
      if (rocketInRepair) {
        missionCopy.setMissionStatusEnum(MissionStatusEnum.PENDING);
      } else {
        missionCopy.setMissionStatusEnum(MissionStatusEnum.IN_PROGRESS);
      }
      missions.put(missionCopy.hashCode(), missionCopy);
      for (Rocket rocketCopy : rocketCopyList) {
        rocketCopy.setMission(missionCopy);
        rocketCopy.setRocketStatusEnum(RocketStatusEnum.IN_SPACE);
        rockets.put(rocketCopy.hashCode(), rocketCopy);
      }
      mission = missionCopy;
    } else {
      // I assumed in this case that if the rocket is constructed and passed from outside I force
      // the use of the addNewRocket() method
      throw new Exception("Please use addNewMission to create missions");
    }
    return mission;
  }

  public static Mission changeMissionStatusTo(Mission mission, MissionStatusEnum missionstatusEnum)
      throws Exception {
    Mission missionCopy = missions.get(mission.hashCode());
    if (missionCopy == null) {
      throw new Exception("Please use addNewMission to create missions");
    }
    missionCopy.setMissionStatusEnum(missionstatusEnum);
    missions.put(missionCopy.hashCode(), missionCopy);
    return missionCopy;
  }

  public static List<Mission> getSummary() {
    // To return a summary I would prefer to directly instanciate an Heap and push missions there
    // along with the number of the rockets for each one, but I am running should in time therefore
    // I use a list and then sort it out by the number of rockets per mission. It is not the optimal
    // solution because the cost of the sorting (potentially O(logn)), which is repeated by each
    // summary request. A way to optimize it (having more time) is to hold on the side a list of
    // sorted missions hashcodes already sorted and updated on each mission creation/update
    List<Mission> summaryMissionList = new ArrayList<>();
    for (Map.Entry<Integer, Mission> entry : missions.entrySet()) {
      summaryMissionList.add(entry.getValue());
    }
    return summaryMissionList.stream()
        .sorted(Comparator.comparingInt(mission -> mission.getRockets().size()))
        .collect(Collectors.toList()); // Got this from Gemini
  }

  public static void flushAll() {
    rockets = new HashMap();
    missions = new HashMap();
  }
}
