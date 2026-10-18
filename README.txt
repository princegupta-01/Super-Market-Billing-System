SUPERMARKET BILLING SYSTEM - MODULAR SIMPLE VERSION

Files:
- Main.java: menu and program flow
- Product.java: product data
- ProductManager.java: add, view, search products
- CartItem.java: one product and quantity in cart
- CartManager.java: holds cart items and calculates subtotal
- BillingService.java: discount, demo tax, and total
- ReceiptPrinter.java: prints the receipt

No file handling and no database.
Data is stored in memory and resets when the program closes.

Run from the project root in VS Code terminal:

javac -d out src\*.java
java -cp out Main

Demo rules:
- 5% discount when subtotal is at least Rs. 1000
- 5% demonstration tax after discount; this is not a claim about applicable GST.
