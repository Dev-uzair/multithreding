package org.example.designPatterns.creational;


    public  class DatabaseConnection {
        private static DatabaseConnection instance;
        private String url;

        private DatabaseConnection() {
            this.url = "jdbc:mysql://localhost:3306/mydb";
        }

        public static synchronized DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        public void connect() {
            System.out.println("Connected to: " + url);
        }

        public static void main(String[] args) {
            DatabaseConnection db1 = DatabaseConnection.getInstance();
            DatabaseConnection db2 = DatabaseConnection.getInstance();
            System.out.println("Singleton test - Same instance: " + (db1 == db2));

        }
    }

