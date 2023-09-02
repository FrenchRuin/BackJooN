import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";

        LocalDate date = LocalDate.of(2016, a, b);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        int dd = dayOfWeek.getValue();

        switch (dd) {
            case 1:
                answer = "MON";
                break;
            case 2:
                answer = "TUE";
                break;
            case 3:
                answer = "WED";
                break;
            case 4:
                answer = "THU";
                break;
            case 5:
                answer = "FRI";
                break;
            case 6:
                answer = "SAT";
                break;
            default:
                answer = "SUN";
                break;
        }
        return answer;
    }
}