import type { Metadata } from 'next';
import './globals.css';
import TopHeader from '@/components/navigation/TopHeader';

export const metadata: Metadata = {
  title: 'TrekBook VN - Mạng Xã Hội Trekking & Outdoor Việt Nam',
  description: 'Nền tảng mạng xã hội kết nối cộng đồng người leo núi, lưu giữ kỷ niệm, khám phá cung đường và chia sẻ kinh nghiệm trekking tại Việt Nam.',
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="vi">
      <body className="min-h-screen bg-canvas text-gray-900 antialiased">
        <TopHeader />
        <main className="max-w-7xl mx-auto px-4 py-6">
          {children}
        </main>
      </body>
    </html>
  );
}
