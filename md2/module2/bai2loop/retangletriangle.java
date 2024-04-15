package bai2loop;

import java.util.Scanner;

public class retangletriangle {
    public static void main(String[] args) {
        int choice = -1;
        int cd, cr, canh;
        Scanner sc = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("=====MENU=====");
            System.out.println("1.In hình chữ nhật ");
            System.out.println("2.In hình chữ nhật rỗng");
            System.out.println("3.In hình tam giác vuông rỗng");
            System.out.println("4.In hình tam giác cân");
            System.out.println("5.In hình tam giác cân rỗng");
            System.out.println("6.Thoát \n \n");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập chiều dài: ");
                    cd = sc.nextInt();
                    System.out.println("Nhập chiều rộng: ");
                    cr = sc.nextInt();
                    for (int i = 1; i <= cd; i++) {
                        for (int j = 1; j <= cr; j++) {
                            System.out.println("*");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhập chiều dài: ");
                    cd = sc.nextInt();
                    System.out.println("Nhập chiều rộng: ");
                    cr = sc.nextInt();
                    for (int i = 1; i <= cd; i++) {
                        for (int j = 1; j <= cr; j++) {
                            if (i == 1 || i == cd || j == 1 || j == cr) {
                                System.out.print("*");
                            } else {
                                System.out.print("\u00a0");
                            }
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("Nhập độ dài cạnh dài của tam giác vuông: ");
                    canh = sc.nextInt();
                    for (int i = 1; i <= canh; i++) {
                        for (int j = 1; j <= i; j++) {
                            if (j == 1 || j == i || i == canh) {
                                System.out.print("*");
                            } else {
                                System.out.print("\u00a0");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Nhập độ dài cạnh của tam giác cân: ");
                    canh = sc.nextInt();
                    for (int i = 1; i <= canh; i++) {
                        for (int j = canh - 1; j >= i; j--) {
                            System.out.print("\u00a0");
                        }
                        for (int j = 1; j <= 2 * i - 1; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Nhập độ dài cạnh của tam giác cân rỗng: ");
                    canh = sc.nextInt();
                    for (int i = 1; i <= canh; i++) {
                        for (int j = canh - 1; j >= i; j--) {
                            System.out.print("\u00a0");
                        }
                        for (int j = 1; j <= 2 * i - 1; j++) {
                            if (j == 1 || (j == 2 * i - 1) || i == canh) {
                                System.out.print("*");
                            } else {
                                System.out.println("\u00a0");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    System.exit(6);

            }
        }
    }

}
