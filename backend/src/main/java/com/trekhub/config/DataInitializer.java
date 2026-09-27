package com.trekhub.config;

import com.trekhub.entity.Post;
import com.trekhub.entity.Trail;
import com.trekhub.entity.User;
import com.trekhub.enums.DifficultyLevel;
import com.trekhub.enums.Region;
import com.trekhub.enums.SportCategory;
import com.trekhub.repository.PostRepository;
import com.trekhub.repository.TrailRepository;
import com.trekhub.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(
            UserRepository userRepository,
            TrailRepository trailRepository,
            PostRepository postRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() > 0) {
                return; // Đã có dữ liệu
            }

            // 1. Tạo Users mẫu
            User hoang = new User();
            hoang.setUsername("hoang.trekker");
            hoang.setEmail("hoang@trekbook.vn");
            hoang.setPassword(passwordEncoder.encode("123456"));
            hoang.setFullName("Minh Hoàng");
            hoang.setAvatarUrl("https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=400&q=80");
            hoang.setCoverImageUrl("https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=1200&q=80");
            hoang.setBio("Đam mê chinh phục những đỉnh cao đại ngàn Tây Bắc. Master Trekker Level 3.");
            hoang.setSummitsCount(12);
            hoang.setTotalElevationGain(32400.0);
            hoang.setTotalDistanceKm(280.0);
            hoang.setLevel(3);
            hoang.setLeaveNoTraceAmbassador(true);
            userRepository.save(hoang);

            User tramAnh = new User();
            tramAnh.setUsername("tramanh.outdoor");
            tramAnh.setEmail("tramanh@trekbook.vn");
            tramAnh.setPassword(passwordEncoder.encode("123456"));
            tramAnh.setFullName("Trâm Anh");
            tramAnh.setAvatarUrl("https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=400&q=80");
            tramAnh.setCoverImageUrl("https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?auto=format&fit=crop&w=1200&q=80");
            tramAnh.setBio("Yêu rừng rậm rêu phong và những sớm mai săn biển mây.");
            tramAnh.setSummitsCount(15);
            tramAnh.setTotalElevationGain(48600.0);
            tramAnh.setTotalDistanceKm(320.0);
            tramAnh.setLevel(4);
            tramAnh.setLeaveNoTraceAmbassador(true);
            userRepository.save(tramAnh);

            // 2. Tạo Trails mẫu
            Trail laoThan = new Trail();
            laoThan.setName("Đỉnh Lảo Thẩn");
            laoThan.setSlug("lao-than-y-ty");
            laoThan.setRegion(Region.NORTH_WEST);
            laoThan.setPeakElevation(2860);
            laoThan.setElevationGain(1150);
            laoThan.setDistanceKm(16.2);
            laoThan.setDifficultyLevel(DifficultyLevel.MODERATE);
            laoThan.setDurationDays(2);
            laoThan.setBestSeason("Tháng 10 - Tháng 3");
            laoThan.setLatitude(22.6105);
            laoThan.setLongitude(103.6268);
            laoThan.setCoverImageUrl("https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=1200&q=80");
            laoThan.setEstimatedCost(1900000.0);
            laoThan.setStatusBulletin("Đường khô ráo, lán A Hờ nước dồi dào, sáng sớm nhiệt độ 8°C.");
            trailRepository.save(laoThan);

            Trail taChiNhu = new Trail();
            taChiNhu.setName("Đỉnh Tà Chì Nhù");
            taChiNhu.setSlug("ta-chi-nhu-yen-bai");
            taChiNhu.setRegion(Region.NORTH_WEST);
            taChiNhu.setPeakElevation(2979);
            taChiNhu.setElevationGain(1450);
            taChiNhu.setDistanceKm(18.0);
            taChiNhu.setDifficultyLevel(DifficultyLevel.CHALLENGING);
            taChiNhu.setDurationDays(2);
            taChiNhu.setBestSeason("Tháng 9 - Tháng 11 (Mùa hoa Chi Pâu)");
            taChiNhu.setLatitude(21.5794);
            taChiNhu.setLongitude(104.2811);
            taChiNhu.setCoverImageUrl("https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?auto=format&fit=crop&w=1200&q=80");
            taChiNhu.setEstimatedCost(1400000.0);
            taChiNhu.setStatusBulletin("Hoa Chi Pâu nở tím 90% triền đồi, gió dốc Móng Ngựa khá mạnh.");
            trailRepository.save(taChiNhu);

            Trail fansipan = new Trail();
            fansipan.setName("Fansipan - Trạm Tôn");
            fansipan.setSlug("fansipan-tram-ton");
            fansipan.setRegion(Region.NORTH_WEST);
            fansipan.setPeakElevation(3143);
            fansipan.setElevationGain(1800);
            fansipan.setDistanceKm(22.0);
            fansipan.setDifficultyLevel(DifficultyLevel.CHALLENGING);
            fansipan.setDurationDays(2);
            fansipan.setBestSeason("Tháng 11 - Tháng 4");
            fansipan.setLatitude(22.3033);
            fansipan.setLongitude(103.7750);
            fansipan.setCoverImageUrl("https://images.unsplash.com/photo-1542601906990-b4d3fb778b09?auto=format&fit=crop&w=1200&q=80");
            fansipan.setEstimatedCost(2100000.0);
            fansipan.setStatusBulletin("Thời tiết quang đãng, tầm nhìn trên chóp 3.143m rất đẹp.");
            trailRepository.save(fansipan);

            // 3. Tạo Posts kỷ niệm mẫu
            Post post1 = new Post();
            post1.setAuthor(tramAnh);
            post1.setCaption("Chuyến đi đầu đời vượt ngoài mong đợi! Lần đầu tiên tận mắt chứng kiến biển mây bồng bềnh ngay dưới chân mình ở nóc nhà Y Tý. Cảm ơn anh em trong đoàn và porter A Hờ đã hỗ trợ hết mình. Khoảnh khắc chạm tay vào chóp inox lúc 6h sáng thực sự vô giá!");
            post1.setSportCategory(SportCategory.TREKKING);
            post1.setTaggedTrail(laoThan);
            post1.setDistanceKm(16.2);
            post1.setElevationGainMeters(1150.0);
            post1.setDurationDays(2);
            post1.setWeatherCondition("Nắng ráo, Biển mây 10/10");
            post1.setSummitVerified(true);
            post1.setKudosCount(428);
            post1.setCommentCount(56);
            post1.setShareCount(24);
            post1.setMediaUrls(List.of(
                    "https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=1000&q=80",
                    "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?auto=format&fit=crop&w=1000&q=80"
            ));
            postRepository.save(post1);

            Post post2 = new Post();
            post2.setAuthor(hoang);
            post2.setCaption("Mùa hoa Chi Pâu tím biếc nở rộ khắp các triền đồi Tà Chì Nhù! Khuyến cáo anh em chuẩn bị thêm gậy leo núi vì dốc đá khá trơn sau mưa phùn nhẹ. Lán 1 nước rất dồi dào.");
            post2.setSportCategory(SportCategory.TREKKING);
            post2.setTaggedTrail(taChiNhu);
            post2.setDistanceKm(18.0);
            post2.setElevationGainMeters(1450.0);
            post2.setDurationDays(2);
            post2.setWeatherCondition("Se lạnh 12°C, Gió cấp 4");
            post2.setSummitVerified(true);
            post2.setKudosCount(215);
            post2.setCommentCount(38);
            post2.setShareCount(12);
            post2.setMediaUrls(List.of(
                    "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?auto=format&fit=crop&w=1000&q=80"
            ));
            postRepository.save(post2);
        };
    }
}
