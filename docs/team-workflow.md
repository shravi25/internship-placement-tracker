# Team Workflow and Collaboration Guidelines

## 1. Team Structure and Module Ownership
The project is divided across three developers to ensure independent development, minimal code merge conflicts, and well-defined accountability.

```text
Team Responsibilities Matrix
├── Developer 1: Authentication & Application Management
│   ├── auth/ (controller, service, repository, entity, dto)
│   ├── application/ (controller, service, repository, entity, dto)
│   └── Corresponding Unit & Integration Tests
│
├── Developer 2: Student Profile & Skill Management
│   ├── profile/ (controller, service, repository, entity, dto)
│   ├── skills/ (controller, service, repository, entity, dto)
│   └── Corresponding Unit & Integration Tests
│
├── Developer 3: Interviews, Recruiters & Analytics
│   ├── interview/ (controller, service, repository, entity, dto)
│   ├── recruiter/ (controller, service, repository, entity, dto)
│   ├── analytics/ (controller, service, dto)
│   └── Corresponding Unit & Integration Tests
│
└── Shared Responsibility (Cross-Team Consensus Required)
    ├── config/ (Spring Security, JPA, Web MVC beans)
    ├── common/ (exception handling, API response envelope, utils)
    ├── enums/ (shared system enumerations)
    ├── pom.xml (dependencies, build plugins)
    └── application*.properties (environment profiles)
```

---

## 2. Git Branching Strategy
The team adheres to a structured **GitHub Flow** with protected core branches:

1. **`main`**: Production-ready branch. Only merges from `develop` via approved release PRs.
2. **`develop`**: Primary integration branch where verified features converge.
3. **Feature Branches**:
   - Format: `feature/<dev-tag>-<module>-<short-description>`
   - Examples:
     - `feature/dev1-auth-jwt-implementation`
     - `feature/dev1-application-status-lifecycle`
     - `feature/dev2-profile-education-mapping`
     - `feature/dev2-skills-matching-algorithm`
     - `feature/dev3-interview-round-scheduling`
     - `feature/dev3-analytics-readiness-calculator`
4. **Bugfix Branches**:
   - Format: `bugfix/<issue-number>-<short-description>`

---

## 3. Commit Message Conventions
All commit messages must follow the **Conventional Commits** specification:

```text
<type>(<scope>): <short imperative summary>

[optional body explaining reason and context]

[optional issue reference]
```

### Allowed Types:
- `feat`: A new feature or endpoint.
- `fix`: A bug fix.
- `docs`: Documentation updates.
- `refactor`: Code reorganization without functional changes.
- `test`: Adding or updating test cases.
- `chore`: Build scripts, dependencies, configuration tweaks.

### Examples:
- `feat(auth): implement JWT token provider and validation filter`
- `feat(skills): add skill gap calculation service`
- `fix(application): resolve deadline comparison timezone bug`
- `docs(team-workflow): update pull request review criteria`

---

## 4. Pull Request & Code Review Process

### 4.1 PR Checklist
Before opening a Pull Request into `develop`, the developer must ensure:
1. Local build passes: `./mvnw clean test`
2. No merge conflicts with latest `develop`.
3. Code complies with package structure and layered architecture rules.
4. No business logic or database queries reside in controllers.
5. Jakarta Bean Validation annotations are present on all request DTOs.
6. Proper unit tests are included covering positive and negative edge cases.

### 4.2 Code Review Protocol
- Every PR requires **at least one approval** from a peer developer before merge.
- Shared code changes (`config/`, `common/`, `pom.xml`) require **two approvals**.
- Merges must be performed using **Squash and Merge** to maintain a clean Git history.

---

## 5. Conflict Resolution for Shared Files
When multiple developers need to modify shared files (such as `pom.xml` or `common/exception/GlobalExceptionHandler.java`):
1. Communicate in advance in team channels.
2. Keep additions isolated and modular (e.g., add new custom exceptions in separate files).
3. Rebase your feature branch regularly against `origin/develop`:
   ```bash
   git fetch origin
   git rebase origin/develop
   ```
