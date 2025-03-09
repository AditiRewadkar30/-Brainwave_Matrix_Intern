import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
}

class Appointment {
    int id;
    int patientId;
    int doctorId;
    String date;

    Appointment(int id, int patientId, int doctorId, String date) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }
}

class Bill {
    int patientId;
    double amount;

    Bill(int patientId, double amount) {
        this.patientId = patientId;
        this.amount = amount;
    }
}

class InventoryItem {
    int id;
    String itemName;
    int stock;

    InventoryItem(int id, String itemName, int stock) {
        this.id = id;
        this.itemName = itemName;
        this.stock = stock;
    }
}

public class HospitalManagementSystem {
    static List<Patient> patients = new ArrayList<>();
    static List<Doctor> doctors = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<Bill> bills = new ArrayList<>();
    static List<InventoryItem> inventory = new ArrayList<>();
    static int patientIdCounter = 1;
    static int doctorIdCounter = 1;
    static int appointmentIdCounter = 1;
    static int inventoryIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Register Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Generate Bill");
            System.out.println("8. View Inventory");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> registerPatient(scanner);
                case 2 -> viewPatients();
                case 3 -> registerDoctor(scanner);
                case 4 -> viewDoctors();
                case 5 -> scheduleAppointment(scanner);
                case 6 -> viewAppointments();
                case 7 -> generateBill(scanner);
                case 8 -> viewInventory();
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void registerPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();
        patients.add(new Patient(patientIdCounter++, name, age, disease));
        System.out.println("Patient Registered Successfully.");
    }

    private static void viewPatients() {
        System.out.println("\nRegistered Patients:");
        for (Patient p : patients) {
            System.out.println(p.id + " | " + p.name + " | " + p.age + " | " + p.disease);
        }
    }

    private static void registerDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        doctors.add(new Doctor(doctorIdCounter++, name, specialization));
        System.out.println("Doctor Registered Successfully.");
    }

    private static void viewDoctors() {
        System.out.println("\nRegistered Doctors:");
        for (Doctor d : doctors) {
            System.out.println(d.id + " | " + d.name + " | " + d.specialization);
        }
    }

    private static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        appointments.add(new Appointment(appointmentIdCounter++, patientId, doctorId, date));
        System.out.println("Appointment Scheduled Successfully.");
    }

    private static void viewAppointments() {
        System.out.println("\nAppointments:");
        for (Appointment a : appointments) {
            System.out.println(a.id + " | Patient ID: " + a.patientId + " | Doctor ID: " + a.doctorId + " | Date: " + a.date);
        }
    }

    private static void generateBill(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        bills.add(new Bill(patientId, amount));
        System.out.println("Bill Generated Successfully.");
    }

    private static void viewInventory() {
        System.out.println("\nMedical Inventory:");
        for (InventoryItem item : inventory) {
            System.out.println(item.id + " | " + item.itemName + " | Stock: " + item.stock);
        }
    }
}