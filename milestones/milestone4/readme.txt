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