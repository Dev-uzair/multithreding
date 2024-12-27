package org.example.designPatterns;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Factory Pattern
// Creates objects without exposing instantiation logic
interface Vehicle {
    void start();
}

// Adapter Pattern
// Allows incompatible interfaces to work together
interface ModernPaymentGateway {
    void processPayment(double amount);
}

// Observer Pattern
// Defines one-to-many dependency between objects
interface OrderObserver {
    void update(String orderId, String status);
}

// Command Pattern
// Encapsulates request as an object
interface Command {
    void execute();

    void undo();
}

// 1. CREATIONAL PATTERNS
// Singleton Pattern
// Ensures a class has only one instance and provides global access point
class DatabaseConnection {
    private static DatabaseConnection instance;
    private String url;

    private DatabaseConnection() {
        this.url = "jdbc:mysql://localhost:3306/mydb";
    }

    public static synchronized DatabaseConnection getInstance() {
        if ( instance == null ) {
            instance = new DatabaseConnection ( );
        }
        return instance;
    }

    public void connect() {
        System.out.println ( "Connected to: " + url );
    }
}

// 2. STRUCTURAL PATTERNS

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println ( "Car started" );
    }
}

class Truck implements Vehicle {
    @Override
    public void start() {
        System.out.println ( "Truck started" );
    }
}

class VehicleFactory {
    public Vehicle createVehicle(String type) {
        return switch (type.toLowerCase ( )) {
            case "car" -> new Car ( );
            case "truck" -> new Truck ( );
            default -> throw new IllegalArgumentException ( "Unknown vehicle type" );
        };
    }
}

class LegacyPaymentSystem {
    public void doPayment(int amount, String currency) {
        System.out.println ( "Processing payment of " + amount + " " + currency );
    }
}

class PaymentAdapter implements ModernPaymentGateway {
    private final LegacyPaymentSystem legacySystem;

    public PaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void processPayment(double amount) {
        int roundedAmount = (int) Math.round ( amount );
        legacySystem.doPayment ( roundedAmount, "USD" );
    }
}

class CreditCardProcessor {
    public void processCreditCard(double amount) {
    }
}

class PayPalProcessor {
    public void processPayPal(double amount) {

    }
}

// 3. BEHAVIORAL PATTERNS

class BankTransferProcessor {
    public void processBankTransfer(double amount) {

    }
}

// Facade Pattern
// Provides simplified interface to complex subsystem
class PaymentFacade {
    private final CreditCardProcessor creditCard;
    private final PayPalProcessor payPal;
    private final BankTransferProcessor bankTransfer;

    public PaymentFacade() {
        this.creditCard = new CreditCardProcessor ( );
        this.payPal = new PayPalProcessor ( );
        this.bankTransfer = new BankTransferProcessor ( );
    }

    public void processPayment(String type, double amount) {
        switch (type.toLowerCase ( )) {
            case "credit" -> creditCard.processCreditCard ( amount );
            case "paypal" -> payPal.processPayPal ( amount );
            case "bank" -> bankTransfer.processBankTransfer ( amount );
            default -> throw new IllegalArgumentException ( "Unknown payment type" );
        }
    }
}

class InventoryService implements OrderObserver {
    @Override
    public void update(String orderId, String status) {
        System.out.println ( "Updating inventory for order: " + orderId );
    }
}

class NotificationService implements OrderObserver {
    @Override
    public void update(String orderId, String status) {
        System.out.println ( "Sending notification for order: " + orderId );
    }
}

class OrderService {
    private final List<OrderObserver> observers = new ArrayList<> ( );

    public void addObserver(OrderObserver observer) {
        observers.add ( observer );
    }

    public void createOrder(String orderId) {
        // Order creation logic
        notifyObservers ( orderId, "CREATED" );
    }

    private void notifyObservers(String orderId, String status) {
        observers.forEach ( observer -> observer.update ( orderId, status ) );
    }
}

// Chain of Responsibility Pattern
// Passes request along chain of handlers
abstract class LoggerHandler {
    protected LoggerHandler nextHandler;
    protected int level;

    public void setNext(LoggerHandler handler) {
        this.nextHandler = handler;
    }

    public void logMessage(int level, String message) {
        if ( this.level <= level ) {
            write ( message );
        }
        if ( nextHandler != null ) {
            nextHandler.logMessage ( level, message );
        }
    }

    abstract protected void write(String message);
}

class ConsoleLogger extends LoggerHandler {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println ( "Console: " + message );
    }
}

class FileLogger extends LoggerHandler {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println ( "File: " + message );
    }
}

class AddToCartCommand implements Command {
    private final ShoppingCart cart;
    private final Product product;

    public AddToCartCommand(ShoppingCart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    @Override
    public void execute() {
        cart.addProduct ( product );
    }

    @Override
    public void undo() {
        cart.removeProduct ( product );
    }

    private class ShoppingCart {
        List<Product> productList = new ArrayList<> ( );

        public void addProduct(Product product) {
            productList.add ( product );
        }

        public void removeProduct(Product product) {
            productList.remove ( product );
        }
    }

    private class Product {
        public String name;
    }
}

class ShoppingCartManager {
    private final Stack<Command> commandHistory = new Stack<> ( );

    public void executeCommand(Command command) {
        command.execute ( );
        commandHistory.push ( command );
    }

    public void undoLastCommand() {
        if ( ! commandHistory.isEmpty ( ) ) {
            Command command = commandHistory.pop ( );
            command.undo ( );
        }
    }
}

// Example Usage
public class DesignPatternDemo {
    public static void main(String[] args) {
        // Singleton usage
//        DatabaseConnection db1 = DatabaseConnection.getInstance();
//        DatabaseConnection db2 = DatabaseConnection.getInstance();
//        System.out.println("Same instance: " + (db1 == db2)); // true
//        db1.connect ();
//        db2.connect ();
        // Factory usage
//        VehicleFactory factory = new VehicleFactory();
//        Vehicle car = factory.createVehicle("truck");
//        car.start();
//
//        // Adapter usage
//        LegacyPaymentSystem legacySystem = new LegacyPaymentSystem ( );
//        ModernPaymentGateway modernPayment = new PaymentAdapter ( legacySystem );
//        modernPayment.processPayment ( 99.99 );
//
//        // Observer usage
//        OrderService orderService = new OrderService();
//        orderService.addObserver(new InventoryService());
//        orderService.addObserver(new NotificationService());
//        orderService.createOrder("ORD-001");
//
//        // Chain of Responsibility usage
//        LoggerHandler consoleLogger = new ConsoleLogger(1);
//        LoggerHandler fileLogger = new FileLogger(2);
//        consoleLogger.setNext(fileLogger);
//        consoleLogger.logMessage(2, "This is a test message");
    }
}