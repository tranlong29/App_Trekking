# TrekBook VN - Client Rules & Guidelines

> **Scope:** Áp dụng riêng cho phân hệ `client/` (Next.js 14+ / React 18+, Tailwind CSS, TypeScript, Lucide Icons, Leaflet / Mapbox).

---

## 1. Kiến Trúc Thư Mục Frontend (Next.js App Router)

```text
client/
├── package.json
├── tailwind.config.ts
├── tsconfig.json
└── src/
    ├── app/                            # Next.js App Router (pages & layouts)
    │   ├── layout.tsx                  # Root Layout với Topbar Icon Nav
    │   ├── page.tsx                    # Social Feed chính (Home)
    │   ├── (auth)/                     # Login, Register
    │   ├── trails/                     # Khám phá cung đường & Chi tiết
    │   ├── profile/[username]/         # Trang cá nhân & Hộ chiếu số
    │   └── planner/                    # Lập kế hoạch chuyến đi
    ├── components/                     # Tái sử dụng components
    │   ├── common/                     # Button, Input, Modal, Avatar, Badge
    │   ├── navigation/                 # TopHeaderIconNav, Sidebar, MobileNav
    │   ├── feed/                       # PostCard, CreatePostBox, StoryCarousel
    │   ├── telemetry/                  # ElevationChart, ActivityStatsStrip
    │   └── trails/                     # TrailCard, WaypointList, CostCalculator
    ├── hooks/                          # Custom React Hooks (useAuth, useFeed, useGPX)
    ├── services/                       # API Services (Axios / Fetcher kết nối backend /api/v1/)
    ├── types/                          # TypeScript Interfaces & Models
    └── utils/                          # Formatters, Distance calculators, Constants
```

---

## 2. Quy Tắc Bắt Buộc Khi Viết Code Frontend

### 2.1. Thiết Kế & Giao Diện (Design System & Stitch Sync)
1. **Đồng bộ chuẩn thiết kế Stitch:** Toàn bộ màu sắc, typography, border-radius và bố cục phải tuân thủ chuẩn đã chốt tại Stitch project `17612405654415154371`:
   - Primary: Deep Forest Green (`#1B4332`)
   - Secondary: Vibrant Pine (`#2D6A4F`)
   - Accent/Terracotta: Burnt Amber (`#D97736`)
   - Canvas/Surface: Sand Stone (`#F6FBF4`)
2. **Top Header Icon-Only Navigation:** Thanh điều hướng trên cùng sử dụng **toàn bộ bằng Icon** (Trang chủ, Khám phá, Lên kế hoạch, Hộ chiếu số, Bạn bè/Nhóm, Bản đồ GPS), không để text menu rườm rà.
3. **Responsive Mobile-First:** Mọi component và màn hình phải hiển thị mượt mà trên cả Mobile (dưới 768px) và Desktop (trên 1024px). Trên Mobile, chuyển cụm Icon Nav xuống Bottom Bar.

### 2.2. Kết Nối API & Quản Lý Dữ Liệu
1. **API Client:** Tập trung mọi lời gọi API trong `src/services/api.ts` sử dụng `axios` với baseURL `process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080/api/v1'`.
2. **Xử lý Response:** Tự động giải nén envelope `ApiResponse<T>`:
   ```typescript
   export interface ApiResponse<T> {
     success: boolean;
     message: string;
     data: T;
     timestamp: string;
   }
   ```
3. **Xác thực JWT:** Lưu access token trong cookie `httpOnly` hoặc localStorage an toàn, tự động đính kèm header `Authorization: Bearer <token>` qua Axios Interceptor.

### 2.3. Hiệu Năng & Tối Ưu Mạng Xã Hội
1. **Tải ảnh:** Sử dụng `next/image` với `blurDataURL` hoặc CDN thumbnail tối ưu kích thước, hỗ trợ lazy-loading khi lướt feed.
2. **Infinite Scroll:** Sử dụng `IntersectionObserver` hoặc `@tanstack/react-query` (`useInfiniteQuery`) để tải feed liên tục khi người dùng cuộn trang.
3. **Client vs Server Components:** Khai báo `'use client'` rõ ràng ở đầu file khi component có tương tác state/event (như thả tim Kudos, comment, upload ảnh).
