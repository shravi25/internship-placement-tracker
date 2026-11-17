# Configuration Layer (`config/`)

## Purpose
The `config/` package centralizes all Spring Framework `@Configuration` classes, cross-cutting bean definitions, and infrastructure settings for the **Internship and Placement Application Tracker**.

## Developer Coordination Guidelines
Because this layer touches shared application concerns, all changes must be coordinated across the three developers:

1. **Security Configuration (`SecurityConfig`)**:
   - Owned by **Developer 1** (Authentication Lead) in consultation with the team.
   - Defines CORS configurations, CSRF protections, JWT filter registration, and public/protected endpoint matchers.

2. **JPA & Audit Configuration (`JpaConfig`)**:
   - Shared coordination.
   - Enables `@EnableJpaAuditing` for automatic `created_at` / `updated_at` timestamps.

3. **OpenAPI / Swagger Documentation (`OpenApiConfig`)**:
   - Shared coordination.
   - Defines API metadata, contact information, and security scheme schemas.

4. **Web MVC Configuration (`WebConfig`)**:
   - Shared coordination.
   - Configures global CORS mappings, formatter/converter registries, and static resource handling.

## Rules
- Do not place domain business logic or database queries inside configuration classes.
- Ensure all configuration beans use constructor injection where dependencies are needed.
- Document any new application property or bean in `docs/team-workflow.md` before merging into `develop`.
