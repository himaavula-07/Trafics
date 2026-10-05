# Smart Traffic Light Ambulance Prioritization

College full-stack project based on the provided problem statement.

## Stack
- Java 17+
- Spring Boot
- REST API
- Spring Data JPA / Hibernate
- MySQL
- React + Vite
- Git/GitHub

## Features
1. Register/store ambulance details.
2. Display ambulance route and current status.
3. Display traffic signals.
4. Activate ambulance priority.
5. Automatically mark matching route signals as GREEN/priority.
6. Responsive dashboard with success/error state.

## Run backend
1. Install Java 17+ and Maven.
2. Start MySQL.
3. Default database settings are in `backend/src/main/resources/application.properties`.
4. Change `DB_USER` and `DB_PASSWORD` if needed.
5. Run:
   `cd backend`
   `mvn spring-boot:run`

Backend: http://localhost:8080

## Run frontend
1. Install Node.js.
2. Run:
   `cd frontend`
   `npm install`
   `npm run dev`

Frontend: http://localhost:5173

## API endpoints
- GET `/api/ambulances`
- POST `/api/ambulances`
- GET `/api/signals`
- PUT `/api/signals/{id}/priority?enabled=true`
- POST `/api/ambulances/{id}/prioritize`

## Example ambulance JSON
{
  "ambulanceId":"AMB-102",
  "currentLocation":"Main Road",
  "destination":"City Hospital",
  "route":"Main Road -> Hospital Road"
}

## GitHub
Create one repository and push both `backend` and `frontend` folders. Keep meaningful commits and this README.
