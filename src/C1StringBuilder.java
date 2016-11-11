/**
 * Created by ziwen on 8/4/16.
 */
public class C1StringBuilder {
    char[] sb;
    int index;

    public C1StringBuilder() {
        sb = new char[1];
        index = 0;
    }

    public C1StringBuilder(String word) {
        int wl = word.length();
        sb = new char[wl];
        for (int i=0; i<wl; i++) {
            sb[i] = word.charAt(i);
        }
        index = wl;
    }

    public void append(String word) {
        for (int i=0; i<word.length(); i++) {
            if (index == sb.length) {
                char[] tmp = new char[2 * index];
                for (int j=0; j<index; j++) {
                    tmp[j] = sb[j];
                }
                sb = tmp;
            }
            char c = word.charAt(i);
            sb[index] = c;
            index++;
        }
    }

    public String joinWords(String[] words) {
        C1StringBuilder sentence = new C1StringBuilder();
        for (String w: words) {
            sentence.append(w);
        }
        return sentence.toString();
    }

    public String toString() {
        String print = "";
        for (int i=0; i<index; i++) {
            print += sb[i];
        }
        return print;
    }
}
