# CST-339 Project Design Report – Milestone 7

| Project Design | 10/19/2025 |
|----------------|------------|
| 7 – Microservices and REST API Implementation | 10/19/2025 | 4.0 |

### Team
- Individual Project – Bruce Brown

---

### Weekly Status Summary
| User Story | Team Member | Hours Worked | Hours Remaining | Git URL | 
|-------------|--------------|---------------|----------------|---------|
| Milestone 7: Build and secure REST APIs using microservices architecture; add JSON and XML endpoints for products | Bruce Brown | 15 | N/A | https://github.com/BizzyProgramming/cst339.git |

---

### Planning & Implementation
- Developed two **REST APIs**:  
  - `/service/products` → Returns all products.  
  - `/service/product/{id}` → Returns a single product by ID.  
- Implemented **microservice structure** separating API endpoints from the consumer web UI.  
- Integrated **Spring Security Basic HTTP Authentication** to secure API endpoints using credentials from MySQL.  
- Used **BCrypt hashing** for all stored passwords in the database.  
- Updated `OrdersRestService` to return **JSON** and **XML** formatted data.  
- Verified functionality in both **browser** and **Postman**.  
- Refactored the application to meet **RESTful standards**, using `@RestController` and `@GetMapping`.  
- Enhanced database connection for `ProductDAO` and refactored queries to map product attributes properly.  
- Ensured all services (Consumer App, Product Service, and Security) run independently.  

---

### Technical Approach
**Backend:** Spring Boot MVC with RESTful microservices, Spring Security + JDBC/DAO  
- **Controllers:** HomeController, LoginPageController, RegistrationController, OrdersController  
- **Business:** ProductBusinessService, SecurityBusinessService, OrdersRestService  
- **DAO:** ProductDAOImpl, UserDAOImpl  
- **Configuration:** WebSecurityConfig (defines authentication providers, Basic HTTP Auth, and filter chain)  

**Frontend:** Thymeleaf templates integrated with Bootstrap and reusable layouts (`defaultTemplate.html`, `common.html`).  

**Persistence:** MySQL database accessed through Spring JDBC with `JdbcTemplate`.  
- **Tables:**  
  - `users` → For authentication (username, password, email, created_at).  
  - `products` → For REST API display (id, productName, price, quantity).  

**Testing & Verification:**  
- Tested JSON and XML output for `/service/products` and `/service/product/1`.  
- Verified HTTP Basic Authentication with valid and invalid credentials.  
- Confirmed consumer UI displays product data retrieved via REST APIs.

---

### Key Technical Decisions
| Technology/Framework | Purpose | Reason for Choice |
|----------------------|----------|------------------|
| Spring Boot | Backend Framework | Simplifies dependency management and configuration |
| Spring Security | Authentication & Authorization | Enforces API protection and secure login |
| BCryptPasswordEncoder | Password encryption | Industry-standard password hashing |
| REST API / JSON / XML | Data communication format | Enables interoperable, flexible service communication |
| MySQL | Database | Reliable, structured data persistence |
| Maven | Build Tool | Handles dependencies and project packaging |

---

### Known Issues
- Role-based security (Admin vs User) not yet implemented.  
- No global exception handler for REST API error responses.  
- Microservices run locally, not yet containerized via Docker.  
- Unit tests for REST endpoints pending for future milestone.  

---

### Risks
- **Database Connection:** Failure if MySQL credentials or port changes.  
- **Security:** APIs rely on HTTP Basic Auth; OAuth2 could improve scalability.  
- **Service Dependencies:** Consumer app depends on the API service availability.  
- **Deployment:** Future integration with Eureka or Kubernetes could add complexity.  

---

### Screenshots

#### 1. User Microservice – JSON Output
<img width="600" alt="Users JSON" src="https://github.com/user-attachments/assets/b0ab774a-bfe8-40c7-bea0-49cc861e0de7" />  
**Description:**  
Displays all user data in JSON format through the `/service/users` endpoint, confirming microservice connectivity and REST response structure.

#### 2. Orders Microservice – JSON Output
<img width="600" alt="Orders JSON" src="https://github.com/user-attachments/assets/a993f9dc-f39e-456f-ac26-db20bc5a83bd" />  
**Description:**  
Lists all orders returned by the `/service/orders` endpoint in JSON format. Tested successfully in both Postman and browser.

#### 3. Product Service – XML Output
<img width="600" alt="Products XML" src="https://github.com/user-attachments/assets/46cddebd-69cd-4653-84dd-39893d4e0411" />  
**Description:**  
Returns products in XML format using `/service/getxml`, proving the service supports multi-format data serialization.

#### 4. Home, Orders, and Users Pages
<img width="600" alt="Home Page" src="https://github.com/user-attachments/assets/93b07e90-6a9a-4775-ab23-38711cd7417e" />  
<img width="600" alt="Users Page" src="https://github.com/user-attachments/assets/8af6989a-68ed-4d15-bcb1-3d8fb266c6db" />  
**Description:**  
These pages consume the microservice APIs using `RestTemplate`, demonstrating the integration of separate, independent services.

---

### Research Questions

#### 1. Describe what microservices are. How does this architecture style differ from traditional monolithic architectures?
Microservices are an architectural style that breaks a large application into smaller, independent services, each responsible for a specific task (e.g., authentication, billing, or content delivery).  
Each service runs in its own process, has its own database, and communicates via REST APIs.  
This design allows developers to deploy, maintain, and scale each service independently.  
In contrast, monolithic architectures combine all components—UI, logic, and database—into a single unit, making updates slower and scaling less flexible.  

**References:**  
- GeeksForGeeks. (2025). [What are Microservices?](https://www.geeksforgeeks.org/system-design/microservices/)  
- Netflix Tech Blog. (2024). [Rebuilding Netflix Video Processing Pipeline with Microservices.](https://netflixtechblog.com/rebuilding-netflix-video-processing-pipeline-with-microservices-4e5e6310e359)

---

#### 2. What are 5 challenges you might encounter when modifying a monolithic architecture to a microservice architecture style?
1. **Service Communication:** Managing API calls and ensuring reliability between independent services.  
2. **Data Management:** Maintaining data consistency across multiple service databases.  
3. **Deployment Complexity:** Coordinating the deployment and scaling of multiple microservices.  
4. **Security:** Managing authentication and authorization across services.  
5. **Increased Infrastructure Complexity:** Requires service discovery, orchestration, and monitoring tools.  

**Reference:**  
- AWS. (2025). [Building Microservices on AWS.](https://aws.amazon.com/microservices/)  

---

### Conclusion
This milestone demonstrated how to design and secure REST APIs within a microservice architecture using Spring Boot.  
By separating services (User, Orders, and Product), I achieved improved modularity, scalability, and maintainability.  
Securing endpoints with Basic HTTP Authentication strengthened the application’s reliability, and testing JSON/XML outputs showcased interoperability across systems.  
Milestone 7 provided valuable insight into the foundation of distributed systems and modern enterprise-class applications.

---

### ER Diagram

```mermaid
erDiagram
    USER {
        string username PK
        string password
        string email
        datetime created_at
    }

    PRODUCT {
        int id PK
        string productName
        float price
        int quantity
    }

    USER ||--o{ PRODUCT : purchases

```

flowchart TD
    A["Login via /login"] --> B["Spring Security validates MySQL credentials"]
    B -->|Success| C["Access /service/products (JSON)"]
    B -->|Fail| D["Redirect to Login Page"]
    C --> E["Optional /service/product/{id} (XML)"]
    E --> F["REST Consumer App Displays Data"]
    F --> G["Logout -> Redirect to Home"]
