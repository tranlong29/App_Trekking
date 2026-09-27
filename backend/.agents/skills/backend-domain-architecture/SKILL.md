---
name: backend-domain-architecture
description: >-
  Detailed domain model specifications, database entities, business rules, and
  gamification logic for TrekBook VN backend. Use this skill whenever designing
  or modifying data structures, gamification badges, trail schemas, trip planning, or social interactions.
---

# TrekBook VN - Backend Domain Architecture & Data Models

Tài liệu đặc tả chi tiết các miền nghiệp vụ (Domain Models) cốt lõi của nền tảng **Mạng xã hội TrekBook VN**.

---

## 1. User & Profile Domain
- **`User` Entity:**
  - `id`: UUID (Primary Key)
  - `username`: String (Unique, e.g. `@hoang.trekker`)
  - `email`: String (Unique)
  - `fullName`: String
  - `avatarUrl`, `coverImageUrl`: String
  - `bio`: String
  - `role`: Enum `ROLE_USER`, `ROLE_GUIDE_PORTER`, `ROLE_ADMIN`
  - `summitsCount`: Integer (Số đỉnh núi đã chạm)
  - `totalElevationGain`: Double (Tổng mét leo tích lũy)
  - `totalDistanceKm`: Double (Tổng quãng đường đã đi)
  - `level`: Integer (1: Novice, 2: Explorer, 3: Master, 4: Legend)
  - Quan hệ: `followers`, `following`, `badges`.

---

## 2. Social Memory Feed Domain
- **`Post` Entity (Kỷ niệm chuyến đi - Hạt nhân Mạng xã hội):**
  - `id`: UUID
  - `author`: `User` (ManyToOne, NotNull)
  - `caption`: String (Nội dung kỷ niệm)
  - `sportCategory`: Enum `SportCategory` (`TREKKING`, `TRAIL_RUNNING`, `CAMPING`, `CYCLING`)
  - `mediaUrls`: `List<String>` (Ảnh / video dã ngoại)
  - `taggedTrail`: `Trail` (ManyToOne, Optional - Đỉnh núi gắn thẻ)
  - `distanceKm`: Double
  - `elevationGainMeters`: Double
  - `durationDays`: Integer
  - `weatherCondition`: String (ví dụ: `Biển mây 10/10, Nắng đẹp`)
  - `isSummitVerified`: Boolean
  - `kudosCount`: Integer (Lượt thả tim)
  - `commentCount`: Integer
  - `deleted`: Boolean
- **`PostKudos` & `Comment` Entity:**
  - `PostKudos`: Cặp `(postId, userId)` unique.
  - `Comment`: `id`, `postId`, `authorId`, `content`, `createdAt`.

---

## 3. Trails & Guides Domain
- **`Trail` Entity (Cơ sở dữ liệu Đỉnh núi):**
  - `id`: Long
  - `name`: String (e.g. `Đỉnh Lảo Thẩn`)
  - `slug`: String (e.g. `lao-than-y-ty`)
  - `region`: Enum `Region` (`NORTH_WEST`, `NORTH_EAST`, `CENTRAL_HIGHLANDS`, `SOUTH`)
  - `peakElevation`: Integer (2860m)
  - `elevationGain`: Integer (1150m)
  - `distanceKm`: Double (16.2km)
  - `difficultyLevel`: Enum `DifficultyLevel` (`EASY`, `MODERATE`, `CHALLENGING`, `EXTREME`)
  - `bestSeason`: String
  - `latitude`, `longitude`: Double
  - `gpxTrackUrl`: String
  - `coverImageUrl`: String
  - `estimatedCost`: Double
  - `statusBulletin`: String (Bản tin tình trạng đường mòn gần nhất từ kiểm lâm)
- **`LocalGuide` Entity (Porter / Hướng dẫn viên bản địa):**
  - `id`: Long, `fullName`, `ethnicGroup`, `phone`, `region`, `experienceYears`, `ratingScore`, `avatarUrl`.

---

## 4. Trip Planner Domain
- **`TripPlan` Entity:**
  - `id`: UUID, `creator`: `User`, `trail`: `Trail`, `startDate`, `endDate`, `partySize`, `totalEstimatedCost`, `costPerPerson`, `status`.
  - `itineraryDays`: `List<TripItineraryItem>`
  - `gearChecklist`: `List<GearItem>`

---

## 5. Summit Passport & Gamification Domain
- **`Badge` & `UserBadge` Entity:**
  - `BADGE_FANSIPAN_3143`, `BADGE_LAO_THAN_2860`, `BADGE_TA_CHI_NHU_2979`, `BADGE_MASTER_3000M`, `BADGE_LEAVE_NO_TRACE`.
  - Mở khóa tự động khi `Post.isSummitVerified == true`.
