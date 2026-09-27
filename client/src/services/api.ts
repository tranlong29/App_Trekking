import axios from 'axios';
import { ApiResponse, Post, TrailSummary } from '@/types';

const API_BASE_URL = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080/api/v1';

export const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
  timeout: 5000,
});

// Mock data ban đầu hiển thị mượt mà
export const MOCK_POSTS: Post[] = [
  {
    id: 'post-1',
    author: {
      id: 'user-1',
      username: 'tramanh.outdoor',
      fullName: 'Trâm Anh',
      avatarUrl: 'https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=400&q=80',
      summitsCount: 15,
      level: 4,
      isLeaveNoTraceAmbassador: true,
    },
    caption: 'Chuyến đi đầu đời vượt ngoài mong đợi! Lần đầu tiên tận mắt chứng kiến biển mây bồng bềnh ngay dưới chân mình ở nóc nhà Y Tý. Cảm ơn anh em trong đoàn và porter A Hờ đã hỗ trợ hết mình. Khoảnh khắc chạm tay vào chóp inox lúc 6h sáng thực sự vô giá! ⛰️☁️',
    sportCategory: 'TREKKING',
    mediaUrls: [
      'https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=1200&q=80',
      'https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?auto=format&fit=crop&w=1200&q=80',
    ],
    taggedTrail: {
      id: 1,
      name: 'Đỉnh Lảo Thẩn',
      slug: 'lao-than-y-ty',
      region: 'NORTH_WEST',
      peakElevation: 2860,
      elevationGain: 1150,
      distanceKm: 16.2,
      difficultyLevel: 'MODERATE',
      coverImageUrl: 'https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=1200&q=80',
    },
    distanceKm: 16.2,
    elevationGainMeters: 1150,
    durationDays: 2,
    weatherCondition: 'Nắng ráo, Biển mây 10/10',
    isSummitVerified: true,
    kudosCount: 428,
    commentCount: 56,
    shareCount: 24,
    createdAt: new Date().toISOString(),
  },
  {
    id: 'post-2',
    author: {
      id: 'user-2',
      username: 'hoang.trekker',
      fullName: 'Minh Hoàng',
      avatarUrl: 'https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=400&q=80',
      summitsCount: 12,
      level: 3,
      isLeaveNoTraceAmbassador: true,
    },
    caption: 'Mùa hoa Chi Pâu tím biếc đang nở rộ 90% triền đồi Tà Chì Nhù! Khuyến cáo anh em chuẩn bị gậy leo núi vì dốc Móng Ngựa trơn trượt nhẹ. Nguồn nước lán 1 đang rất dồi dào, các đoàn yên tâm lên đường.',
    sportCategory: 'TREKKING',
    mediaUrls: [
      'https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?auto=format&fit=crop&w=1200&q=80',
    ],
    taggedTrail: {
      id: 2,
      name: 'Đỉnh Tà Chì Nhù',
      slug: 'ta-chi-nhu-yen-bai',
      region: 'NORTH_WEST',
      peakElevation: 2979,
      elevationGain: 1450,
      distanceKm: 18.0,
      difficultyLevel: 'CHALLENGING',
      coverImageUrl: 'https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?auto=format&fit=crop&w=1200&q=80',
    },
    distanceKm: 18.0,
    elevationGainMeters: 1450,
    durationDays: 2,
    weatherCondition: 'Se lạnh 12°C, Gió cấp 4',
    isSummitVerified: true,
    kudosCount: 215,
    commentCount: 38,
    shareCount: 12,
    createdAt: new Date(Date.now() - 3600000 * 4).toISOString(),
  },
];

export async function fetchFeedPosts(): Promise<Post[]> {
  try {
    const res = await apiClient.get<ApiResponse<{ content: Post[] }>>('/posts/feed');
    if (res.data.success && res.data.data?.content) {
      return res.data.data.content;
    }
  } catch (error) {
    console.warn('Backend chưa khởi chạy, sử dụng dữ liệu mẫu cho Feed:', error);
  }
  return MOCK_POSTS;
}
