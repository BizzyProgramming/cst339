# Activity 7 - MicroServices
### Bruce Brown
### Grand Canyon University CST-339
### Professor Bobby Estey
### 10/19/2025

---

## Part 1: Building a Web Application That Consumes Microservices

#### 1. User Microservice

 <p>This microservice provides access to user data through the /service/users endpoint. It runs independently on port 8081 and returns a JSON list of users. The screenshots below demonstrate the service running in the browser and tested in Postman, confirming that the endpoint returns valid JSON responses from the UserBusinessService layer.</p>
 <p>Browsers list of users</p>
<img width="479" height="201" alt="image" src="https://github.com/user-attachments/assets/1e1d16ae-4b3c-470c-85d4-68b14c7436b8" />
<p>PostMan test works as well</p>
<img width="736" height="759" alt="image" src="https://github.com/user-attachments/assets/b0ab774a-bfe8-40c7-bea0-49cc861e0de7" />

#### 2. Orders MicroService - Browser and Postman Screenshots

 <p>The Orders microservice runs on port 8082 and exposes the /service/orders endpoint. It provides order information as a JSON response. The screenshots confirm that the REST API is functional both in the browser and through Postman requests.
 </p>
 <p>Browsers list of orders</p>
<img width="589" height="193" alt="image" src="https://github.com/user-attachments/assets/4be9018c-952f-4ec0-a5ed-9eb3e213488f" />
<p>PostMan test to localhost:8082/ordres</p>
<img width="772" height="758" alt="image" src="https://github.com/user-attachments/assets/a993f9dc-f39e-456f-ac26-db20bc5a83bd" />

#### 3. Consumer Web Application - Microservices Integration

<p>The consumer application runs on port 8080 and uses RestTemplate calls to consume data from the Users (8081) and Orders (8082) microservices. This integration demonstrates how independent services can communicate through REST APIs to form a complete web application. Each service is developed, deployed, and tested separately, showing the modularity and scalability benefits of a microservice architecture.</p>
<p>Home Page</p>
<img width="605" height="540" alt="image" src="https://github.com/user-attachments/assets/93b07e90-6a9a-4775-ab23-38711cd7417e" />
<p>Users Page</p>
<img width="605" height="682" alt="image" src="https://github.com/user-attachments/assets/8af6989a-68ed-4d15-bcb1-3d8fb266c6db" />
<p>Orders Page</p>
<img width="606" height="680" alt="image" src="https://github.com/user-attachments/assets/46cddebd-69cd-4653-84dd-39893d4e0411" />

---

## Research Notes

### 1. Research microservices. Describe what they are. How does this architecture style differ from traditional monolithic architectures?

<p>Microservices are an architectural style that breaks a large application into smaller, independent services, each responsible for a specific task. Examples of such tasks could include: authentication, billing, or content delivery. Each service runs in its own process, has its own database or schema, and communicates with others through APIs. This allows developers to deploy, maintain, and scale each part of the application independently. Microservices also make debugging and testing easier, since a failure in one service doesn’t bring down the entire system (GeeksForGeeks, 2025).  
In contrast, monolithic architectures combine all the applications components such as the user interface, business logic, and database access into a single, unified codebase. This means that when a small change or update is needed, the entire application must be rebuilt and redeployed. Monolithic systems can become harder to scale and maintain as they grow, and a single bug can potentially crash the whole system. While monoliths are simpler to develop initially, they lack flexibility and scalability compared to microservice-based designs (Geeks, 2025). 
A great example of microservices in action is Netflix, which originally used a monolithic structure but transitioned to microservices to imporve scalability and reliability. Today, Netflix uses hundreds of independent services to handle user authentication, recommendations, billing, and video playback. This approach allows the company to deploy updates faster, isolate failures, and manage massive amounts of traffic efficiently (Netflix Tech Blog, 2024). Overall, microservices differ from traditional monolithic architectures by offering modularity, faster development cycles, fault isolation, and independent scalability, making them ideal for large scale, cloud-based applications.  
  
Reference(s): 

GeeksForGeeks. (2025). What are Microservices? https://www.geeksforgeeks.org/system-design/microservices/?utm_source=chatgpt.com  
Netflix Tech Blog. (2024). Rebuilding Netflix Video Processing Pipeline with Microservices. https://netflixtechblog.com/rebuilding-netflix-video-processing-pipeline-with-microservices-4e5e6310e359</p>

### 2. Research microservices. What are 5 challenges you might encounter when modifying a monolithic architecture to this architecture style?

<p>First, as a monolithic application grows, the ability to scale increases the complexity. Even a minor change in a single function can trigger the need to compile and test the entire platform, leading to an even more time-consuming process. To add, the limited agility inherent in monolithic architectures makes it difficult for developers to implement changes efficiently, contributing to slower development cycles. Moreover, the reliability of a monolithic system is compromised, as errors in any module can jeopardize the entire application’s availability. Deployment also poses challenges, as even minor updates require redeploying the entire monolith, resulting in inefficiencies and heightened risks of deployment errors. Furthermore, performance bottlenecks are common in monolithic architectures, as individual components cannot be scaled independently, leading to slower overall system performance. Addressing these challenges is extremely important for successful migration to microservice architecture.
  
Reference: 

Harris, Chandler. (2024). Atlassian. Microservices. vs monolithic architecture. Microservices vs. monolithic architecture | Atlassian. https://www.atlassian.com/microservices/microservices-architecture/microservices-vs-monolith#:~:text=Disadvantages%20of%20a%20monolithic%20architecture&text=Slower%20development%20speed%20%E2%80%93%20A%20large,affect%20the%20entire%20application's%20availability.</p>

## Conclusion

<p>This activity allowed me to explore microservices and understand how they can improve scalability, fault tolerance, and flexibility compared to traditional monolithic architectures. By implementing and testing the integration of multiple microservices (Users, Orders, and Consumer UI), I gained insight into the benefits of modular design and the challenges of managing distributed systems. The introduction of tools like Eureka for service discovery further emphasized the need for proper orchestration in a microservice-based system. Overall, transitioning to microservices can significantly enhance the performance and maintainability of large-scale applications.</p>
