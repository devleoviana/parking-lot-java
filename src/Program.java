import services.ParkingLot;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
            ParkingLot parkingLot = new ParkingLot();
            Scanner scanner = new Scanner(System.in);
            int option;

            do {
                System.out.println("\n--- Parking Lot ---");
                System.out.println("1. Entry Register");
                System.out.println("2. Exit Register");
                System.out.println("3. Vehicles List");
                System.out.println("0. Close");
                System.out.print("Choose an option: ");

                option = scanner.nextInt();
                scanner.nextLine(); // limpar buffer

                switch (option) {
                    case 1:
                        System.out.print("Type your vehicle model: ");
                        String model = scanner.nextLine();

                        System.out.print("Type your plate number: ");
                        String plate = scanner.nextLine().toUpperCase();

                        System.out.print("Type your vehicle color: ");
                        String color = scanner.nextLine();

                        parkingLot.registerEntry(plate, model, color);
                        break;

                    case 2:
                        System.out.print("Type your plate number for exit: ");
                        String plateExit = scanner.nextLine().toUpperCase();
                        parkingLot.registerExit(plateExit);
                        break;

                    case 3:
                        parkingLot.listVehicles();
                        break;

                    case 0:
                        System.out.println("Closing system...");
                        break;

                    default:
                        System.out.println("Option invalid, try again.");
                }

            } while (option != 0);

            scanner.close();

        }
}

