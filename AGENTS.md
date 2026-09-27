# TrekBook VN (TrekHub) - Monorepo Master Guidelines

> **Project Identity:** Mạng Xã Hội Thể Thao Ngoài Trời (Outdoor Social Network) chuyên sâu về Trekking, Leo núi, Chinh phục đỉnh cao tại Việt Nam (sẵn sàng mở rộng sang Trail Running, Cycling, Camping).

---

## 1. Monorepo Structure Overview

Dự án được phân tách hoàn toàn thành 2 phân hệ độc lập: `client` (Giao diện Web/Frontend) và `backend` (Dịch vụ API & Dữ liệu), mỗi bên có quy chuẩn (Rule), kỹ năng (Skill) và luồng xử lý (Workflow) riêng:

```text
d:\Projects\App_Trekking\
├── AGENTS.md                           # Root Orchestration Rules cho toàn bộ dự án
├── backend/                            # Phân hệ Backend API (Java 21, Spring Boot 3.3+)
│   ├── .agents/skills/
│   │   ├── backend-development-workflow/
│   │   │   └── SKILL.md                # Quy trình tạo REST API, Entity, Service, Testing
│   │   └── backend-domain-architecture/
│   │       └── SKILL.md                # Đặc tả chi tiết các miền nghiệp vụ & DB Entities
│   ├── AGENTS.md                       # Backend Rules bắt buộc
│   ├── pom.xml                         # Maven dependencies
│   └── src/                            # Mã nguồn Java
└── client/                             # Phân hệ Frontend Web (Next.js 14+ / React, Tailwind)
    ├── .agents/skills/
    │   ├── client-development-workflow/
    │   │   └── SKILL.md                # Quy trình tạo Component, Page, API Client
    │   └── client-design-system/
    │       └── SKILL.md                # Hệ thống thiết kế TrekHub, Stitch tokens, Icons
    ├── AGENTS.md                       # Frontend Rules bắt buộc
    ├── package.json                    # NPM dependencies
    └── src/                            # Mã nguồn Next.js / React
```

---

## 2. API Contract & Giao Tiếp Client - Backend

1. **Giao thức:** RESTful JSON qua HTTP/HTTPS. Mọi endpoint đều bắt đầu bằng `/api/v1/`.
2. **Chuẩn Envelope chung:** Tất cả phản hồi từ Backend gửi sang Client đều bọc trong format:
   ```json
   {
     "success": true,
     "message": "Thông điệp phản hồi thân thiện",
     "data": { ... },
     "timestamp": "2026-09-27T15:30:00Z"
   }
   ```
3. **Xác thực:** Stateless JWT gửi qua header `Authorization: Bearer <token>`.
4. **CORS:** Backend cấu hình CORS cho phép `http://localhost:3000` (Dev Client) và domain production.

---

## 3. Quy Tắc Vận Hành Đa Phân Hệ Dành Cho AI & Developers

- Khi làm việc trong thư mục `backend/`, AI phải đọc và tuân thủ nghiêm ngặt [backend/AGENTS.md](file:///d:/Projects/App_Trekking/backend/AGENTS.md).
- Khi làm việc trong thư mục `client/`, AI phải đọc và tuân thủ nghiêm ngặt [client/AGENTS.md](file:///d:/Projects/App_Trekking/client/AGENTS.md).
- Không được viết lẫn code Java vào thư mục `client/` hoặc code React/JS vào `backend/`.
