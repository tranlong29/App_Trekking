'use client';

import React, { useState } from 'react';
import { Image, MapPin, Activity, Sun, Send } from 'lucide-react';

export default function CreatePostBox() {
  const [caption, setCaption] = useState('');

  return (
    <div className="bg-white rounded-2xl border border-forest/10 p-4 shadow-sm">
      <div className="flex items-start gap-3">
        <img
          src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=400&q=80"
          alt="Avatar"
          className="w-10 h-10 rounded-full object-cover ring-2 ring-forest/20 mt-1"
        />
        <div className="flex-1">
          <textarea
            value={caption}
            onChange={(e) => setCaption(e.target.value)}
            rows={2}
            placeholder="Chia sẻ kỷ niệm chuyến đi của bạn hôm nay... (Cảm xúc, câu chuyện, khoảnh khắc đáng nhớ)"
            className="w-full bg-canvas/60 hover:bg-canvas rounded-xl p-3 text-sm border border-forest/10 focus:border-forest focus:ring-1 focus:ring-forest outline-none transition-all placeholder:text-gray-400 resize-none"
          />

          <div className="mt-3 flex items-center justify-between flex-wrap gap-2 pt-2 border-t border-forest/5">
            <div className="flex items-center gap-1 sm:gap-2">
              <button 
                type="button" 
                className="inline-flex items-center gap-1 px-2.5 py-1.5 rounded-lg text-xs font-medium text-gray-600 hover:text-forest hover:bg-forest-tint/30 transition-colors"
              >
                <Image className="w-4 h-4 text-emerald-600" />
                <span className="hidden sm:inline">Ảnh/Video</span>
              </button>
              <button 
                type="button" 
                className="inline-flex items-center gap-1 px-2.5 py-1.5 rounded-lg text-xs font-medium text-gray-600 hover:text-forest hover:bg-forest-tint/30 transition-colors"
              >
                <MapPin className="w-4 h-4 text-red-500" />
                <span className="hidden sm:inline">Gắn đỉnh núi</span>
              </button>
              <button 
                type="button" 
                className="inline-flex items-center gap-1 px-2.5 py-1.5 rounded-lg text-xs font-medium text-gray-600 hover:text-forest hover:bg-forest-tint/30 transition-colors"
              >
                <Activity className="w-4 h-4 text-terracotta" />
                <span className="hidden sm:inline">Thông số GPS</span>
              </button>
              <button 
                type="button" 
                className="inline-flex items-center gap-1 px-2.5 py-1.5 rounded-lg text-xs font-medium text-gray-600 hover:text-forest hover:bg-forest-tint/30 transition-colors"
              >
                <Sun className="w-4 h-4 text-amber-500" />
                <span className="hidden sm:inline">Thời tiết</span>
              </button>
            </div>

            <button
              disabled={!caption.trim()}
              className="inline-flex items-center gap-1.5 px-4 py-1.5 rounded-full bg-forest text-white text-xs font-semibold hover:bg-forest-light transition-all disabled:opacity-40 disabled:cursor-not-allowed shadow-xs"
            >
              <Send className="w-3.5 h-3.5" />
              <span>Chia sẻ</span>
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
