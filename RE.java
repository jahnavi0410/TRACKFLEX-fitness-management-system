

import java.util.Date;

public class RE {
    private  int userID;
    private Date date;
    private int totalWaterIntake;
    private int totalCaloriesConsumed;
    private String foodTypesConsumed;
    private String workoutTypes;
    private int totalWorkoutDuration;
    private int totalCaloriesBurnt;

    // Constructors (you can generate these using your IDE)
    public RE() {
    }

    public RE(int userID, Date date, int totalWaterIntake, int totalCaloriesConsumed,
              String foodTypesConsumed, String workoutTypes, int totalWorkoutDuration, int totalCaloriesBurnt) {
        this.userID = userID;
        this.date = date;
        this.totalWaterIntake = totalWaterIntake;
        this.totalCaloriesConsumed = totalCaloriesConsumed;
        this.foodTypesConsumed = foodTypesConsumed;
        this.workoutTypes = workoutTypes;
        this.totalWorkoutDuration = totalWorkoutDuration;
        this.totalCaloriesBurnt = totalCaloriesBurnt;
    }

    // Getters and setters (you can generate these using your IDE)
    public  int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalWaterIntake() {
        return totalWaterIntake;
    }

    public void setTotalWaterIntake(int totalWaterIntake) {
        this.totalWaterIntake = totalWaterIntake;
    }

    public int getTotalCaloriesConsumed() {
        return totalCaloriesConsumed;
    }

    public void setTotalCaloriesConsumed(int totalCaloriesConsumed) {
        this.totalCaloriesConsumed = totalCaloriesConsumed;
    }

    public String getFoodTypesConsumed() {
        return foodTypesConsumed;
    }

    public void setFoodTypesConsumed(String foodTypesConsumed) {
        this.foodTypesConsumed = foodTypesConsumed;
    }

    public String getWorkoutTypes() {
        return workoutTypes;
    }

    public void setWorkoutTypes(String workoutTypes) {
        this.workoutTypes = workoutTypes;
    }

    public int getTotalWorkoutDuration() {
        return totalWorkoutDuration;
    }

    public void setTotalWorkoutDuration(int totalWorkoutDuration) {
        this.totalWorkoutDuration = totalWorkoutDuration;
    }

    public int getTotalCaloriesBurnt() {
        return totalCaloriesBurnt;
    }

    public void setTotalCaloriesBurnt(int totalCaloriesBurnt) {
        this.totalCaloriesBurnt = totalCaloriesBurnt;
    }
}
