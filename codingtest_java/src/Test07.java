import java.util.HashSet;

/*
문제 07
 */


public class Test07 {

    private static boolean positionChange(HashSet<String> hs, int xPos, int yPos) {
        String pos = ""+xPos+yPos;

        for (String h : hs) {
            if(h.equals(pos)) {
                hs.add(pos);
                return true;
            }
        }
        hs.add(pos);
        return false;
    }

    public static int solution(String path) {

        boolean check = false;

        int xValue;
        int yValue;

        HashSet<String> position = new HashSet<>();

        //초기값
        xValue= 5;
        yValue= 5;
        position.add(""+xValue+yValue);

        for(int i = 0; i<path.length(); i++) {
            switch(path.charAt(i)) {
                case 'U':
                    if(yValue == 10) continue;
                    yValue++;
                    check = positionChange(position,xValue,yValue);
                    break;
                case 'D':
                    if(yValue == 0) continue;
                    yValue--;
                    check = positionChange(position,xValue,yValue);
                    break;
                case 'L':
                    if(xValue==0) continue;
                    xValue--;
                    check = positionChange(position,xValue,yValue);
                    break;
                case 'R':
                    if(xValue==10) continue;
                    xValue++;
                    check = positionChange(position,xValue,yValue);
                    break;
            }
        }

        int result = position.size();

        if(!check) {
            result -=1;
        }
        check = false;
        return result;
    }

    public static void main(String[] args) {
        int result;

        String str = "ULURRDLLU";
        result = solution(str);
        System.out.println(result);

        String str02 = "LULLLLLLU";
        result = solution(str02);
        System.out.println(result);
    }
}
