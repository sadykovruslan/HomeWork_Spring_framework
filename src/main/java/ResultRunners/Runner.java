package ResultRunners;

public class Runner {
   private String name;
    Gender gender;
    Distance distance;
   private int time;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

//   public Gender getGender() {
//      return gender;
//   }
//
//   public void setGender(Gender gender) {
//      this.gender = gender;
//   }
//
//   public Distance getDistance() {
//      return distance;
//   }
//
//   public void setDistance(Distance distance) {
//      this.distance = distance;
//   }

   public int getTime() {
      return time;
   }

   public void setTime(int time) {
      this.time = time;
   }

   @Override
   public String toString() {
      return "Runner{" +
              "name='" + name + '\'' +
              ", time=" + time +
              '}';
   }
}
