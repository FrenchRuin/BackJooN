import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {

        List<Integer> tempList = new ArrayList<>();

        String todays = today.replaceAll("\\.", "");

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = transFormat.parse(todays);

        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        Calendar c2 = Calendar.getInstance();

        for (int i = 0; i < privacies.length; i++) {
            String target = privacies[i];
            String[] targetArr = target.split(" ");
            String prDate = targetArr[0].replaceAll("\\.", "");

            Date tD = transFormat.parse(prDate);
            c2.setTime(tD);

            for (int j = 0; j < terms.length; j++) {
                String[] termsArr = terms[j].split(" ");

                if (targetArr[1].equals(termsArr[0])) {
                    c2.add(Calendar.MONTH, Integer.parseInt(termsArr[1]));
                    if (c1.compareTo(c2) >= 0) {
                        tempList.add(i + 1);
                    }
                }
            }
        }

        int[] answer = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            answer[i] = tempList.get(i);
        }
        return answer;
    }
}