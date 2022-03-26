package Algorithms.TopMicrosoftAskedQuestionsLeetCode;

public class AngleBetHandsOfAClock {

    /**Hour Hand
In 12 hours Hour hand complete whole circle and cover 360°
So, 1 hour = 360° / 12 = 30°

Since 1 hours = 30°
In 1 minute, hours hand rotate -> 30° / 60 = 0.5°
So total angle because of minutes by hour hand is minutes/60 * 30 or minutes * 0.5

Minute Hand
In 60 minutes Minute Hand completes whole circle and cover 360°.
So, 1 minute -> 360° / 60 = 6° */

    public double angleClock(int hour, int minutes) {
        
        // Degree covered by hour hand (hour area + minutes area)
       double h = (hour%12 * 30) + ((double)minutes/60 * 30);
       
        // Degree covered by minute hand (Each minute = 6 degree)
       double m = minutes * 6;
       
        // Absolute angle between them
       double angle = Math.abs(m - h);
       
        // If the angle is obtuse (>180), convert it to acute (0<=x<=180)
       if (angle > 180) angle = 360.0 - angle;
       
       return angle;
   }
    public static void main(String[] args) {
        
    }
    
}
