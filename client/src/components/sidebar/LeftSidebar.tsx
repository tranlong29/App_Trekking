import React from 'react';
import { Mountain, Award, ChevronRight, Compass } from 'lucide-react';

export default function LeftSidebar() {
  return (
    <aside className="space-y-4">
      {/* Trekker Profile Card */}
      <div className="bg-white rounded-2xl border border-forest/10 p-4 shadow-sm">
        <div className="flex items-center gap-3">
          <div className="relative">
            <img
              src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=400&q=80"
              alt="Minh Hoàng"
              className="w-14 h-14 rounded-2xl object-cover ring-2 ring-forest/30"
            />
            <span className="absolute -bottom-1 -right-1 w-4 h-4 bg-emerald-500 rounded-full border-2 border-white flex items-center justify-center text-[10px] text-white">
              ✓
            </span>
          </div>
          <div>
            <h3 className="font-bold text-gray-900 text-sm">Minh Hoàng</h3>
            <p className="text-xs text-gray-500">@hoang.trekker</p>
            <span className="inline-block mt-1 px-2 py-0.5 rounded-full bg-forest-tint text-forest text-[11px] font-semibold">
              Master Trekker Lv.3
            </span>
          </div>
        </div>

        {/* Stats Grid */}
        <div className="grid grid-cols-3 gap-2 mt-4 pt-3 border-t border-forest/5 text-center">
          <div>
            <span className="block font-bold text-forest text-sm">12</span>
            <span className="text-[11px] text-gray-500">Đỉnh chạm</span>
          </div>
          <div>
            <span className="block font-bold text-forest text-sm">32.4k</span>
            <span className="text-[11px] text-gray-500">Mét leo</span>
          </div>
          <div>
            <span className="block font-bold text-forest text-sm">1.4k</span>
            <span className="text-[11px] text-gray-500">Theo dõi</span>
          </div>
        </div>

        {/* Level Progress */}
        <div className="mt-3">
          <div className="flex justify-between text-[11px] text-gray-500 mb-1">
            <span>Tiến độ lên Grandmaster</span>
            <span className="font-bold text-forest">80%</span>
          </div>
          <div className="w-full bg-gray-100 rounded-full h-1.5 overflow-hidden">
            <div className="bg-forest h-1.5 rounded-full" style={{ width: '80%' }}></div>
          </div>
        </div>
      </div>

      {/* Mini Hộ Chiếu Số (Summit Badges) */}
      <div className="bg-white rounded-2xl border border-forest/10 p-4 shadow-sm">
        <div className="flex items-center justify-between mb-3">
          <h4 className="font-bold text-xs uppercase tracking-wider text-forest flex items-center gap-1.5">
            <Award className="w-4 h-4 text-terracotta" />
            <span>Hộ chiếu đỉnh núi</span>
          </h4>
          <span className="text-[11px] text-forest font-semibold cursor-pointer hover:underline">
            Tất cả (12)
          </span>
        </div>

        <div className="grid grid-cols-2 gap-2 text-xs">
          <div className="p-2 rounded-xl bg-canvas border border-forest/10 flex items-center gap-2">
            <span className="text-xl">🏆</span>
            <div>
              <p className="font-bold text-gray-800 text-[11px]">Fansipan</p>
              <p className="text-[10px] text-gray-500">3.143m</p>
            </div>
          </div>
          <div className="p-2 rounded-xl bg-canvas border border-forest/10 flex items-center gap-2">
            <span className="text-xl">☁️</span>
            <div>
              <p className="font-bold text-gray-800 text-[11px]">Lảo Thẩn</p>
              <p className="text-[10px] text-gray-500">2.860m</p>
            </div>
          </div>
          <div className="p-2 rounded-xl bg-canvas border border-forest/10 flex items-center gap-2">
            <span className="text-xl">🌸</span>
            <div>
              <p className="font-bold text-gray-800 text-[11px]">Tà Chì Nhù</p>
              <p className="text-[10px] text-gray-500">2.979m</p>
            </div>
          </div>
          <div className="p-2 rounded-xl bg-canvas border border-forest/10 flex items-center gap-2">
            <span className="text-xl">🌲</span>
            <div>
              <p className="font-bold text-gray-800 text-[11px]">Bidoup</p>
              <p className="text-[10px] text-gray-500">2.287m</p>
            </div>
          </div>
        </div>
      </div>

      {/* Leave No Trace Banner */}
      <div className="p-3 rounded-2xl bg-forest text-white shadow-sm flex items-center gap-3">
        <div className="p-2 rounded-xl bg-white/10 text-xl">🌿</div>
        <div>
          <p className="font-bold text-xs">Leave No Trace</p>
          <p className="text-[11px] text-forest-tint/80 mt-0.5">Không để lại gì ngoài những dấu chân.</p>
        </div>
      </div>
    </aside>
  );
}
