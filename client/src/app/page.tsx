'use client';

import React, { useEffect, useState } from 'react';
import LeftSidebar from '@/components/sidebar/LeftSidebar';
import RightSidebar from '@/components/sidebar/RightSidebar';
import CreatePostBox from '@/components/feed/CreatePostBox';
import PostCard from '@/components/feed/PostCard';
import { Post } from '@/types';
import { fetchFeedPosts } from '@/services/api';
import { Plus } from 'lucide-react';

export default function HomePage() {
  const [posts, setPosts] = useState<Post[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    fetchFeedPosts().then((data) => {
      setPosts(data);
      setIsLoading(false);
    });
  }, []);

  const stories = [
    { id: 1, name: 'Lảo Thẩn', time: '2h trước', avatar: 'https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=200&q=80' },
    { id: 2, name: 'Tà Xùa', time: '4h trước', avatar: 'https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?auto=format&fit=crop&w=200&q=80' },
    { id: 3, name: 'Fansipan', time: '6h trước', avatar: 'https://images.unsplash.com/photo-1542601906990-b4d3fb778b09?auto=format&fit=crop&w=200&q=80' },
    { id: 4, name: 'Bidoup', time: 'Hôm qua', avatar: 'https://images.unsplash.com/photo-1448375240586-882707db888b?auto=format&fit=crop&w=200&q=80' },
    { id: 5, name: 'Ngũ Chỉ Sơn', time: 'Hôm qua', avatar: 'https://images.unsplash.com/photo-1507525428034-b723cf961d3e?auto=format&fit=crop&w=200&q=80' },
  ];

  return (
    <div className="grid grid-cols-1 lg:grid-cols-12 gap-6">
      {/* Cột trái: Hồ sơ cá nhân & Hộ chiếu số */}
      <div className="hidden lg:block lg:col-span-3">
        <div className="sticky top-20">
          <LeftSidebar />
        </div>
      </div>

      {/* Cột giữa: Bảng tin kỷ niệm mạng xã hội (Trọng tâm) */}
      <div className="col-span-1 lg:col-span-6 space-y-4">
        {/* Story Carousel */}
        <div className="bg-white rounded-2xl border border-forest/10 p-3 shadow-sm overflow-x-auto">
          <div className="flex items-center gap-3">
            {/* Add Story Card */}
            <div className="flex flex-col items-center gap-1 min-w-[68px] cursor-pointer group">
              <div className="w-14 h-14 rounded-full border-2 border-dashed border-forest/40 flex items-center justify-center bg-forest-tint/30 text-forest group-hover:scale-105 transition-transform">
                <Plus className="w-5 h-5" />
              </div>
              <span className="text-[11px] font-semibold text-gray-700 truncate max-w-[68px]">Tạo tin</span>
            </div>

            {/* Friend Stories */}
            {stories.map((s) => (
              <div key={s.id} className="flex flex-col items-center gap-1 min-w-[68px] cursor-pointer group">
                <div className="w-14 h-14 rounded-full ring-2 ring-forest p-0.5 group-hover:scale-105 transition-transform overflow-hidden">
                  <img src={s.avatar} alt={s.name} className="w-full h-full rounded-full object-cover" />
                </div>
                <span className="text-[11px] font-medium text-gray-700 truncate max-w-[68px]">{s.name}</span>
              </div>
            ))}
          </div>
        </div>

        {/* Hộp soạn thảo bài đăng kỷ niệm */}
        <CreatePostBox />

        {/* Danh sách bài đăng kỷ niệm */}
        {isLoading ? (
          <div className="p-8 text-center text-sm text-gray-500">Đang tải bảng tin kỷ niệm...</div>
        ) : (
          posts.map((post) => (
            <PostCard key={post.id} post={post} />
          ))
        )}
      </div>

      {/* Cột phải: Trending, Porter bản địa, Ghép đoàn */}
      <div className="hidden lg:block lg:col-span-3">
        <div className="sticky top-20">
          <RightSidebar />
        </div>
      </div>
    </div>
  );
}
