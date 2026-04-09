# Spring Boot 3 — OpenAPI & GraphQL Demo

A multi-transport backend template demonstrating four communication patterns in a single Spring Boot 3 application, structured with hexagonal (ports & adapters) architecture.

## Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3.0.4 |
| Build | Maven |
| Database | H2 (in-memory, default) / MySQL |
| ORM | Spring Data JPA + Hibernate |
| Mapping | MapStruct + Lombok |

## Communication Patterns

| Pattern | Library | Port |
|---------|---------|------|
| REST + OpenAPI 3 | springdoc-openapi + openapi-generator | 8080 |
| GraphQL | spring-boot-starter-graphql | 8080 |
| gRPC | grpc-spring-boot-starter (lognet) + protobuf | 9090 |
| WebSocket | Spring WebSocket (STOMP over SockJS) | 8080 |
| Retry | Spring Retry (`@Retryable`, `@Recover`) | 8080 |

## Architecture

```
src/main/java/com/template/springboot/backend/
├── domain/
│   ├── model/          # Client, Item domain entities
│   ├── port/           # Inbound/outbound port interfaces
│   ├── service/        # ClientService (business logic)
│   └── exception/      # Domain exceptions
├── inbound/
│   ├── client/
│   │   ├── rest/       # ClientRestController (OpenAPI-generated interface)
│   │   ├── graphql/    # ClientQlController (@QueryMapping, @MutationMapping)
│   │   └── grpc/       # ClientGrpcController (protobuf-generated stub)
│   ├── item/
│   └── config/         # WebSocketConfig, exception handlers
└── outbound/
    ├── client/         # ClientEntity, ClientRepository, ClientAdapter
    └── item/           # ItemEntity, ItemRepository
```

## Quick Start

### Docker (no local tooling required)

```bash
docker compose up --build
```

### Local

```bash
# Requires Java 17 and Maven
mvn clean package
java -jar target/spring-boot-backend-apirest-0.0.1-SNAPSHOT.jar
```

The app starts in ~5 seconds and seeds the H2 database automatically from `src/main/resources/data.sql` (12 clients, 10 items).

## Endpoints

| Endpoint | URL |
|----------|-----|
| REST API | http://localhost:8080/clients |
| Swagger UI | http://localhost:8080/swagger-ui/index.html |
| GraphQL | http://localhost:8080/graphql (POST) |
| GraphiQL | http://localhost:8080/graphiql.html |
| H2 Console | http://localhost:8080/h2-console |
| gRPC | localhost:9090 |
| WebSocket | ws://localhost:8080/cli |

**H2 Console credentials**
- JDBC URL: `jdbc:h2:mem:db_springboot_backend`
- Username: `root`
- Password: `password`

## API Examples

### REST

```bash
# List all clients
curl http://localhost:8080/clients

# Create a client
curl -X POST http://localhost:8080/clients \
  -H "Content-Type: application/json" \
  -d '{"name":"Jane","lastName":"Doe","email":"jane@example.com"}'
```

### GraphQL

```graphql
# Query
{ clients { id name lastName email items { id itemName } } }

# Mutation
mutation {
  addClient(clientInput: {
    name: "Jane"
    lastName: "Doe"
    email: "jane@example.com"
    createAt: "2024-01-01T00:00"
  }) { id name }
}
```

### gRPC

The `ClientService` proto defines one unary RPC:

```protobuf
service ClientService {
  rpc createClient(ClientRequest) returns (ClientResponse);
}
```

Test with [grpcurl](https://github.com/fullstorydev/grpcurl) or any gRPC client pointed at `localhost:9090`.

### WebSocket (STOMP)

Connect to `ws://localhost:8080/cli` using SockJS + STOMP. The broker prefix is `/topic` and the application prefix is `/app`.

### Spring Retry

```bash
# Triggers retry logic (retries 3x, then throws)
curl http://localhost:8080/retry-only

# Triggers retry with recovery fallback
curl http://localhost:8080/retry-with-recover
```

## OpenAPI Code Generation

REST interfaces and DTOs are generated from `api/clientApi.yml` at compile time via `openapi-generator-maven-plugin`. To regenerate:

```bash
mvn generate-sources
```

## Project Health

See [PROJECT_HEALTH.md](PROJECT_HEALTH.md) for a full audit of resolved issues, remaining warnings, and build notes.
