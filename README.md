# 🌱 SPRING_PART_1

This repository contains all the core Spring Framework concepts and assignments I explored while learning **Spring Part 1**. The projects are structured around annotation-based configuration, XML configuration, dependency injection, Spring Data JPA, and more.

---

## 📚 Topics Covered

### 🔸 Assignments
- **Assig_1**: Basic Spring Core assignment with manual bean configuration.
- **Assig_2**: Dependency injection and component scanning.
- **Assig_3**: Spring container types and lifecycle methods.

### 🔸 Core Spring Concepts
- **AutoWiringDemo**: Demonstrates different types of autowiring (`byType`, `byName`, `constructor`).
- **basicdemo_yml**: Basic Spring Boot project using `application.yml` for configuration.
- **BasicXMLdemo**: Bean configuration using XML instead of annotations.
- **componentDemo**: Showcases use of `@Component`, `@Autowired`, `@Service`, and `@Repository`.

### 🔸 Spring Data JPA & CRUD
- **curddemo_JPA**: JPA-based project implementing basic CRUD operations.
- **jpacruddemo**: Extended version of JPA CRUD with custom queries and pagination.
- **jpaEntitydemo**: Entity relationship mapping and JPA features.

### 🔸 Advanced JPA & Entity Mapping
- **customerRelationship**: Demonstrates One-to-One, One-to-Many, Many-to-One, and Many-to-Many relationships.
- **mappingdemo**: Practice with JPA annotations like `@JoinColumn`, `@MappedBy`, etc.

### 🔸 Lombok Integration
- **dataDemo**: JPA with standard getters, setters, constructors.
- **dataDemo_Lombok**: Same as `dataDemo`, but using Lombok annotations like `@Data`, `@NoArgsConstructor`, etc.

### 🔸 Miscellaneous
- **myDemo**: Custom playground to try out concepts.
- **WiringDemo**: Manual vs. automatic bean wiring demonstration.

---

## 🛠️ Requirements

- Java 17+
- Spring Boot 3.x+
- Maven or Gradle
- IDE: IntelliJ IDEA / VS Code

---

## 📦 How to Run

Each sub-project can be opened and run independently.

```bash
cd <project-name>
mvn spring-boot:run
