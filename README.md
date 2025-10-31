# 🚀 Job Tracker Dashboard

A full-stack **Job Tracking Application** built to help you manage job applications efficiently. Organize, track, and visualize applications with a sleek, futuristic dashboard UI.

---

## 📖 Overview

The **Job Tracker Dashboard** lets you add, view, filter, and track job applications with statuses like *Applied*, *Interview*, *Offer*, and *Rejected*. It features a responsive frontend, secure REST API, and a fully containerized setup using Docker Compose.

---

## 🛠️ Tech Stack

| **Frontend**              | **Backend**               | **DevOps**            |
|---------------------------|---------------------------|-----------------------|
| ReactJS 18                | Spring Boot 3.x           | Docker & Docker Compose |
| TailwindCSS               | Java 17                   |                       |
| Lucide React (icons)      | Spring Data JPA           |                       |
| Framer Motion (animations)| MySQL 8                   |                       |
| Axios (API calls)         | Lombok                    |                       |

---

## 🧱 Architecture
Frontend (ReactJS) ↔ REST API (Spring Boot) ↔ MySQL Database
text---

## ✨ Features

- ✅ Add, update, delete, and view job applications
- ✅ Filter by status (*Applied*, *Interview*, *Offer*, *Rejected*)
- ✅ Animated dashboard with status metrics
- ✅ Responsive design (desktop + mobile)
- ✅ RESTful API with clean structure
- ✅ Fully containerized with Docker
- ✅ Auto-generated DB schema and sample data

---

## ⚙️ Setup Instructions

### Backend (Spring Boot)
*Location*: `job-tracker-backend/`

1. **Prerequisites**:
   - Java 17+
   - Maven 3.9+
   - MySQL 8.0+ (or use Docker)

2. **Configure Database**:
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/jobtracker
   spring.datasource.username=tracker_user
   spring.datasource.password=tracker_pass
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

Run:
bashmvn spring-boot:run
Backend runs at http://localhost:8080.

### Frontend (ReactJS)
Location: job-tracker-frontend/

1.**Prerequisites:**

Node.js 18+
npm or yarn


2.**Install Dependencies:**
bashnpm install

Run:
bashnpm start
Frontend runs at http://localhost:3000.

### Docker (Full Stack)
Run the entire application with Docker Compose.

Ensure docker-compose.yml is in the root folder:
```bash
yamlversion: '3.8'
services:
  mysql:
    image: mysql:8.0
    container_name: jobtracker-mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: rootpass
      MYSQL_DATABASE: jobtracker
      MYSQL_USER: tracker_user
      MYSQL_PASSWORD: tracker_pass
    ports:
      - "3307:3306"
    volumes:
      - mysql_data:/var/lib/mysql
    networks:
      - jobtracker-net

  backend:
    build: ./job-tracker-backend
    container_name: jobtracker-backend
    depends_on:
      - mysql
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/jobtracker
      SPRING_DATASOURCE_USERNAME: tracker_user
      SPRING_DATASOURCE_PASSWORD: tracker_pass
      SPRING_JPA_HIBERNATE_DDL_AUTO: update
    ports:
      - "8080:8080"
    networks:
      - jobtracker-net

  frontend:
    build: ./job-tracker-frontend
    container_name: jobtracker-frontend
    depends_on:
      - backend
    ports:
      - "3000:80"
    networks:
      - jobtracker-net

networks:
  jobtracker-net:
volumes:
  mysql_data:

Run:
bash docker compose up --build
```
### Access: 

Frontend: http://localhost:3000
Backend: http://localhost:8080/api/jobs
MySQL: localhost:3307

## 🚀 How to Build & Run

```bash
docker compose up --build -d
```
Then visit:

Frontend → http://localhost

API → http://localhost/api/jobs

DB → MySQL localhost:3306 (user: user, password: password)

##📡 API Endpoints

MethodEndpointDescription
GET/api/jobs
Get all jobs
GET/api/jobs/{id}
Get job by ID
POST/api/jobsAdd a new job
PUT/api/jobs/{id}
Update existing job
DELETE/api/jobs/{id}
Delete job

##Example POST Body:
json{
  "company": "Google",
  "position": "Senior Software Engineer",
  "title": "Full Stack Developer",
  "status": "Applied",
  "location": "Dublin, Ireland"
}

##🧰 Sample Data
Auto-loaded via src/main/resources/data.sql:
sqlINSERT INTO job (company, position, title, status, location, applied_date)
VALUES 
  ('Google', 'Software Engineer', 'Backend Developer', 'Applied', 'Dublin', CURRENT_DATE()),
  ('Amazon', 'Frontend Engineer', 'React Developer', 'Interview', 'Berlin', CURRENT_DATE()),
  ('SAP', 'Full Stack Engineer', 'Java + React', 'Offer', 'Munich', CURRENT_DATE());

##🖼️ Screenshots
Dashboard View
Futuristic UI with filters and status metrics.
<img width="1915" height="938" alt="image" src="https://github.com/user-attachments/assets/c069da31-20c5-496e-af31-62989818644a" />

Add Job Form
Simple and elegant job entry form.
<img width="1916" height="954" alt="image" src="https://github.com/user-attachments/assets/79f8bddf-1b76-4e7f-bce1-e7c03d28fa50" />


🧠 Future Enhancements

🔒 JWT-based authentication (Spring Security)
👥 Multi-user login
📄 Pagination and advanced search filters
📊 Charts (Recharts integration)
📤 Export data to Excel/PDF
🚀 CI/CD with GitHub Actions


👨‍💻 Author
Praveen Sakthivel
Full Stack Developer | Java | ReactJS | Spring Boot | Docker
