'use client';

import React, { useState } from 'react';
import Link from 'next/link';
import { 
  Home, 
  Compass, 
  Calendar, 
  Award, 
  Users, 
  Map, 
  Search, 
  MessageSquare, 
  Bell, 
  PlusSquare,
  Mountain
} from 'lucide-react';

export default function TopHeader() {
  const [activeTab, setActiveTab] = useState<'feed' | 'explore' | 'planner' | 'passport' | 'clubs' | 'map'>('feed');

  const navItems = [
    { id: 'feed', icon: Home, label: 'Bảng tin cộng đồng', href: '/' },
    { id: 'explore', icon: Compass, label: 'Khám phá đỉnh núi & Cung đường', href: '/trails' },
    { id: 'planner', icon: Calendar, label: 'Lên kế hoạch & Chi phí', href: '/planner' },
    { id: 'passport', icon: Award, label: 'Hộ chiếu đỉnh núi & Huy hiệu', href: '/passport', hasDot: true },
    { id: 'clubs', icon: Users, label: 'Bạn bè & Ghép đoàn', href: '/clubs' },
    { id: 'map', icon: Map, label: 'Bản đồ GPS vệ tinh & GPX', href: '/map' },
  ];

  return (
    <header className="sticky top-0 z-50 w-full bg-white/95 backdrop-blur-md border-b border-forest/10 shadow-sm">
      <div className="max-w-7xl mx-auto px-4 h-16 flex items-center justify-between gap-4">
        {/* Left: Brand Logo & Search */}
        <div className="flex items-center gap-4 flex-shrink-0">
          <Link href="/" className="flex items-center gap-2.5 group">
            <div className="w-10 h-10 rounded-xl bg-forest flex items-center justify-center text-white shadow-sm group-hover:scale-105 transition-transform">
              <Mountain className="w-5 h-5 text-forest-tint" />
            </div>
            <div className="flex flex-col">
              <span className="font-bold text-xl tracking-tight text-forest">
                TrekBook <span className="text-forest-light text-sm font-semibold">VN</span>
              </span>
            </div>
          </Link>

          {/* Search bar with ⌘K */}
          <div className="hidden md:flex items-center relative w-64 lg:w-72">
            <Search className="w-4 h-4 absolute left-3.5 text-gray-400 pointer-events-none" />
            <input
              type="text"
              placeholder="Tìm kỷ niệm, đỉnh núi, trekker..."
              className="w-full pl-10 pr-10 py-2 bg-canvas hover:bg-canvas-stone/50 rounded-full text-sm border border-forest/10 focus:border-forest focus:ring-2 focus:ring-forest/20 outline-none transition-all placeholder:text-gray-400"
            />
            <span className="absolute right-3 px-1.5 py-0.5 rounded text-[10px] font-semibold bg-gray-200/80 text-gray-600 border border-gray-300">
              ⌘K
            </span>
          </div>
        </div>

        {/* Center: Core Icon-Only Navigation Bar */}
        <nav className="flex items-center justify-center gap-1 sm:gap-2">
          {navItems.map((item) => {
            const Icon = item.icon;
            const isActive = activeTab === item.id;
            return (
              <button
                key={item.id}
                onClick={() => setActiveTab(item.id as any)}
                title={item.label}
                className={`relative w-12 h-12 rounded-xl flex items-center justify-center transition-all ${
                  isActive
                    ? 'text-forest bg-forest/10'
                    : 'text-gray-500 hover:text-forest hover:bg-gray-100'
                }`}
              >
                <Icon className={`w-5 h-5 transition-transform ${isActive ? 'scale-110' : ''}`} />
                {item.hasDot && (
                  <span className="absolute top-2.5 right-2.5 w-2 h-2 rounded-full bg-forest-light ring-2 ring-white" />
                )}
                {/* Active indicator bar */}
                {isActive && (
                  <span className="absolute bottom-1 w-5 h-1 rounded-full bg-forest" />
                )}
              </button>
            );
          })}
        </nav>

        {/* Right: Quick Actions & Profile */}
        <div className="flex items-center gap-2 sm:gap-3 flex-shrink-0">
          <button className="hidden sm:inline-flex items-center gap-1.5 px-4 py-2 rounded-full bg-forest text-white text-sm font-semibold shadow-sm hover:bg-forest-light active:scale-95 transition-all">
            <PlusSquare className="w-4 h-4" />
            <span>+ Đăng bài</span>
          </button>

          <button title="Tin nhắn" className="p-2 rounded-full text-gray-600 hover:bg-gray-100 transition-colors">
            <MessageSquare className="w-5 h-5" />
          </button>

          <button title="Thông báo" className="relative p-2 rounded-full text-gray-600 hover:bg-gray-100 transition-colors">
            <Bell className="w-5 h-5" />
            <span className="absolute top-1 right-1 w-4 h-4 bg-terracotta text-white text-[10px] font-bold rounded-full flex items-center justify-center border-2 border-white">
              3
            </span>
          </button>

          <div className="relative pl-1 cursor-pointer group">
            <img
              src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=400&q=80"
              alt="Avatar"
              className="w-9 h-9 rounded-full object-cover ring-2 ring-forest/30 group-hover:ring-forest transition-all"
            />
            <span className="absolute bottom-0 right-0 w-2.5 h-2.5 bg-green-500 rounded-full border-2 border-white" />
          </div>
        </div>
      </div>
    </header>
  );
}
