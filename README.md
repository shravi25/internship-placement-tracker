# Internship and Placement Application Tracker

A modern, robust Spring Boot web backend designed to streamline student campus placements, internship applications, interview lifecycle tracking, recruiter relationship management, and placement readiness analytics.

---

## Technology Stack

- **Language**: Java 21 (LTS)
- **Framework**: Spring Boot 3.5.x
- **Build Tool**: Maven (with included Maven Wrapper `mvnw` / `mvnw.cmd`)
- **Database**: MySQL 8.x
- **Persistence**: Spring Data JPA / Hibernate
- **Validation**: Jakarta Validation / Spring Validation
- **Security**: Spring Security (JWT-ready infrastructure)
- **Utilities**: Project Lombok, Spring Boot DevTools
- **Testing**: JUnit 5, Mockito, Spring Boot Test
- **Documentation**: Markdown specifications under `docs/`

---

## Project Structure

```text
internship-placement-tracker/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── placementtracker/
│   │   │           │
│   │   │           ├── InternshipPlacementTrackerApplication.java  # Spring Boot Main Entry Point
│   │   │           │
│   │   │           ├── config/          # Central configuration & beans (README.md)
│   │   │           │
│   │   │           ├── auth/            # Authentication & RBAC (Developer 1)
│   │   │           │   ├── controller/
│   │   │           │   ├── service/
│   │   │           │   ├── repository/
│   │   │           │   ├── entity/
│   │   │           │   └── dto/
│   │   │           │
│   │   │           ├── application/     # Job & Internship Applications (Developer 1)
│   │   │           │   ├── controller/
│   │   │           │   ├── service/
│   │   │           │   ├── repository/
│   │   │           │   ├── entity/
│   │   │           │   └── dto/
│   │   │           │
│   │   │           ├── profile/         # Student Profiles & Academics (Developer 2)
│   │   │           │   ├── controller/
│   │   │           │   ├── service/
│   │   │           │   ├── repository/
│   │   │           │   ├── entity/
│   │   │           │   └── dto/
│   │   │           │
│   │   │           ├── skills/          # Skills & Match Analysis (Developer 2)
│   │   │           │   ├── controller/
│   │   │           │   ├── service/
│   │   │           │   ├── repository/
│   │   │           │   ├── entity/
│   │   │           │   └── dto/
│   │   │           │
│   │   │           ├── interview/       # Interview Rounds & Feedback (Developer 3)
│   │   │           │   ├── controller/
│   │   │           │   ├── service/
│   │   │           │   ├── repository/
│   │   │           │   ├── entity/
│   │   │           │   └── dto/
│   │   │           │
│   │   │           ├── recruiter/       # Companies & Recruiter Contacts (Developer 3)
│   │   │           │   ├── controller/
│   │   │           │   ├── service/
│   │   │           │   ├── repository/
│   │   │           │   ├── entity/
│   │   │           │   └── dto/
│   │   │           │
│   │   │           ├── analytics/       # Readiness & Placement Funnels (Developer 3)
│   │   │           │   ├── controller/
│   │   │           │   ├── service/
│   │   │           │   └── dto/
│   │   │           │
│   │   │           ├── common/          # Shared Exceptions, Envelopes & Utils
│   │   │           │   ├── exception/
│   │   │           │   ├── response/
│   │   │           │   └── util/
│   │   │           │
│   │   │           └── enums/           # Shared Domain Enums
│   │   │
│   │   └── resources/
│   │       ├── application.properties       # Base settings & active profile
│   │       ├── application-dev.properties   # Local development configuration
│   │       ├── application-prod.properties  # Production configuration
│   │       │
│   │       ├── static/                      # Static web assets
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   ├── images/
│   │       │   └── assets/
│   │       │
│   │       └── templates/                   # HTML templates
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── placementtracker/
│                   ├── InternshipPlacementTrackerApplicationTests.java
│                   ├── auth/
│                   ├── application/
│                   ├── interview/
│                   ├── profile/
│                   ├── skills/
│                   ├── analytics/
│                   └── recruiter/
│
├── docs/
│   ├── architecture.md       # Layered architecture, design principles, diagrams
│   ├── database-design.md    # MySQL schema design, ER model, table specifications
│   ├── api-documentation.md  # REST API guidelines, response schemas, planned routes
│   └── team-workflow.md      # Team ownership, Git branching, PR review checklist
│
├── .gitignore                # Comprehensive Git ignore rules
├── .env.example              # Environment variables template
├── pom.xml                   # Maven build and dependency configuration
├── mvnw                      # Maven Wrapper shell script (Linux / macOS)
├── mvnw.cmd                  # Maven Wrapper batch script (Windows)
└── README.md                 # Project documentation
```

---

## Team Module Ownership

| Developer | Assigned Modules | Focus Areas |
|---|---|---|
| **Developer 1** | `auth/`, `application/` | User authentication, RBAC, JWT, internship/job application tracking, status lifecycle |
| **Developer 2** | `profile/`, `skills/` | Student profiles, academic records, skill taxonomy, job skill gap matching |
| **Developer 3** | `interview/`, `recruiter/`, `analytics/` | Interview rounds, recruiter directory, placement readiness scoring, conversion analytics |
| **Shared** | `config/`, `common/`, `enums/` | Cross-cutting infrastructure, exception handling, shared domain enums, security filter chain |

See [docs/team-workflow.md](file:///c:/Users/shrav/OneDrive/Desktop/projects/JSF_project/internship-placement-tracker/docs/team-workflow.md) for full team guidelines and branching policies.

---

## Getting Started

### Prerequisites
1. **Java Development Kit (JDK)**: Java 21 or higher installed and on `PATH` (or configured via `JAVA_HOME`).
2. **Git**: Installed for version control.
3. **IDE**: IntelliJ IDEA, VS Code, or Eclipse with Java extension pack and Lombok plugin enabled.
4. **MySQL Database**: (Required in Phase 2 for feature development).

### Environment Setup
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd internship-placement-tracker
   ```
2. Copy the environment template:
   ```bash
   cp .env.example .env
   ```
3. Update `.env` with your local database credentials when ready for Phase 2 database integration.

---

## Build and Run Instructions

### 1. Build the Project
Use the included Maven Wrapper:

**On Windows:**
```cmd
mvnw.cmd clean compile
```

**On Linux / macOS:**
```bash
./mvnw clean compile
```

### 2. Run Integration Tests
```bash
./mvnw clean test
```

### 3. Package Application (JAR)
```bash
./mvnw clean package
```

### 4. Run the Application
```bash
./mvnw spring-boot:run
```

*Note: At this foundational stage, database and security auto-configurations are safely bypassed, allowing the application to build, run tests, and boot up cleanly on port 8080 without requiring an active MySQL instance.*

---

## Documentation Index
- [Architecture & Layers](file:///c:/Users/shrav/OneDrive/Desktop/projects/JSF_project/internship-placement-tracker/docs/architecture.md)
- [Database Design & Schema](file:///c:/Users/shrav/OneDrive/Desktop/projects/JSF_project/internship-placement-tracker/docs/database-design.md)
- [REST API Documentation](file:///c:/Users/shrav/OneDrive/Desktop/projects/JSF_project/internship-placement-tracker/docs/api-documentation.md)
- [Team Workflow & Git Strategy](file:///c:/Users/shrav/OneDrive/Desktop/projects/JSF_project/internship-placement-tracker/docs/team-workflow.md)
- [Configuration Layer Guidelines](file:///c:/Users/shrav/OneDrive/Desktop/projects/JSF_project/internship-placement-tracker/src/main/java/com/placementtracker/config/README.md)
