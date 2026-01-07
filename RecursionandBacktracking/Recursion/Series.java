public class Series {
    public static void main(String[] args) {
        fun(5);
        System.out.println();
        funRev(5);
        System.out.println();
        funBoth(5);
    }

    static void fun(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        fun(n - 1);

    }


    static void funRev(int n) {
        if (n == 0) return;
        funRev(n - 1);
        System.out.println(n);

    }

    static void funBoth(int n) {
        if (n == 0) return;
        System.out.println(n);
        funBoth(n - 1);
        System.out.println(n);

    }

}

//| Step | Function call | What happens                   |
//        | ---- | ------------- | ------------------------------ |
//        | 1    | `funRev(5)`   | n ≠ 0 → calls `funRev(4)`      |
//        | 2    | `funRev(4)`   | n ≠ 0 → calls `funRev(3)`      |
//        | 3    | `funRev(3)`   | n ≠ 0 → calls `funRev(2)`      |
//        | 4    | `funRev(2)`   | n ≠ 0 → calls `funRev(1)`      |
//        | 5    | `funRev(1)`   | n ≠ 0 → calls `funRev(0)`      |
//        | 6    | `funRev(0)`   | n == 0 → **return** (no print) |
//
//
//When a function returns, it does finish its own execution,
//but it returns control to the function that called it — and that caller might still have unfinished lines left to run.
//
//So yes — return ends the current function, but not the entire chain of recursive calls.
