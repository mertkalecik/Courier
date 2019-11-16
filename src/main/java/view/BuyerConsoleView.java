package view;

import model.BuyerModel;

import java.util.Scanner;

public class BuyerConsoleView {
    private BuyerModel buyerModel;
    private int productId;
    private int quantity;
    private Scanner scanner;

    public BuyerConsoleView(BuyerModel buyerModel) {
        this.buyerModel = buyerModel;
        scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("-----------Buyer Screen----------");
            System.out.println("1.MakeLineItem");
            System.out.println("2.Complete Order");
            System.out.println("3.Back");
            System.out.println("-1.Terminate");

            choice = scanner.nextInt();
            if (choice == 3)
                break;

            switch (choice) {
                case -1:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Enter ProductId: ");
                    productId = scanner.nextInt();
                    System.out.println("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    makeLineItem(productId, quantity);
                    break;
                case 2:
                    completeOrder();
                    break;
            }
        }

    }

    private void makeLineItem(Integer id, Integer quantity) {
        buyerModel.makeLineItem(String.valueOf(id), quantity);
    }

    private void completeOrder() {
        buyerModel.notifySellers();
    }
}
