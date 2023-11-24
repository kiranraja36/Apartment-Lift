import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int[] l = new int[5];
        while (loop) {
            System.out.println("---------------------------------------------");
            System.out.println("1.use lift \n2.service lift \n3.show lift \n4.exit");
            System.out.println("---------------------------------------------");
            int q = sc.nextInt();
            sc.nextLine();
            switch (q) {
                case 1: {
                    ArrayList<Integer> nearby = new ArrayList<>();
                    int min = 15;
                    System.out.println("-------------------");
                    System.out.println("l1 |l2 |l3 |l4 |l5");
                    System.out.printf("%d  |%d  |%d  |%d  |%d\n", l[0], l[1], l[2], l[3], l[4]);
                    System.out.println("--------------------");
                    System.out.println("enter from_floor to_floor ");
                    int from_floor = sc.nextInt();
                    int to_floor = sc.nextInt();
                    sc.nextLine();
                    int direction = (from_floor - to_floor < 0) ? -1 : 1;
                    for (int i = 0; i < 5; i++) {
                        if (l[i] == -1)
                            continue;
                        int n = Math.abs(from_floor - l[i]);
                        if (n == 0) {
                            System.out.println("lift " + (i + 1) + " is assigned ");
                            l[i] = to_floor;
                            nearby.clear();
                            break;
                        }
                        if (n < min) {
                            min = n;
                            nearby.clear();

                        }
                        if (n == min) {
                            nearby.add(i);
                        }
                    }
                    if (direction == -1) {
                        for (int i : nearby) {
                            if (l[i] - from_floor < 0) {
                                System.out.println("lift " + (i + 1) + " is assigned ");
                                l[i] = to_floor;
                                break;
                            }
                        }
                    } else {
                        for (int i : nearby) {
                            if (l[i] - from_floor > 0) {
                                System.out.println("lift " + (i + 1) + " is assigned ");
                                l[i] = to_floor;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("---------------------------------------------");
                    System.out.println("1.want to Service  \n2.service made \n3.exit");
                    System.out.println("---------------------------------------------");
                    int k = sc.nextInt();
                    sc.nextLine();
                    if (k == 1) {
                        System.out.print("enter lift number to service ");
                        int no = sc.nextInt();
                        if (no - 1 <= 4) {
                            if (l[no] == -1) {
                                System.out.println("lift already under condtruction");
                            } else {
                                System.out.println("lift-" + no + " under construction");
                                l[no - 1] = -1;
                            }
                        } else {
                            System.out.println("there is no lift-" + no);
                        }
                    } else if (k == 2) {
                        System.out.print("enter lift number that serviced ");
                        int no = sc.nextInt();
                        if (no - 1 <= 4) {
                            if (l[no] != -1) {
                                System.out.println("lift already under work condition");
                            } else {
                                System.out.println("lift-" + no + " service made ");
                                l[no - 1] = 0;
                            }
                        } else {
                            System.out.println("there is no lift-" + no);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("-------------------");
                    System.out.println("l1 |l2 |l3 |l4 |l5");
                    System.out.printf("%d  |%d  |%d  |%d  |%d\n", l[0], l[1], l[2], l[3], l[4]);
                    System.out.println("--------------------");
                    break;
                }
                case 4: {
                    loop = false;
                    break;
                }
            }
        }
    }
}