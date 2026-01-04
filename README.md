# Library Management System – Backend

A secure backend REST API for a Library Management System built using **Java and Spring Boot**, implementing **JWT-based authentication** and **role-based access control**.

---

## 🔧 Tech Stack
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- MySQL
- Maven

---

## ✨ Features
- User registration and login with JWT authentication
- Role-based access control (ADMIN / USER)
- Secure RESTful APIs
- Book management (Add, Update, Delete, View)
- Book issue and return functionality
- Global exception handling
- Proper HTTP status codes and validation
- Clean controller–service–repository architecture

---

## 🔐 Authentication & Authorization
- JWT token is generated on successful login
- Token must be passed in request headers for protected endpoints


---

## 👥 User Roles

### 👑 Admin
- Add, update, delete books
- View all users
- View all issued books

### 👤 User
- View available books
- Issue books
- Return issued books

---

## 📌 API Endpoints

### 🔑 User Controller
- `POST /user/register` – Register a new user
- `POST /user/login` – Login and receive JWT token
- `GET /user/profile` – Get logged-in user details

### 📘 Book Controller
- `GET /books` – View all books
- `GET /books/{id}` – View book by ID
- `POST /books` – Add a book (Admin only)
- `PUT /books/{id}` – Update a book (Admin only)
- `DELETE /books/{id}` – Delete a book (Admin only)

### 📄 Issuer Controller
- `POST /issue/{bookId}` – Issue a book
- `POST /return/{bookId}` – Return a book
- `GET /issued` – View issued books for logged-in user

### 🛡️ Admin Controller
- `GET /admin/users` – View all users
- `GET /admin/issued-books` – View all issued books

---

## 🗄️ Database
- MySQL database
- JPA entities with proper relationships
- Spring Data JPA for data persistence

