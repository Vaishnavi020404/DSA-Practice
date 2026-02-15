import java.io.*;
import java.util.*;

public class BullyAlgo {
    private int n;
    private int[] prc; // 1 for alive, 0 for dead
    private int cood;

    public void Bully() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter The Number of Processes: ");
        n = Integer.parseInt(br.readLine());

        prc = new int[n];
        for (int i = 0; i < n; i++) {
            prc[i] = 1; // Initially all processes are alive
        }
        cood = n; // The highest ID is the initial coordinator

        int ch;
        do {
            System.out.println("\n\t1. Crash A Process");
            System.out.println("\t2. Recover A Process");
            System.out.println("\t3. Display New Coordinator");
            System.out.println("\t4. Exit");
            ch = Integer.parseInt(br.readLine());

            switch (ch) {
                case 1:
                    System.out.print("\nEnter A Process To Crash: ");
                    int cp = Integer.parseInt(br.readLine());
                    if (cp > n || cp < 1) {
                        System.out.println("Invalid Process! Enter A Valid Process");
                    } else if (prc[cp - 1] == 1) {
                        prc[cp - 1] = 0;
                        System.out.println("\nProcess " + cp + " Has Been Crashed!");
                        if (cp == cood) {
                            System.out.println("\nThe Coordinator Has Crashed!");
                            System.out.print("Enter The Initiator: ");
                            int init = Integer.parseInt(br.readLine());
                            election(init);
                        }
                    } else {
                        System.out.println("\nProcess " + cp + " Is Already Crashed!");
                    }
                    break;

                case 2:
                    System.out.print("\nEnter The Process You Want To Recover: ");
                    int rp = Integer.parseInt(br.readLine());
                    if (rp > n || rp < 1) {
                        System.out.println("\nInvalid Process. Enter A Valid ID");
                    } else if (prc[rp - 1] == 0) {
                        prc[rp - 1] = 1;
                        System.out.println("\nProcess " + rp + " Has Recovered");
                        // If the recovered process has a higher ID than the current coordinator, it bullies its way to the top
                        if (rp > cood || prc[cood - 1] == 0) {
                            election(rp);
                        }
                    } else {
                        System.out.println("\nProcess " + rp + " Is Not A Crashed Process");
                    }
                    break;

                case 3:
                    System.out.println("\nCurrent Coordinator Is " + cood);
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid Entry!");
            }
        } while (ch != 4);
    }

    public void election(int init) {
        // According to the Bully algorithm, messages are sent to all processes with higher IDs
        for (int i = init; i <= n; i++) {
            System.out.println("Process " + i + " Called For Election");
        }

        for (int i = init; i <= n; i++) {
            if (prc[i - 1] == 0) {
                System.out.println("Process " + i + " Is Dead");
            } else {
                System.out.println("Process " + i + " Is In");
            }
        }

        // Find the highest-ID process that is still alive
        for (int i = n; i >= 1; i--) {
            if (prc[i - 1] == 1) {
                cood = i;
                System.out.println("\n*** New Coordinator Is " + cood + " ***");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BullyAlgo ob = new BullyAlgo();
        ob.Bully();
    }
}
