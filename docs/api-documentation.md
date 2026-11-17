# REST API Specification Guidelines

## 1. API Architecture Principles
The **Internship and Placement Application Tracker** exposes a stateless RESTful Web API designed following industry best practices:
- **Transport**: HTTPS with JSON (`application/json`) payloads.
- **Base Endpoint URL**: `/api/v1`
- **Resource-Oriented URIs**: Nouns in plural form (`/api/v1/applications`, `/api/v1/skills`).
- **HTTP Methods**: Explicit semantics (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`).

---

## 2. Standard HTTP Status Codes

| Code | Status | Usage |
|---|---|---|
| `200` | `OK` | Request succeeded; returned with response payload. |
| `201` | `Created` | New resource created successfully (e.g., application submitted). |
| `204` | `No Content` | Request succeeded with no response body (e.g., successful delete). |
| `400` | `Bad Request` | Request validation failure or malformed payload. |
| `401` | `Unauthorized` | Missing or invalid authentication token. |
| `403` | `Forbidden` | Authenticated user lacks permission for the resource. |
| `404` | `Not Found` | Requested resource ID does not exist. |
| `409` | `Conflict` | State conflict (e.g., duplicate application submission, duplicate email). |
| `500` | `Internal Server Error` | Unexpected server-side failure. |

---

## 3. Standard Response Contracts

### 3.1 Unified Success Response (`ApiResponse<T>`)
```json
{
  "success": true,
  "message": "Resource retrieved successfully",
  "data": { ... },
  "timestamp": "2026-11-15T22:00:00Z"
}
```

### 3.2 Unified Paginated Response (`PageResponse<T>`)
```json
{
  "success": true,
  "message": "Applications fetched",
  "data": [ ... ],
  "pageNumber": 0,
  "pageSize": 20,
  "totalElements": 150,
  "totalPages": 8,
  "last": false,
  "timestamp": "2026-11-15T22:00:00Z"
}
```

### 3.3 Unified Error Response (`ErrorResponse`)
```json
{
  "success": false,
  "errorCode": "VALIDATION_FAILED",
  "message": "One or more input fields failed validation",
  "errors": [
    {
      "field": "email",
      "rejectedValue": "invalid-email",
      "message": "Email must be a valid email address"
    }
  ],
  "path": "/api/v1/auth/register",
  "timestamp": "2026-11-15T22:00:00Z"
}
```

---

## 4. Module Endpoint Specifications (Phase 2 Roadmap)

### 4.1 Authentication Endpoints (`/api/v1/auth`) - Developer 1
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `POST` | `/api/v1/auth/register` | Register a new user | Public |
| `POST` | `/api/v1/auth/login` | Authenticate user and issue JWT | Public |
| `POST` | `/api/v1/auth/refresh` | Refresh expired access token | Public |
| `GET` | `/api/v1/auth/me` | Fetch current user session profile | Authenticated |

### 4.2 Job & Application Endpoints (`/api/v1/applications`) - Developer 1
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/v1/applications` | List current user applications (paginated) | Student / Admin |
| `POST` | `/api/v1/applications` | Submit application for a job posting | Student |
| `GET` | `/api/v1/applications/{id}` | Retrieve specific application details | Student / Admin |
| `PATCH` | `/api/v1/applications/{id}/status` | Update application status | Admin / Recruiter |
| `GET` | `/api/v1/applications/jobs` | Browse active job postings | Student |

### 4.3 Student Profile Endpoints (`/api/v1/profile`) - Developer 2
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/v1/profile` | Get logged-in student's profile | Student |
| `PUT` | `/api/v1/profile` | Update profile details | Student |
| `POST` | `/api/v1/profile/education` | Add education record | Student |
| `DELETE` | `/api/v1/profile/education/{id}` | Remove education record | Student |

### 4.4 Skills Endpoints (`/api/v1/skills`) - Developer 2
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/v1/skills` | List all available skill master records | Authenticated |
| `GET` | `/api/v1/skills/my-skills` | Get skills linked to student | Student |
| `POST` | `/api/v1/skills/my-skills` | Add/endorse a skill to profile | Student |
| `GET` | `/api/v1/skills/match/{jobId}` | Calculate skill match percentage against job | Student |

### 4.5 Interview Endpoints (`/api/v1/interviews`) - Developer 3
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/v1/interviews` | List scheduled interviews | Student / Admin |
| `POST` | `/api/v1/interviews` | Schedule new interview round | Admin / Recruiter |
| `GET` | `/api/v1/interviews/{id}` | Get interview round details | Authenticated |
| `POST` | `/api/v1/interviews/{id}/feedback` | Submit recruiter interview feedback | Recruiter |

### 4.6 Recruiter Endpoints (`/api/v1/recruiters`) - Developer 3
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/v1/recruiters/companies` | List hiring partner companies | Authenticated |
| `POST` | `/api/v1/recruiters/companies` | Register a new company | Admin / Recruiter |
| `GET` | `/api/v1/recruiters/companies/{id}` | Get company profile and drives | Authenticated |

### 4.7 Analytics Endpoints (`/api/v1/analytics`) - Developer 3
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `GET` | `/api/v1/analytics/dashboard` | Placement summary metrics | Admin / Student |
| `GET` | `/api/v1/analytics/readiness` | Student placement readiness evaluation | Student |
| `GET` | `/api/v1/analytics/funnel` | Application stage conversion funnel | Admin |
