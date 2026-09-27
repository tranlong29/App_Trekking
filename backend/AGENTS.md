# TrekBook VN - Backend Rules & Guidelines

> **Scope:** Áp dụng riêng cho phân hệ `backend/` (Java 21 LTS, Spring Boot 3.3+, Spring Data JPA, PostgreSQL / PostGIS).

---

## 1. Kiến Trúc Phân Tầng (Layered Architecture)

Thư mục mã nguồn tuân thủ chặt chẽ cấu trúc:

```text
backend/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/trekhub/
    │   │   ├── common/                 # Standard ApiResponse, Constants, BaseAuditEntity
    │   │   ├── config/                 # SecurityConfig (JWT), SwaggerConfig, CorsConfig
    │   │   ├── controller/             # REST Endpoints (/api/v1/...)
    │   │   ├── dto/                    # Request/Response Data Transfer Objects
    │   │   │   ├── request/
    │   │   │   └── response/
    │   │   ├── entity/                 # JPA Entities
    │   │   ├── enums/                  # SportCategory, DifficultyLevel, BadgeType...
    │   │   ├── exception/              # GlobalExceptionHandler, CustomExceptions
    │   │   ├── mapper/                 # MapStruct Mappers (DTO <-> Entity)
    │   │   ├── repository/             # Spring Data JPA Repositories
    │   │   └── service/                # Business Logic Interfaces & Implementations
    │   │       └── impl/
    │   └── resources/
    │       ├── application.yml         # Main config
    │       └── application-dev.yml     # Local dev profile
    └── test/                           # JUnit 5 & Mockito Tests
```

---

## 2. Quy Tắc Bắt Buộc Khi Viết Code Backend

### 2.1. Thực thể & Cơ sở dữ liệu (Entities & Database)
1. **Khóa chính:** Dùng `UUID` cho `User`, `Post`, `Comment` (bảo mật URL mạng xã hội); dùng `Long` tự tăng cho danh mục tĩnh như `Trail`, `Badge`.
2. **Auditing:** Mọi bảng nghiệp vụ kế thừa `BaseAuditEntity` (`createdAt`, `updatedAt`, `createdBy`).
3. **Soft Delete:** Không xóa cứng bài đăng (`Post`) hay kế hoạch (`TripPlan`), luôn dùng cờ `deleted = true`.
4. **Hiệu năng Mạng xã hội:**
   - Đánh chỉ mục (`@Index`) trên: `author_id`, `created_at`, `tagged_trail_id`, `sport_category`.
   - **Bắt buộc phân trang (`Pageable`)** cho mọi API danh sách (Feed, Comments, Trails). Nghiêm cấm `.findAll()`.
   - Tránh lỗi N+1 Query: Sử dụng `@EntityGraph` hoặc `JOIN FETCH` khi lấy bài viết kèm ảnh và thông tin tác giả.

### 2.2. RESTful API & DTOs
1. **URI Versioning:** Tất cả endpoints bắt đầu bằng `/api/v1/`.
2. **Envelope:** Mọi response API phải bọc trong `ApiResponse<T>`.
3. **Data Validation:** Sử dụng `jakarta.validation.constraints` (`@NotBlank`, `@NotNull`, `@Size`, `@Min`) trong mọi Request DTO.
4. **Exception Handling:** Xử lý tập trung qua `@RestControllerAdvice`, trả về format RFC 7807 (`ProblemDetail`). Không bao giờ làm lộ stack trace ra ngoài.

### 2.3. Khả Năng Mở Rộng Đa Môn Thể Thao
- Mọi hoạt động thể thao đều chứa thuộc tính `SportCategory`:
  ```java
  public enum SportCategory {
      TREKKING, TRAIL_RUNNING, CAMPING, CYCLING, PADDLING
  }
  ```

### 2.4. Xác Thực & Biên Dịch
- Trước khi hoàn thành một task ở backend, AI phải chạy `mvn clean test` hoặc `mvn compile` để kiểm tra độ tin cậy của mã nguồn.
