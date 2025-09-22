# CST-339 Project Design Report – Milestone 3

| Project Design | 9/22/2025 |
|----------------|-----------|
| 3 – Registration & Product Creation Modules | 9/22/2025 | 1.0 |

### Team
- Individual Project – Bruce Brown

---

### Weekly Status Summary
| User Story | Team Member | Hours Worked | Hours Remaining | Git URL | 
|------------|------------|--------------|----------------|---------|
| Milestone 3: Registration & Product Creation using Spring Beans / IoC | Bruce Brown | 12 | N/A | https://github.com/BizzyProgramming/cst339.git |

---

### Planning & Implementation
- Refactored **Registration and Login Modules** to use **Spring Beans and IoC**.  
- Implemented **Product Creation / Shop Module** (via orders page).  
- Updated Thymeleaf layouts:
  - `defaultTemplate.html` for consistent header/footer  
  - `registration.html`, `login.html`, `orders.html`  
- Forms validated with **Jakarta Bean Validation (`@Valid`)**.  
- Backend controllers now **handle form submissions using beans**.  
- Tested all pages locally using `mvn spring-boot:run`.  

---

### Technical Approach
- **Backend:** Spring Boot MVC using IoC / Spring Beans
  - `RegistrationController`, `LoginController`, `OrdersBusinessService`  
  - Beans configured via `SpringConfig.java`
- **Frontend:** Thymeleaf templates
  - `login.html`, `registration.html`, `orders.html`  
  - Layout fragments for `header` and `footer`
- **Validation:** Jakarta Bean Validation for form inputs
- **Persistence:** No database yet; form submissions print to console for testing

---

### Key Technical Decisions
| Technology/Framework | Purpose | Reason for Choice |
|--------------------|---------|----------------|
| Spring Boot | Application framework | Simplifies MVC setup, integrates with Thymeleaf |
| Spring Beans / IoC | Dependency management | Decouples controller logic from service implementation |
| Thymeleaf | Template engine | Server-side rendering for forms & layouts |
| Bootstrap | Responsive design | Quickly style forms & layout |
| Maven | Build and dependency management | Standard Java project management |
| Jakarta Validation | Form input validation | Ensures user inputs are correct before processing |

---

### Known Issues
- Local-only testing; app is not deployed externally  
- No database persistence yet (form data only prints to console)  
- UI layout may need tweaks for smaller screens  

---

### Risks
- **Technical:** Bean initialization issues if additional modules added  
- **Functional:** User cannot yet login with stored database credentials  
- **Design:** Maintaining consistent layout as more pages/modules are added

 ---

 ### Screenshots
 #### Login Page
 <img width="786" height="758" alt="image" src="https://github.com/user-attachments/assets/77dd0359-107b-48a8-bbe1-cfd69ddaa274" />

 #### Registration Page/ Create account
 <img width="736" height="926" alt="image" src="https://github.com/user-attachments/assets/08b5a7a9-40d3-4ae7-aaa7-be291e074ebb" />

#### Once you register using account and password, back to login page and then can login to shop page
<img width="730" height="896" alt="image" src="https://github.com/user-attachments/assets/09f3e569-7bcc-4987-925b-1a517d72693c" />

---

#### Preview/Screen cast of my Spring Boot web application
https://www.loom.com/share/a8b8cb74446344c5bd37fc6fd98af0cb

---

- ### ER Diagram

```mermaid
erDiagram
    USER {
        string username PK
        string password
    }

    ORDER {
        int orderId PK
        string username FK
        string orderDate
        float total
    }

    PRODUCT {
        int productId PK
        string productName
        float price
        int quantity
    }

    USER ||--o{ ORDER : places
    ORDER ||--o{ PRODUCT : contains
