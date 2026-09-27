---
name: client-design-system
description: >-
  Detailed design tokens, styling rules, typography, and UI specs for TrekBook VN
  based on the Stitch project 17612405654415154371. Use this skill whenever building or
  styling UI components, navigation bars, cards, badges, and color themes.
---

# TrekBook VN - Frontend Design System & UI Specifications

Hệ thống thiết kế chuẩn hóa được đồng bộ trực tiếp từ dự án **Stitch Project ID: `17612405654415154371`**.

---

## 1. Bảng Màu Chuẩn (Color Palette Tokens)

```text
Deep Forest Green (Primary)   : #1B4332   /* Header, CTA buttons chính, Active indicators */
Vibrant Pine (Secondary)      : #2D6A4F   /* Hover states, focus rings, tag phụ */
Burnt Amber / Terracotta      : #D97736   /* Huy hiệu đỉnh, cảnh báo trail, Kudos active */
Sage Tint                     : #A3B18A   /* Tag độ khó Dễ, nền badge thảo mộc */
Sand Canvas (Base Background) : #F6FBF4   /* Màu nền dịu mắt thay cho màu trắng tinh */
Card Surface                  : #FFFFFF   /* Nền thẻ bài viết, thẻ profile */
Dark Slate (Text High Emphasis): #181D19  /* Màu chữ tiêu đề chính */
Medium Slate (Body Text)      : #414844   /* Màu chữ nội dung, thời gian */
Border Subtle                 : rgba(27, 67, 50, 0.12) /* Đường viền mỏng tự nhiên */
```

---

## 2. Typography & Fonts

- **Headlines & Display:** `Space Grotesk` (Đường nét góc cạnh, phong cách biển báo đường mòn outdoor).
- **Body & Controls:** `Plus Jakarta Sans` hoặc `Inter` (Rõ ràng, dễ đọc khi lướt feed trên di động).
- **Numbers & Telemetry:** Font dạng Tabular Figures cho độ cao, km, thời gian để các số không bị nhảy lệch hàng.

---

## 3. Quy Chuẩn Thanh Điều Hướng (Top Header Icon Nav)

Được bố trí cố định trên cùng màn hình (Sticky Header) với chiều cao 64px (h-16):

```
┌─────────────────┬───────────────────────────────────┬─────────────────┐
│ [Logo] [Search] │  [🏠]  [🧭]  [📅]  [🎖️]  [👥]  [🗺️]  │ [+ Đăng] 💬 🔔 👤│
│ (Bên trái)      │  (Cụm 6 Icon Trung Tâm Cân Xứng)  │ (Bên phải)      │
└─────────────────┴───────────────────────────────────┴─────────────────┘
```

1. **Trái:** Logo TrekBook VN + Thanh tìm kiếm bo tròn (`⌘K`).
2. **Giữa (Core Icon Nav):**
   - 🏠 **Home / Feed** (Active: Icon Forest Green `#1B4332` + gạch chân indicator).
   - 🧭 **Explore Trails** (Icon đỉnh núi/la bàn).
   - 📅 **Trip Planner** (Icon lịch trình & checklist).
   - 🎖️ **Mountain Passport** (Icon huy chương có chấm xanh thành tích).
   - 👥 **Buddies & Clubs** (Icon cộng đồng/ghép đoàn).
   - 🗺️ **GPS Maps** (Icon bản đồ vệ tinh/GPX).
   - Kích thước hit area mỗi nút: `48px x 48px`, bo góc mềm `rounded-xl`.
3. **Phải:** Nút pill `+ Đăng bài` màu xanh rừng sâu, icon tin nhắn, icon chuông thông báo (badge `3`), Avatar người dùng.

---

## 4. Quy Chuẩn Thẻ Bài Đăng Kỷ Niệm (Post Card)

- Bo góc: `rounded-2xl` (16px).
- Nền: `#FFFFFF` với border mỏng `1px solid rgba(27, 67, 50, 0.1)`.
- Hiệu ứng shadow: `shadow-sm hover:shadow-md transition-shadow`.
- Bố cục bên trong:
  - Header: Avatar (40px), Tên tác giả, Badge xác thực đỉnh (`rounded-full`, nền xanh nhạt, chữ xanh đậm), thời gian.
  - Telemetry Bar: Khung nền `#F0F5EE` bo tròn chứa 4 thông số: Cự ly (km), Độ cao tích lũy (+m), Thời lượng, Thời tiết.
  - Media Grid: 1 ảnh lớn full chiều rộng hoặc lưới 2-3 ảnh bố trí nghệ thuật.
  - Caption: Khoảng cách dòng `leading-relaxed`, font size `15px-16px`.
  - Action Bar: Nút Kudos (❤️🥾), Comment (💬), Share (🔗), Bookmark (🔖).
