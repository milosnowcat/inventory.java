# inventory.java

## Introduction
Welcome to **Inventory.java**, a Java-based application for managing a cell phone case sublimation business. This project utilizes object-oriented programming principles to provide a comprehensive and functional user experience. This README document will guide you through the technical aspects of the program and explain its features.

## Justification
This project was developed to meet the requirements of delivering a product that demonstrates the technical knowledge acquired throughout the semester. It aims to provide a complete and secure user experience by implementing extensive functionalities. The system organizes users, determines their capabilities, and controls their actions within the defined scope. This approach ensures a specific and satisfactory level of control for registered users.

## Development
### Project Overview
The program focuses on the sublimation business, specifically managing users and product records. Users have three privilege levels:

- **Level 1:** Can only view product records.
- **Level 2:** Can view, add, edit, and delete product records.
- **Level 3:** Can perform all Level 2 actions and manage user records.

Product records include information such as cell phone brand, model, quantity, and cost per unit. The application features various windows for user management, product management, and authentication.

### Algorithm
The algorithm outlines the basic flow of the program:

1. Execute the program.
2. Display the main page.
3. Enter login credentials.
4. Log in.
5. If the decision is:
   - 5.1 Add user:
     - 5.1.1 Enter username.
     - 5.1.2 Enter user password.
     - 5.1.3 Select privilege level.
     - 5.1.4 Add user.
   - 5.2 View user table:
     - 5.2.1 Edit user:
       - 5.2.1.1 Enter user ID to edit.
       - 5.2.1.2 Go to step 5.1.
     - 5.2.2 Delete user:
       - 5.2.2.1 Enter user ID to delete.
       - 5.2.2.2 Delete user.
   - 5.3 Search for user:
     - 5.3.1 Enter user ID to search.
     - 5.3.2 If ID exists:
       - 5.3.2.1 Display user data.
     - 5.3.3 Otherwise:
       - 5.3.3.1 Display error message.
6. Press "X" button.
7. Close the program.

## User Manual
### Project Description
Inventory.java is designed for managing a cell phone case sublimation business and includes:

- User registration with three privilege levels.
- Product registration with details such as brand, model, quantity, and cost per unit.
- Various windows for user and product management.
- Based on a previous project called "Inventory.php."

### System Entry and Exit
1. [Download](https://github.com/milosnowcat/inventory.java/releases/latest) the executable as a .zip file.
2. Extract the contents, and locate the inventory-java.jar file.
3. Run the program using the latest version of Java or through Eclipse IDE.

   ```
   java -jar inventory-java.jar
   ```

4. To exit the system, close the window.

### Application Usage
1. Upon launching, the main interface will appear.
2. Create a user account, and click the designated button.
3. After logging in, the main interface for product and user management will be displayed.
4. Use the buttons to add products or view product tables.

Feel free to explore the various features of **Inventory.java** to manage your sublimation business efficiently.

For any additional information or support, refer to the original project at [Inventory.php](https://www.rahcode.com/inventory.php).
