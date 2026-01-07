import java.util.ArrayList;

public class Ascii {
public static void main(String[] args) {

    subseqAscii("","abc");
    subseqAsciiRet("","abc");

}
    static void subseqAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseqAscii(p + ch, up.substring(1));
        subseqAscii(p, up.substring(1));
        subseqAscii(p + (ch + 0), up.substring(1));


}

static ArrayList<String> subseqAsciiRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        char ch = up.charAt(0);
        
        ArrayList<String> first = subseqAsciiRet(p + ch, up.substring(1));
        ArrayList<String> second = subseqAsciiRet(p, up.substring(1));
        ArrayList<String> third = subseqAsciiRet(p + (ch + 0), up.substring(1));
        
        first.addAll(second);
        first.addAll(third);
        
        return first;
    }
// subseqAsciiRet("", "ab")
// │
// ├─────────────────┬─────────────────┬─────────────────
// │                 │                 │
// first             second            third
// p + 'a'           p (skip)          p + 97
// │                 │                 │
// ▼                 ▼                 ▼
// ("a", "b")        ("", "b")         ("97", "b")
// │                 │                 │
// ├────┬────┬────   ├────┬────┬────   ├────┬────┬────
// │    │    │       │    │    │       │    │    │
// add  skip +98     add  skip +98     add  skip +98
// 'b'  'b'  (98)    'b'  'b'  (98)    'b'  'b'  (98)
// │    │    │       │    │    │       │    │    │
// ▼    ▼    ▼       ▼    ▼    ▼       ▼    ▼    ▼
// "ab" "a"  "a98"   "b"  ""   "98"    "97b" "97" "9798"
}