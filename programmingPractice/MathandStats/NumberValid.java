package MathandStats;

/**
 * Created by Anna on 6/3/17.
 * An enum type is a special data type that enables for a variable to be a set of predefined constants.
 * The variable must be equal to one of the values that have been predefined for it.
 * Common examples include compass directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week.
 */
public class NumberValid {

    enum STATE { START, INTEGER, DECIMAL, UNKNOWN};

    static STATE get_next_state(STATE current_state, char ch) {
        switch(current_state) {
            case START:
            case INTEGER:
                if (ch == '.') {
                    return STATE.DECIMAL;
                } else if (ch >= '0' && ch <= '9') {
                    return STATE.INTEGER;
                } else {
                    return STATE.UNKNOWN;
                }
            case DECIMAL:
                if (ch >= '0' && ch <= '9') {
                    return STATE.DECIMAL;
                }
                else {
                    return STATE.UNKNOWN;
                }
        }
        return STATE.UNKNOWN;
    }

    static boolean is_number_valid(String s) {

        if (s.isEmpty()) {
            return true;
        }
        int i = 0;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            ++i;
        }

        STATE current_state = STATE.START;

        while (i < s.length()) {

            current_state = get_next_state(current_state, s.charAt(i));

            if (current_state == STATE.UNKNOWN) {
                return false;
            }

            i = i + 1;
        }
        return true;
    }

    public static void main(String[] args){

      String s = "1.1";
      System.out.println(is_number_valid(s));

    }

}
