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

## Delegation
This exludes the validation logic from the addDish method.  
<img width="712" alt="image" src="https://github.com/user-attachments/assets/f8117e3f-73ca-492c-8bd5-ff09b804b788" />


### Strategy pattern
![image](https://github.com/user-attachments/assets/aaddf214-6232-4f6c-b98a-c867dff5e367)


### Getting all dishes
![image](https://github.com/user-attachments/assets/fde3b488-039a-4fba-ad9c-f8712bb84e16)

### Creaating a dish
![image](https://github.com/user-attachments/assets/0c5c67f5-1c0c-499c-8319-3c9e3f9064aa)

### Get by id
![image](https://github.com/user-attachments/assets/5868500b-049a-4bba-b39f-db14f2fe01bd)

### Update dish
![image](https://github.com/user-attachments/assets/11ac4cd3-ffc8-4057-84eb-75c882bea2e7)

