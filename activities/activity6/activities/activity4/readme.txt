The init method is being called once you run the application or when the application is being created.
The destroy method is called once you close the program down or exit it. 
Init method was only printed in the console once because only one instance was created in the OrdersBusinessService
bean class. 

The init method is only called one time once you log in. This is only happening because of our 
bean fefinition located in our SpringConfig class, which is where we have the init method. 
Once you login, the program context initialized our ordersBusinessService bean which gives us 
our init method. 

The reason we are seeing the init method being called multiple times is because we added the 
RequestScope annotation. Adding this causes the init method to be called each time because a 
new request is being created upon the login page to initiate the method. So each time we login,
 a new instance of OrdersBusinessService bean class is being created, hence why we get multiple 
 init and destroy methods being called. 
 
 The init method is only called once when you log in for the first time. It does not open 
 again upon opening another browser and logging in with different credentials. When using the 
 SessionScope annotation, the init method is only called once when you first login.
 The OrderBusinessService bean is only created once, and thats the purpose of SessionScope, to 
 create the bean class once upon creation.
 
 When using the default or the Singleton Scope for Spring Beans, it only initiates the init
 method upon starting up the application, unlike calling the method upon login like SessionScope
 had it. This default scope only create a single instance of the bean for the entire application
 and it's whole lifetime unless updated with a different annotation. 

How does Spring Data JDBC differ from standard Java JDBC programming? 

JDBC, or Java Database Connectivity, stands as the most widely adopted standard for integrating Java with databases. It provides an array of interfaces and classes to perform SQL queries and handle database tasks efficiently. JDBC is popular for its capability to manage both simple and complex database operations, making it a reliable and versatile choice. However, it uses a blocking I/O model that might lead to performance issues under heavy concurrent request (Mohyuddin, 2023).  

Spring Data JDBC on the other hand, is part of the Spring ecosystem, and offers a repository style approach for database interactions. It’s ideal for applications valuing simplicity in domain design and code generation. This tool facilitates mapping domain objects to database tables using annotations and conventions, aligning with domain driven design principles. To add, it provides an intuitive repository interface for common CRUD operations, enhancing ease of use and promoting streamlined development (Mohyuddin, 2023). 

Reference: 

Mohyuddin, Usman. (2023). JDBC vs. R2DBC vs. Spring JDBC vs. Spring Data JDBC. Baeldung. https://www.baeldung.com/jdbc-vs-r2dbc-vs-spring-jdbc-vs-spring-data-jdbc#:~:text=Spring%20JDBC%20is%20a%20lightweight,connection%20management%20and%20exception%20handling.  

How does Spring Data JDBC support transaction management and the ACID principle? 

Spring Data JDBC supports transaction management and will also follow the ACID principle. In short, ACID stands for Atomicity, Consistency, Isolation, and Durability. Each of these four descriptions are extremely important when it comes to keeping track of reliable safety nets to ensure a transaction is completed correctly.  
To start, Spring Data JDBC will make sure that the database transactions are treated as single units. They either execute, or they do not, which is keeping data integrity, this is the first key phrase in ACID, which is Atomicity. Spring Data JDBC has keeps Consistency, as it helps sustain the referential integrity of your database. It enforces constraints like unique primary keys, assuring data consistency. Then, Isolation, Spring Data JDBC has isolation since it handled concurrent transaction processing by isolation them from one another, preventing data corruption. Lastly, it guarantees Durability by ensuring that completed transactions persistently store their results, even in the vent of system failures. This is exactly Spring Data JDBC following ACID principle entirely. 

Reference: 

TutorialsPoint. Spring – Transaction Management. https://www.tutorialspoint.com/spring/spring_transaction_management.htm#  
