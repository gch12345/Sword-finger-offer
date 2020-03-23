package nowCoder;

import java.util.ArrayList;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] ret = new boolean[n];
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            arrayList.add(list);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arrayList.get(ch - 'a').add(i);
        }
        for (int i = 0; i < n; i++){
            char ch = p[i].charAt(0);
            ArrayList<Integer> List = arrayList.get(ch - 'a');
            if (List.size() == 0) {
                ret[i] = false;
                continue;
            }
            for (int j = 0; j < List.size(); j++) {
                int index  = List.get(j);
                int k = 0;
                for (; k < p[i].length(); k++) {
                    if (index >= s.length() || p[i].charAt(k) != s.charAt(index)) {
                        break;
                    }
                    index++;
                }
                if (k == p[i].length()) {
                    ret[i] = true;
                    break;
                }
            }
        }
        return ret;
    }

}
