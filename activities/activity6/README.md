<<<<<<< HEAD
# cst339
cst339
=======

# Activity 6 - Securing a Web Application and REST API's
### Bruce Brown
### Grand Canyon University CST-339
### Professor Bobby Estey
### 10/12/2025

---

## Part 1: Securing a Web Application Using an In-Memory Datastore

#### 1. Orders/Display page afer signing in using test/test as username & password

 <p>This screenshot demonstrates the secured Orders page successfully displayed after authenticating with the in-memory user credentials test/test. The application integrates Spring Security using a custom SecurityConfig class to manage authentication, authorization, and route protection. Upon successful login, users are redirected to the /orders endpoint, where the OrdersBusinessService retrieves data from the MongoDB Atlas database through the Spring Data MongoRepository interface. This confirms that user authentication and secure data access are functioning as intended within the application.</p>
<img src="images/image.png" alt="Orders Page" style="width:400px;" />

#### 2. JSON response from MongoDB Repository using /service/getjson Endpoint

 <p>The data is retrieved directly from the MongoDB Atlas database through the MongoRepository service layer. Each JSON object represents an order with fields such as id, orderNo, and total. This demonstrates that the application can expose data in multiple formats without modifying the service layer.
 </p>
<img src="images/image2.png" alt="Get JSON Postman" style="width:400px;" />

#### 3. XML response from MongoDB Repository using /service/getxml Endpoint.

<p>The same orders data from MongoDB Atlas is automatically converted to XML using Spring Boot's message converters. This allows the application to support multiple output formats and demonstrates versatility in exposing data through REST APIs.</p>
<img src="images/image3.png" alt="Get XML Postman" style="width:400px;" />

---

## Part 2: Securing a Web Application Using a Database

#### 1. New login page
<p><b>New logins layout page</b></p>
<img src="images/image4.png" alt="New Login Page" style="width:400px;" />

#### 2. Orders Page after Database Login
<p>This screenshot shows the Orders page displayed after logging in using database-backed credentials stored in MongoDB. Users are authenticated against the MongoDB Atlas database, and the application retrieves order data via the `MongoRepository` service layer. This confirms that database-backed authentication and route protection are working correctly.</p>
<img src="images/image5.png" alt="Aftering logging in" style="width:400px;" />

#### 3. XML Response from MongoDB Repository Using /service/getxml Endpoint
Spring Boot's message converters automatically handle the conversion, demonstrating multi-format support.
<img src="images/image6.png" alt="Get XML Postman" style="width:400px;" />

#### 4. JSON Response from MongoDB Repositry using /service/getjson Endpoint
<img src="images/image7.png" alt="Get JSON Postman" style="width:400px;" />

## Part 3: Securing REST APIs Using Basic HTTP Authentication

#### 1. /getjson API Response with Valid Credentials
<img src="images/image8.png" alt="valid api response" style="width:400px;" />

#### 2. getjson API Response with Invalid Credentials
<img src="images/image9.png" alt="invalid api response" style="width:400px;" />

#### 3. /getxml API Response with Valid Credentials
<img src="images/image10.png" alt="xml valid credentials" style="width:400px;" />

#### 4. /getxml API Response with Invalid Credentials
<img src="images/image11.png" alt="xml invalid credentials" style="width:400px;" />

## Part 4: Securing REST APIs Using OAuth2 Authentication

#### 1. GitHub Login Screen
<p>GitHub OAuth2 login page when accessing the /service/test API. Users are prompted to log in using their GitHub credentials for authentication.</p>
<img src="images/image12.png" alt="GitHub Login" style="width:400px;" />

#### 2. Login Page after Authorization
<p>service/test page with text</p>
<img src="images/image13.png" alt="Page after Authorization" style="width:400px;" />

#### 3. API Respons in Console
<p>PI response after authenticating via GitHub OAuth2. The REST API displays a "hello" message along with the authenticated user's GitHub username, confirming successful OAuth2 authentication.</p>
<img src="images/image14.png" alt="API Response in Console" style="width:400px;" />

## Research Notes

### Forms-Based Authentication
Forms-based authentication is a method where a user logs in through a web form by providing a username and password. The credentials are submitted to a server, where they are verified. This method is widely used because it is secure, reliable, and relatively simple to implement (GeeksForGeeks, 2023). Using frameworks like Spring Security ensures sensitive data is protected, privacy is maintained, and fraud prevention is enforced. Without such security, users’ trust in web applications would be significantly compromised.

**Reference:**  
GeeksForGeeks. (2023). Authentication in Spring Security. https://www.geeksforgeeks.org/authentication-in-spring-security/

### Basic HTTP Authentication
Basic HTTP authentication is a method where the username and password are sent from the client to the server as a Base64-encoded string. While Base64 is not encryption, this scheme allows the server to verify credentials before granting access. It is often used to secure REST API endpoints, ensuring that only clients with valid credentials can access protected resources. However, it is recommended to use it over HTTPS to prevent credentials from being intercepted in transit (Microsoft, 2023).

**Reference:**  
Microsoft. (2023). Understanding HTTP Authentication. Microsoft Docs. https://learn.microsoft.com/en-us/dotnet/framework/wcf/feature-details/understanding-http-authentication
>>>>>>> 22db70e (Initial commit - CST 339 Activity 6)
