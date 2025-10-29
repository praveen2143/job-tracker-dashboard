🚀 Job Tracker Dashboard

A full-stack Job Tracking Application built with Spring Boot (Java), ReactJS, MySQL, and Docker Compose.
This project helps users manage job applications efficiently — add, view, filter, and track statuses (Applied, Interview, Offer, Rejected) with a futuristic dashboard UI.

🧭 Table of Contents

Overview

Tech Stack

Architecture

Features

Backend Setup (Spring Boot)

Frontend Setup (ReactJS)

Docker Setup (Full Stack)

Environment Variables

API Endpoints

Sample Data

Screenshots

Future Enhancements

🧩 Overview

The Job Tracker Dashboard lets you organize and visualize your job applications in one place.
It includes a responsive, animated dashboard with filters and statistics cards, integrated with a secure Spring Boot REST API and a MySQL database.

Frontend and backend are fully containerized with Docker Compose, so setup is seamless across systems.

🛠️ Tech Stack

Frontend:

ReactJS 18

TailwindCSS

Lucide React (icons)

Framer Motion (animations)

Axios (API calls)

Backend:

Spring Boot 3.x

Java 17

Spring Data JPA

MySQL 8

Lombok

DevOps:

Docker & Docker Compose

🧱 Architecture
frontend (ReactJS)
    |
    |---> REST API (Spring Boot)
             |
             |---> MySQL Database

✨ Features

✅ Add, update, delete, and view job applications
✅ Filter by job status (Applied, Interview, Offer, Rejected)
✅ Animated dashboard with status colors and metrics
✅ Responsive layout (desktop + mobile)
✅ RESTful API with clean structure
✅ Fully Dockerized setup (MySQL + Backend + Frontend)
✅ Auto-creation of DB schema and sample data

⚙️ Backend Setup (Spring Boot)

Location: job-tracker-backend/

1️⃣ Prerequisites

Java 17+

Maven 3.9+

MySQL 8.0+ (or Docker)

2️⃣ Configure Database

Set credentials in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/jobtracker
spring.datasource.username=tracker_user
spring.datasource.password=tracker_pass
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Run the App
mvn spring-boot:run


Backend will start at http://localhost:8080

⚛️ Frontend Setup (ReactJS)

Location: job-tracker-frontend/

1️⃣ Prerequisites

Node.js 18+

npm or yarn

2️⃣ Install dependencies
npm install

3️⃣ Start development server
npm start


Frontend runs at http://localhost:3000

🐳 Docker Setup (Full Stack)

To run everything in containers:

1️⃣ Make sure docker-compose.yml exists in the root folder:

version: '3.8'

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


2️⃣ Run everything:

docker compose up --build


✅ Open:

Frontend → http://localhost:3000

Backend → http://localhost:8080/api/jobs

MySQL → localhost:3307

🔑 Environment Variables
Variable	Description	Default
MYSQL_ROOT_PASSWORD	MySQL root password	rootpass
MYSQL_DATABASE	Database name	jobtracker
MYSQL_USER	MySQL app user	tracker_user
MYSQL_PASSWORD	MySQL app user password	tracker_pass
SPRING_DATASOURCE_URL	JDBC URL	jdbc:mysql://mysql:3306/jobtracker
SPRING_JPA_HIBERNATE_DDL_AUTO	DB schema handling	update
📡 API Endpoints
Method	Endpoint	Description
GET	/api/jobs	Get all jobs
GET	/api/jobs/{id}	Get job by ID
POST	/api/jobs	Add a new job
PUT	/api/jobs/{id}	Update existing job
DELETE	/api/jobs/{id}	Delete job

Example POST body:

{
  "company": "Google",
  "position": "Senior Software Engineer",
  "title": "Full Stack Developer",
  "status": "Applied",
  "location": "Dublin, Ireland"
}

🧰 Sample Data (auto-loaded)

Add a data.sql file under src/main/resources/:

INSERT INTO job (company, position, title, status, location, applied_date)
VALUES 
('Google', 'Software Engineer', 'Backend Developer', 'Applied', 'Dublin', CURRENT_DATE()),
('Amazon', 'Frontend Engineer', 'React Developer', 'Interview', 'Berlin', CURRENT_DATE()),
('SAP', 'Full Stack Engineer', 'Java + React', 'Offer', 'Munich', CURRENT_DATE());

🖼️ Screenshots

Dashboard View
Futuristic animated UI with filters and status metrics.

Add Job Form
Simple and elegant job entry form.

🧠 Future Enhancements

✅ JWT-based authentication (Spring Security)
✅ Multi-user login
✅ Pagination and search filters
✅ Charts (Recharts integration)
✅ Export data to Excel / PDF
✅ CI/CD using GitHub Actions

👨‍💻 Author

Praveen Sakthivel
Full Stack Developer — Java | ReactJS | Spring Boot | Docker
