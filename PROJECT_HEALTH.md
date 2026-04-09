# Project Health Check

**Last updated**: 2026-04-09  
**Verdict**: Fully runnable via Docker — all blocking issues resolved

---

## Summary

| Component | Status | Severity |
|-----------|--------|----------|
| Project Structure (Hexagonal) | PASS | — |
| pom.xml Dependencies | PASS | — |
| Main Entry Point | PASS | — |
| application.properties | PASS | — |
| OpenAPI Spec (`api/clientApi.yml`) | PASS | — |
| GraphQL Schema + UI | PASS | — |
| gRPC Proto + Code Generation | PASS | — |
| WebSocket (STOMP) Config | PASS | — |
| Docker Build | PASS | — |
| Database Config (H2) | PASS | — |
| Test Coverage | MISSING | Medium |

---

## Resolved Issues (previously blocking)

### 1. gRPC protobuf version mismatch
`protoc` was pinned at `3.6.1` and `protoc-gen-grpc-java` at `1.22.1`, while the runtime
`grpc-spring-boot-starter:5.0.0` ships grpc `1.51.0` → protobuf-java `3.21.7`.
Generated code called `GeneratedMessageV3.isStringEmpty()` which doesn't exist in the
runtime jar at the old pin, causing a compile-time failure.

**Fixed**: aligned to compatible versions in `pom.xml`:
- `protobuf.version` → `3.21.12`
- `grpc.version` → `1.51.0`
- Added explicit `protobuf-java:3.21.12` dependency to override the transitive `3.21.7`

### 2. Missing `spring-boot-maven-plugin`
`mvn package` produced a plain jar with no `Main-Class` manifest. The container started
but immediately exited with `no main manifest attribute, in app.jar`.

**Fixed**: added `spring-boot-maven-plugin` to `pom.xml` with the `repackage` goal.

### 3. GraphiQL stuck on "Loading..."
Spring Boot 3.0.4's auto-configured GraphiQL template loads graphiql from
`https://unpkg.com/graphiql` with **no version pin**, pulling the latest (3.x). The
template was written for the graphiql 1.x/2.x API (React 16 + `ReactDOM.render()`),
which graphiql 3.x removed. The `#graphiql` div never rendered past "Loading...".

**Fixed**: disabled built-in GraphiQL (`spring.graphql.graphiql.enabled=false`),
replaced with `static/graphiql.html` using pinned compatible versions
(React 17 + GraphiQL 2.4.7) and an explicit HTTP-only fetcher.

---

## Remaining Warnings (non-blocking)

| # | Issue | Location |
|---|-------|----------|
| 1 | No tests exist | `src/test/` is absent |
| 2 | OpenAPI generator `sourceFolder` is `src/java/main` (typo; should be `src/main/java`) | `pom.xml` openapi-generator config |
| 3 | `javax.annotation-api:1.3.2` declared alongside Jakarta — redundant in Spring Boot 3 | `pom.xml` |
| 4 | MySQL connector pinned at `8.0.28` (outdated) | `pom.xml` |
| 5 | WebSocket CORS origin hardcoded to `http://localhost:8080` | `WebSocketConfig.java` |
| 6 | `log4j.util.Strings` imported but log4j not explicitly declared — resolves transitively | `ClientService.java`, `ClientAdapter.java` |

---

## How to Run

### Docker (recommended)

```bash
docker compose up --build
```

### Local (requires Java 17 + Maven)

```bash
mvn clean package
java -jar target/spring-boot-backend-apirest-0.0.1-SNAPSHOT.jar
```

---

## Available Endpoints

| Endpoint | URL | Notes |
|----------|-----|-------|
| REST API | http://localhost:8080/clients | Full CRUD |
| Swagger UI | http://localhost:8080/swagger-ui/index.html | OpenAPI 3 docs |
| GraphQL | http://localhost:8080/graphql | POST only |
| GraphiQL | http://localhost:8080/graphiql.html | Interactive UI |
| H2 Console | http://localhost:8080/h2-console | JDBC URL: `jdbc:h2:mem:db_springboot_backend` |
| gRPC | localhost:9090 | `createClient` RPC |
| WebSocket | ws://localhost:8080/cli | STOMP over SockJS |
