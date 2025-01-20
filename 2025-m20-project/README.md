# Description
In this project, we developed the backend application for a restaurant called REST-Foods. The application offers a variety of menus and dishes, as well as a convenient reservation creation function. All of this can be easily managed using Basic HTTP Requests. Thanks to robust CRUD operations, users can seamlessly Create, Read, Update, and Delete menus, dishes, and reservations, ensuring efficient management.

The data for our backend is securely stored and managed within our own custom-designed database (Docker), providing a reliable foundation for the application’s functionality.

# Inheritance
We decided not to implement inheritance in our application because all the logic is on the same level (hierarchy). We have many classes that exist independently and there's no clear "is-a" relationship. 

# Strategy design patters
The Strategy Pattern is a behavioral design pattern that defines a family of algorithms and allows them to be interchangeable. 

Use Case:
To support different discount calculation strategies for dishes. Either in percentage or absolute numbers.

The strategy for calculating the price is separated from the Dish class. The Dish class only knows how to interact with a pricing strategy; it doesn't need to know the specifics of how the price is calculated.

You can apply different strategies dynamically based on context or business rules without modifying the Dish class itself.

Changes to a specific strategy (e.g., updating discount logic) don't affect the other strategies or the Dish class.
