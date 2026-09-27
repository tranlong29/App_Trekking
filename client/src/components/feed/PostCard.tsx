'use client';

import React, { useState } from 'react';
import { Post } from '@/types';
import { 
  Heart, 
  MessageCircle, 
  Share2, 
  Bookmark, 
  CheckCircle, 
  MapPin, 
  Flame, 
  TrendingUp, 
  Clock, 
  Sun 
} from 'lucide-react';

interface PostCardProps {
  post: Post;
}

export default function PostCard({ post }: PostCardProps) {
  const [kudos, setKudos] = useState(post.kudosCount);
  const [hasLiked, setHasLiked] = useState(false);
  const [isSaved, setIsSaved] = useState(false);

  const handleKudos = () => {
    if (hasLiked) {
      setKudos((prev) => prev - 1);
      setHasLiked(false);
    } else {
      setKudos((prev) => prev + 1);
      setHasLiked(true);
    }
  };

  return (
    <article className="bg-white rounded-2xl border border-forest/10 shadow-sm hover:shadow-md transition-shadow overflow-hidden">
      {/* Header */}
      <div className="p-4 flex items-center justify-between">
        <div className="flex items-center gap-3">
          <div className="relative">
            <img
              src={post.author.avatarUrl}
              alt={post.author.fullName}
              className="w-11 h-11 rounded-full object-cover ring-2 ring-forest/20"
            />
            {post.author.isLeaveNoTraceAmbassador && (
              <span 
                title="Đại sứ bảo vệ môi trường Leave No Trace" 
                className="absolute -bottom-1 -right-1 text-xs bg-forest-tint text-forest px-1 rounded-full border border-white font-bold"
              >
                🌿
              </span>
            )}
          </div>
          <div>
            <div className="flex items-center gap-1.5 flex-wrap">
              <span className="font-bold text-gray-900 text-sm hover:underline cursor-pointer">
                {post.author.fullName}
              </span>
              <span className="text-gray-400 text-xs">@{post.author.username}</span>
              {post.isSummitVerified && (
                <span className="inline-flex items-center gap-1 px-2 py-0.5 rounded-full bg-forest-tint text-forest text-[11px] font-semibold border border-forest/20">
                  <CheckCircle className="w-3 h-3 text-forest" />
                  <span>Chạm đỉnh xác thực</span>
                </span>
              )}
            </div>
            <p className="text-xs text-gray-500 mt-0.5">
              {post.taggedTrail ? `${post.taggedTrail.name} • ` : ''}Vừa đăng
            </p>
          </div>
        </div>
      </div>

      {/* Strava-style Activity Telemetry Card */}
      {(post.distanceKm || post.elevationGainMeters) && (
        <div className="mx-4 mb-3 p-3 bg-canvas rounded-xl border border-forest/10 grid grid-cols-2 sm:grid-cols-4 gap-2 text-center">
          {post.distanceKm && (
            <div className="flex flex-col items-center">
              <span className="text-[11px] font-semibold text-gray-500 uppercase tracking-wider flex items-center gap-1">
                <TrendingUp className="w-3 h-3 text-forest" /> Cự ly
              </span>
              <span className="text-base font-bold text-forest">{post.distanceKm} km</span>
            </div>
          )}
          {post.elevationGainMeters && (
            <div className="flex flex-col items-center">
              <span className="text-[11px] font-semibold text-gray-500 uppercase tracking-wider flex items-center gap-1">
                <Flame className="w-3 h-3 text-terracotta" /> Độ cao
              </span>
              <span className="text-base font-bold text-forest">+{post.elevationGainMeters} m</span>
            </div>
          )}
          {post.durationDays && (
            <div className="flex flex-col items-center">
              <span className="text-[11px] font-semibold text-gray-500 uppercase tracking-wider flex items-center gap-1">
                <Clock className="w-3 h-3 text-blue-600" /> Thời lượng
              </span>
              <span className="text-base font-bold text-forest">{post.durationDays}N1Đ</span>
            </div>
          )}
          {post.weatherCondition && (
            <div className="flex flex-col items-center">
              <span className="text-[11px] font-semibold text-gray-500 uppercase tracking-wider flex items-center gap-1">
                <Sun className="w-3 h-3 text-amber-500" /> Thời tiết
              </span>
              <span className="text-xs font-semibold text-forest truncate max-w-[90px]">{post.weatherCondition}</span>
            </div>
          )}
        </div>
      )}

      {/* Caption */}
      <div className="px-4 pb-3">
        <p className="text-gray-800 text-sm leading-relaxed whitespace-pre-line">
          {post.caption}
        </p>
      </div>

      {/* Photo Gallery Grid */}
      {post.mediaUrls && post.mediaUrls.length > 0 && (
        <div className={`grid gap-1 px-4 pb-3 ${post.mediaUrls.length === 1 ? 'grid-cols-1' : 'grid-cols-2'}`}>
          {post.mediaUrls.map((url, idx) => (
            <div key={idx} className="relative rounded-xl overflow-hidden aspect-[4/3] bg-gray-100">
              <img
                src={url}
                alt="Ảnh kỷ niệm dã ngoại"
                className="w-full h-full object-cover hover:scale-105 transition-transform duration-300"
              />
            </div>
          ))}
        </div>
      )}

      {/* Tagged Trail Banner */}
      {post.taggedTrail && (
        <div className="mx-4 mb-3 p-2.5 rounded-xl bg-forest-tint/40 border border-forest/15 flex items-center justify-between gap-2">
          <div className="flex items-center gap-2">
            <div className="p-1.5 rounded-lg bg-white text-forest shadow-xs">
              <MapPin className="w-4 h-4 text-forest" />
            </div>
            <div>
              <p className="text-xs font-bold text-forest">{post.taggedTrail.name} ({post.taggedTrail.peakElevation}m)</p>
              <p className="text-[11px] text-gray-600">Độ khó: {post.taggedTrail.difficultyLevel} • {post.taggedTrail.region}</p>
            </div>
          </div>
          <button className="text-xs font-semibold px-3 py-1.5 rounded-lg bg-forest text-white hover:bg-forest-light transition-colors">
            Lên kế hoạch
          </button>
        </div>
      )}

      {/* Social Actions Bar */}
      <div className="px-4 py-2.5 border-t border-forest/5 flex items-center justify-between text-gray-500 text-xs">
        <div className="flex items-center gap-4">
          <button
            onClick={handleKudos}
            className={`flex items-center gap-1.5 font-semibold transition-colors ${
              hasLiked ? 'text-red-500' : 'hover:text-red-500'
            }`}
          >
            <Heart className={`w-4 h-4 ${hasLiked ? 'fill-current' : ''}`} />
            <span>{kudos} Kudos</span>
          </button>

          <button className="flex items-center gap-1.5 hover:text-forest transition-colors font-medium">
            <MessageCircle className="w-4 h-4" />
            <span>{post.commentCount} Bình luận</span>
          </button>

          <button className="flex items-center gap-1.5 hover:text-forest transition-colors font-medium">
            <Share2 className="w-4 h-4" />
            <span>{post.shareCount}</span>
          </button>
        </div>

        <button
          onClick={() => setIsSaved(!isSaved)}
          className={`p-1.5 rounded-lg transition-colors ${
            isSaved ? 'text-forest' : 'hover:text-forest'
          }`}
          title="Lưu vào danh sách mong muốn"
        >
          <Bookmark className={`w-4 h-4 ${isSaved ? 'fill-current' : ''}`} />
        </button>
      </div>
    </article>
  );
}
