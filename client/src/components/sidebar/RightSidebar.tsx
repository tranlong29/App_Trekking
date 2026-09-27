import React from 'react';
import { Flame, UserPlus, Users, PhoneCall } from 'lucide-react';

export default function RightSidebar() {
  const trendingPeaks = [
    { id: 1, name: 'Lảo Thẩn (Y Tý)', height: '2.860m', checkins: '1.2k', tag: 'Săn mây' },
    { id: 2, name: 'Tà Chì Nhù', height: '2.979m', checkins: '890', tag: 'Hoa Chi Pâu' },
    { id: 3, name: 'Tà Xùa', height: '2.865m', checkins: '1.5k', tag: 'Sống khủng long' },
    { id: 4, name: 'Bidoup Núi Bà', height: '2.287m', checkins: '620', tag: 'Rừng rêu' },
  ];

  return (
    <aside className="space-y-4">
      {/* Trending Peaks */}
      <div className="bg-white rounded-2xl border border-forest/10 p-4 shadow-sm">
        <h4 className="font-bold text-xs uppercase tracking-wider text-forest flex items-center gap-1.5 mb-3">
          <Flame className="w-4 h-4 text-terracotta" />
          <span>Đỉnh núi Trending tuần này</span>
        </h4>

        <div className="space-y-2.5">
          {trendingPeaks.map((peak, idx) => (
            <div key={peak.id} className="flex items-center justify-between group cursor-pointer">
              <div className="flex items-center gap-2.5">
                <span className="w-5 font-bold text-xs text-gray-400 group-hover:text-forest">
                  0{idx + 1}
                </span>
                <div>
                  <p className="font-bold text-xs text-gray-900 group-hover:text-forest transition-colors">
                    {peak.name}
                  </p>
                  <p className="text-[11px] text-gray-400">{peak.height} • {peak.tag}</p>
                </div>
              </div>
              <span className="text-[11px] font-semibold text-forest bg-forest-tint/60 px-2 py-0.5 rounded-full">
                {peak.checkins}
              </span>
            </div>
          ))}
        </div>
      </div>

      {/* Suggested Trekker & Porters */}
      <div className="bg-white rounded-2xl border border-forest/10 p-4 shadow-sm">
        <h4 className="font-bold text-xs uppercase tracking-wider text-forest flex items-center gap-1.5 mb-3">
          <UserPlus className="w-4 h-4 text-forest" />
          <span>Gợi ý kết nối Porter bản địa</span>
        </h4>

        <div className="space-y-3">
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-2">
              <img
                src="https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?auto=format&fit=crop&w=200&q=80"
                alt="A Hờ"
                className="w-9 h-9 rounded-full object-cover"
              />
              <div>
                <p className="font-bold text-xs text-gray-900">A Hờ (Y Tý)</p>
                <p className="text-[11px] text-gray-500">Porter bản địa • 5.0 ★</p>
              </div>
            </div>
            <button className="text-xs font-semibold px-2.5 py-1 rounded-full border border-forest text-forest hover:bg-forest hover:text-white transition-colors">
              Nhắn tin
            </button>
          </div>

          <div className="flex items-center justify-between">
            <div className="flex items-center gap-2">
              <img
                src="https://images.unsplash.com/photo-1500648767791-00dcc994a43e?auto=format&fit=crop&w=200&q=80"
                alt="Minh Thảo"
                className="w-9 h-9 rounded-full object-cover"
              />
              <div>
                <p className="font-bold text-xs text-gray-900">Minh Thảo (Lead)</p>
                <p className="text-[11px] text-gray-500">8 năm kinh nghiệm Fansipan</p>
              </div>
            </div>
            <button className="text-xs font-semibold px-2.5 py-1 rounded-full border border-forest text-forest hover:bg-forest hover:text-white transition-colors">
              + Theo dõi
            </button>
          </div>
        </div>
      </div>

      {/* Ghép Đoàn Cuối Tuần */}
      <div className="bg-white rounded-2xl border border-forest/10 p-4 shadow-sm">
        <h4 className="font-bold text-xs uppercase tracking-wider text-forest flex items-center gap-1.5 mb-2">
          <Users className="w-4 h-4 text-emerald-600" />
          <span>Chuyến đi ghép đoàn sắp tới</span>
        </h4>
        <div className="p-2.5 rounded-xl bg-canvas border border-forest/10 mt-2">
          <div className="flex justify-between items-center text-xs">
            <span className="font-bold text-forest">Lảo Thẩn 2N1Đ</span>
            <span className="text-[10px] bg-red-100 text-red-700 font-bold px-1.5 py-0.5 rounded">Còn 2/6 chỗ</span>
          </div>
          <p className="text-[11px] text-gray-500 mt-1">Khởi hành: Tối Thứ 6 tuần này • Share chi phí ~1.850k</p>
          <button className="w-full mt-2 py-1 rounded-lg bg-forest text-white text-xs font-semibold hover:bg-forest-light transition-colors">
            Tham gia ngay
          </button>
        </div>
      </div>

      {/* SAR Hotline */}
      <div className="p-3 rounded-2xl bg-terracotta/10 border border-terracotta/20 flex items-center gap-2.5 text-xs text-terracotta-dark">
        <PhoneCall className="w-4 h-4 text-terracotta shrink-0" />
        <div>
          <span className="font-bold block">Hotline Cứu nạn miền núi SAR: 112</span>
          <span className="text-[11px] opacity-80">Hoạt động 24/7 bảo vệ trekker.</span>
        </div>
      </div>
    </aside>
  );
}
