
# Activity 3
### Bruce Brown
### Grand Canyon University CST-339
### Professor Bobby Estey
### 9/21/2025

---

## Part 1



<p><b>1. Screenshot showing console log from OrdersBusinesService method being called.</b></p>
<img width="623" height="316" alt="image" src="https://github.com/user-attachments/assets/f475885c-1e9a-4768-b06a-215fe6e908d1"/>

---

<p><b>2. Console output for AnotherOrdersBusinesService</b></p>
<img width="625" height="343" alt="image" src="https://github.com/user-attachments/assets/7bcd2a0c-75c3-463d-ae71-3d40b4413bad" />

---

<p><b>3. Console output for SecurityBusinesService</b></p>
<img width="627" height="343" alt="image" src="https://github.com/user-attachments/assets/71fb7a12-8862-42f5-a2da-2931dc6c9bb9" />

---

<p><b>4. Orders Page</b></p>
<img width="570" height="630" alt="image" src="https://github.com/user-attachments/assets/b9e27957-6490-4afe-aae2-774129f89c45" />

---

## Part 2

<p><b>Prototype Scope:</b></p>
<p>The OrdersBusinessService bean is defined with <code>@Scope("prototype")</code>, which tells Spring to create a new instance of the bean every time it is requested. The console shows the `init()` method being called each time a new instance is created. This demonstrates loose coupling and dependency injection: the controller gets a fresh instance without affecting other parts of the application. The `destroy()` method is not automatically called for prototype beans, as Spring does not manage their full lifecycle.</p>
<img width="622" height="331" alt="image" src="https://github.com/user-attachments/assets/77765ab3-b884-469b-bf8f-2075fb8ac555" />

---

<p><b>Request Scope:</b></p>
<p>The OrdersBusinessService bean is defined with <code>@RequestScope</code>, meaning a new instance is created for each HTTP request. The console shows `init()` called once per request. This allows the service to be request-specific while still using dependency injection. Loose coupling is maintained because each controller gets its own instance for the request, preventing state sharing between requests.</p>
<img width="624" height="138" alt="image" src="https://github.com/user-attachments/assets/e85ce528-e1d5-4d2f-9d4f-4e6f85ea7210" />

---

<p><b>Session Scope:</b></p>
<p>The OrdersBusinessService bean is defined with <code>@SessionScope</code>, creating one instance per user session. The console shows `init()` being called only once for each browser session, regardless of how many times the login form is submitted. This scope allows user-specific state to be maintained across multiple requests while keeping services loosely coupled.</p>
<img width="463" height="166" alt="image" src="https://github.com/user-attachments/assets/80655667-709b-475e-bf13-52126f84acee" />

---

<p><b>Singleton Scope:</b></p>
<p>The OrdersBusinessService bean uses the default singleton scope, meaning Spring creates only one instance for the entire application context. The console shows `init()` called once when the application starts. Singleton scope ensures efficient resource usage and consistent shared state. Dependency injection and loose coupling allow multiple controllers to share the same service instance without manually creating it.</p>
<img width="624" height="106" alt="image" src="https://github.com/user-attachments/assets/7a86ca5c-110e-4afb-a91f-598312b2dbbe" />

---

## Part 3

<p><b>1. Formatted JSON displayed in browser</b></p>
<img width="563" height="247" alt="image" src="https://github.com/user-attachments/assets/65bc7236-9d9e-495f-9dbe-38e6939c739e" />

---

<p><b>2. XML displaying in browser</b></p>
<img width="282" height="620" alt="image" src="https://github.com/user-attachments/assets/a83f5dd8-2d8a-4d5f-9d4e-60cc5932c7c0" />

---

<p><b>3. PostMan SS of Get URL to Service/GetJSON</b></p>
<img width="573" height="666" alt="image" src="https://github.com/user-attachments/assets/f0935658-711a-4548-941a-ea38a636b0ab" />

---

<p><b>4. PostMan showcasing the Get Service/XML and showing list</b></p>
<img width="627" height="644" alt="image" src="https://github.com/user-attachments/assets/547c8c6d-88d6-49d5-831e-8aef647cf492" />
