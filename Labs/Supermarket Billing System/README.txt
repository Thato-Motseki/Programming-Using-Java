Question 1: Supermarket Checkout Calculator (20 marks)

Scenario

A supermarket wants a simple console-based checkout program that calculates the total cost of a customer's shopping.

Product Prices

Item #	Product	Price (M)
1	Bread	18.00
2	Milk	16.00
3	Cereal	42.00
4	Chicken	75.00
5	Juice	25.00

Business Rules

Customers may purchase multiple products.
The customer enters an item number and quantity.
The price must be retrieved from an array.
If the quantity is 0 or negative, reject the entry.
If the item number is outside 1–5, reject the entry.
If the subtotal exceeds M300.00, apply a 10% discount.
If the final amount after discount is below M20.00, charge M20.00.
Entering 0 as the item number means the customer has finished shopping.

Your Task

Write a Java program that:

Stores the product names and prices in arrays.
Continuously asks the customer to enter an item number.
Uses 0 to terminate the ordering process.
Validates the item number.
Asks for the quantity of the selected product.
Validates the quantity.
Calculates the subtotal for each valid purchase.
Maintains a running total.
Applies the 10% discount when applicable.
Displays each valid product purchased, quantity, subtotal, discount and final amount.