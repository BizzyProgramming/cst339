# CST-339 Project Design Report – Milestone 2

| Project Design | 9/14/2025 |
|----------------|-----------|
| 2 – Login & Registration Implementation | 9/14/2025 | 1.0 |

### Team
- Individual Project – Bruce Brown

---

### Weekly Status Summary
| User Story | Team Member | Hours Worked | Hours Remaining | Git URL | 
|------------|------------|--------------|----------------|---------|
| Milestone 2: Login & Registration Pages | Bruce Brown | 10 | N/A | https://github.com/BizzyProgramming/cst339.git |

---

### Planning & Implementation
- Updated project domain to **Pokémon Card Collection Garage**  
- Implemented **Spring MVC features**:
  - Login page with validation  
  - Registration page with validation  
  - Success page after registration
- Set up **Thymeleaf layouts**:
  - `defaultTemplate.html` for consistent header/footer
- Integrated **Bootstrap CSS** for responsive design  
- Tested pages locally using `mvn spring-boot:run`  

---

### Technical Approach
- **Backend:** Spring Boot with MVC architecture
  - `Controller Layer` → Handles `/login` and `/register` requests  
  - `Model Layer` → `LoginModel`, `RegisterModel`, `OrderModel`  
- **Frontend:** Thymeleaf templates
  - `login.html`, `register.html`, `registerSuccess.html`, `orders.html`  
  - Layout fragments for `header` and `footer`  
- **Validation:** Jakarta Bean Validation (`@Valid`) for form inputs  
- **Persistence:** No database yet (Milestone 2 requirement) — form submissions print to console  

---

### Key Technical Decisions
| Technology/Framework | Purpose | Reason for Choice |
|--------------------|---------|----------------|
| Spring Boot | Application framework | Simplifies MVC setup, integrates easily with Thymeleaf |
| Thymeleaf | Template engine | Server-side rendering for forms & layouts |
| Bootstrap | Responsive design | Quickly style forms & layout |
| Maven | Build and dependency management | Standard Java project management |
| Jakarta Validation | Form input validation | Ensures user inputs are correct before processing |

---

### Known Issues
- Local-only testing; app is not deployed externally  
- No database persistence yet (form data only prints to console)  
- Some warnings in Thymeleaf fragment syntax; works for now  

---

### Risks
- **Technical:** Thymeleaf template resolution errors (`register-success.html`)  
- **Functional:** User cannot yet login with stored database credentials  
- **Design:** Need to maintain consistent layout as more pages are added  

---

### Install Instructions
1. Clone project from GitHub: `https://github.com/BizzyProgramming/cst339/tree/main/milestones/milestone2`  
2. Ensure **Java 17** is installed  
3. Run the application: mvn spring-boot:run

### ER Diagram - Milesone 2: User & Orders
```mermaid

erDiagram
    USER {
        string firstName
        string lastName
        string email
        string username PK
        string password
    }

    ORDER {
        int orderId PK
        string username FK
        string orderDate
        float total
    }

    USER ||--o{ ORDER : places
```

### Flowchart – Milestone 2: Login & Registration

```mermaid
flowchart TD
    A[Start] --> B[Go to /register page]
    B --> C[Fill Registration Form]
    C --> D{Validation Successful?}
    D -->|Yes| E[registerSuccess.html]
    D -->|No| C
    E --> F[Go to /login page]
    F --> G[Fill Login Form]
    G --> H{Authentication Successful?}
    H -->|Yes| I[orders.html]
    H -->|No| G
    I --> J[End]
```
### Screenshots
#### Terminal console window showing successful launch
<img width="986" height="574" alt="image" src="https://github.com/user-attachments/assets/f420d17f-445a-4201-8865-5053c01f1e96" />

#### Register page
<img width="611" height="509" alt="Registers page" src="https://github.com/user-attachments/assets/27765df4-0a13-40ad-ad48-749d370d6e56" />

#### Successful Login Screen shot
<img width="513" height="317" alt="image" src="https://github.com/user-attachments/assets/6233e550-7f54-4bf3-a312-8a7c808b0b04" />

#### Upon clicking bootstrap button to register & login
<img width="781" height="626" alt="image" src="https://github.com/user-attachments/assets/a82bc302-eeb6-4ef2-82ec-5e82730214c6" />

#### Unfinished Cards List Page
<img width="780" height="548" alt="image" src="https://github.com/user-attachments/assets/5039b46b-8372-41c6-aea0-c5c138f21217" />

#### Terminal showing login credentials form
<img width="487" height="59" alt="image" src="https://github.com/user-attachments/assets/610fcb90-8255-4197-b8ec-1587244f7c52" />

#### Screen Cast Demonstration
https://www.loom.com/share/519c087127354293a2696325c301cb2f
