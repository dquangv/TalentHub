package org.example.backend.config.chatbot;


import jakarta.annotation.PostConstruct;
import org.example.backend.entity.child.chatbot.ChatIntent;
import org.example.backend.entity.child.chatbot.ChatResponse;
import org.example.backend.entity.child.chatbot.ChatTrainingPhrase;
import org.example.backend.repository.ChatIntentRepository;
import org.example.backend.repository.ChatResponseRepository;
import org.example.backend.repository.ChatTrainingPhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
public class ChatbotInitializer {

    @Autowired
    private ChatIntentRepository chatIntentRepository;

    @Autowired
    private ChatTrainingPhraseRepository chatTrainingPhraseRepository;

    @Autowired
    private ChatResponseRepository chatResponseRepository;

    @PostConstruct
    @Transactional
    public void initializeChatbot() {
        // Check if we already have some intents
        if (chatIntentRepository.count() > 0) {
            return; // Already initialized
        }

        // Initialize basic intents
        createGreetingIntent();
        createFindJobIntent();
        createProfileIntent();
        createPaymentIntent();
        createFreelancerIntent();
        createSkillsIntent();
        createPasswordResetIntent();
        createHelpIntent();
    }

    private void createGreetingIntent() {
        ChatIntent intent = new ChatIntent();
        intent.setIntentName("greeting");
        intent.setDescription("Xử lý chào hỏi từ người dùng");
        intent = chatIntentRepository.save(intent);

        // Training phrases
        List<String> trainingPhrases = Arrays.asList(
                "Xin chào",
                "Chào bạn",
                "Hello",
                "Hi",
                "Chào buổi sáng",
                "Chào",
                "Bạn khỏe không"
        );

        for (String phrase : trainingPhrases) {
            ChatTrainingPhrase trainingPhrase = new ChatTrainingPhrase();
            trainingPhrase.setPhraseText(phrase);
            trainingPhrase.setIsProcessed(true);
            trainingPhrase.setIntent(intent);
            chatTrainingPhraseRepository.save(trainingPhrase);
        }

        // Responses
        List<String> responses = Arrays.asList(
                "Xin chào! Tôi là trợ lý ảo của Freelancer Hub. Tôi có thể giúp gì cho bạn?",
                "Chào bạn! Tôi có thể giúp bạn tìm kiếm việc làm, quản lý hồ sơ hoặc trả lời các câu hỏi về nền tảng Freelancer Hub.",
                "Xin chào! Rất vui được gặp bạn. Bạn cần hỗ trợ gì hôm nay?"
        );

        int order = 0;
        for (String response : responses) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setResponseText(response);
            chatResponse.setDisplayOrder(order++);
            chatResponse.setIntent(intent);
            chatResponseRepository.save(chatResponse);
        }
    }

    private void createFindJobIntent() {
        ChatIntent intent = new ChatIntent();
        intent.setIntentName("find_job");
        intent.setDescription("Hỗ trợ tìm kiếm công việc");
        intent = chatIntentRepository.save(intent);

        // Training phrases
        List<String> trainingPhrases = Arrays.asList(
                "Làm sao để tìm việc",
                "Tôi muốn tìm việc làm",
                "Tìm công việc freelance",
                "Có việc làm nào phù hợp với tôi không",
                "Tôi cần tìm việc",
                "Cách tìm kiếm công việc",
                "Tôi muốn ứng tuyển công việc",
                "Làm thế nào để ứng tuyển vào một công việc"
        );

        for (String phrase : trainingPhrases) {
            ChatTrainingPhrase trainingPhrase = new ChatTrainingPhrase();
            trainingPhrase.setPhraseText(phrase);
            trainingPhrase.setIsProcessed(true);
            trainingPhrase.setIntent(intent);
            chatTrainingPhraseRepository.save(trainingPhrase);
        }

        // Responses
        List<String> responses = Arrays.asList(
                "Để tìm việc trên Freelancer Hub, bạn có thể vào mục 'Tìm việc' trên thanh điều hướng. Tại đây, bạn có thể sử dụng các bộ lọc như kỹ năng, mức lương, hoặc loại công việc để tìm công việc phù hợp.",
                "Bạn có thể tìm kiếm việc làm bằng cách sử dụng tính năng tìm kiếm ở trang chủ hoặc vào mục 'Tìm việc'. Nền tảng của chúng tôi có nhiều công việc freelance trong nhiều lĩnh vực khác nhau như lập trình, thiết kế, viết lách, và nhiều lĩnh vực khác.",
                "Để ứng tuyển vào một công việc, trước tiên bạn cần đăng nhập vào tài khoản, tìm kiếm công việc phù hợp, xem chi tiết công việc và nhấn nút 'Ứng tuyển'. Bạn sẽ cần điền thông tin và có thể đính kèm CV hoặc portfolio của mình."
        );

        int order = 0;
        for (String response : responses) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setResponseText(response);
            chatResponse.setDisplayOrder(order++);
            chatResponse.setIntent(intent);
            chatResponseRepository.save(chatResponse);
        }

        // Add a response with database query
        ChatResponse dbResponse = new ChatResponse();
        dbResponse.setResponseText("Hiện tại có {{count}} công việc trong danh mục {{category}}. Bạn có thể vào mục 'Tìm việc' để xem chi tiết.");
        dbResponse.setDisplayOrder(order++);
        dbResponse.setIntent(intent);
        dbResponse.setRequiresDbQuery(true);
        dbResponse.setQueryTemplate("SELECT COUNT(*) as count, c.name as category FROM jobs j JOIN categories c ON j.category_id = c.id GROUP BY j.category_id");
        chatResponseRepository.save(dbResponse);
    }

    private void createProfileIntent() {
        ChatIntent intent = new ChatIntent();
        intent.setIntentName("profile_management");
        intent.setDescription("Quản lý hồ sơ cá nhân");
        intent = chatIntentRepository.save(intent);

        // Training phrases
        List<String> trainingPhrases = Arrays.asList(
                "Làm sao để cập nhật hồ sơ",
                "Tôi muốn thay đổi thông tin cá nhân",
                "Cách tạo hồ sơ freelancer",
                "Làm thế nào để tạo portfolio",
                "Cập nhật CV",
                "Thêm kỹ năng vào hồ sơ",
                "Tôi muốn thêm dự án vào portfolio",
                "Làm sao để tăng khả năng hiển thị hồ sơ"
        );

        for (String phrase : trainingPhrases) {
            ChatTrainingPhrase trainingPhrase = new ChatTrainingPhrase();
            trainingPhrase.setPhraseText(phrase);
            trainingPhrase.setIsProcessed(true);
            trainingPhrase.setIntent(intent);
            chatTrainingPhraseRepository.save(trainingPhrase);
        }

        // Responses
        List<String> responses = Arrays.asList(
                "Để cập nhật hồ sơ, bạn có thể vào mục 'Hồ sơ' từ menu tài khoản ở góc trên bên phải. Tại đây, bạn có thể chỉnh sửa thông tin cá nhân, thêm kỹ năng, học vấn, kinh nghiệm làm việc và portfolio.",
                "Một hồ sơ freelancer hoàn chỉnh nên bao gồm: thông tin cá nhân, mô tả ngắn về bạn, các kỹ năng chuyên môn, kinh nghiệm làm việc, học vấn và các dự án đã thực hiện. Bạn cũng nên tải lên ảnh đại diện chuyên nghiệp để tăng độ tin cậy.",
                "Để thêm dự án vào portfolio, vào mục 'Hồ sơ' > 'Portfolio' > 'Thêm dự án mới'. Bạn có thể điền thông tin dự án, mô tả, công nghệ sử dụng và đính kèm hình ảnh hoặc link đến dự án."
        );

        int order = 0;
        for (String response : responses) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setResponseText(response);
            chatResponse.setDisplayOrder(order++);
            chatResponse.setIntent(intent);
            chatResponseRepository.save(chatResponse);
        }
    }

    private void createPaymentIntent() {
        ChatIntent intent = new ChatIntent();
        intent.setIntentName("payment");
        intent.setDescription("Thông tin về thanh toán");
        intent = chatIntentRepository.save(intent);

        // Training phrases
        List<String> trainingPhrases = Arrays.asList(
                "Làm sao để rút tiền",
                "Các phương thức thanh toán",
                "Phí sử dụng nền tảng",
                "Tôi muốn thanh toán cho dự án",
                "Cách nhận tiền",
                "Thanh toán an toàn",
                "Phí rút tiền",
                "Thời gian nhận tiền",
                "Cách thanh toán cho freelancer"
        );

        for (String phrase : trainingPhrases) {
            ChatTrainingPhrase trainingPhrase = new ChatTrainingPhrase();
            trainingPhrase.setPhraseText(phrase);
            trainingPhrase.setIsProcessed(true);
            trainingPhrase.setIntent(intent);
            chatTrainingPhraseRepository.save(trainingPhrase);
        }

        // Responses
        List<String> responses = Arrays.asList(
                "Freelancer Hub hỗ trợ nhiều phương thức thanh toán như: thẻ tín dụng/ghi nợ, PayPal, chuyển khoản ngân hàng và ví điện tử phổ biến tại Việt Nam.",
                "Để rút tiền, bạn cần vào mục 'Tài chính' > 'Rút tiền' trong tài khoản của bạn. Bạn có thể chọn phương thức rút tiền và số tiền muốn rút. Thời gian nhận tiền thường từ 1-3 ngày làm việc tùy thuộc vào phương thức rút tiền.",
                "Phí sử dụng nền tảng là 10% cho mỗi dự án thành công. Phí này sẽ được trừ trực tiếp từ số tiền bạn nhận được."
        );

        int order = 0;
        for (String response : responses) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setResponseText(response);
            chatResponse.setDisplayOrder(order++);
            chatResponse.setIntent(intent);
            chatResponseRepository.save(chatResponse);
        }
    }

    private void createFreelancerIntent() {
        ChatIntent intent = new ChatIntent();
        intent.setIntentName("find_freelancer");
        intent.setDescription("Tìm kiếm freelancer");
        intent = chatIntentRepository.save(intent);

        // Training phrases
        List<String> trainingPhrases = Arrays.asList(
                "Làm sao để tìm freelancer",
                "Tôi cần thuê người làm việc",
                "Tìm freelancer giỏi",
                "Làm thế nào để đánh giá freelancer",
                "Cách đăng công việc",
                "Tôi muốn thuê freelancer",
                "Phương thức liên hệ với freelancer",
                "Các tiêu chí chọn freelancer"
        );

        for (String phrase : trainingPhrases) {
            ChatTrainingPhrase trainingPhrase = new ChatTrainingPhrase();
            trainingPhrase.setPhraseText(phrase);
            trainingPhrase.setIsProcessed(true);
            trainingPhrase.setIntent(intent);
            chatTrainingPhraseRepository.save(trainingPhrase);
        }

        // Responses
        List<String> responses = Arrays.asList(
                "Để tìm freelancer, bạn có thể vào mục 'Tìm Freelancer' trên thanh điều hướng. Tại đây, bạn có thể sử dụng bộ lọc để tìm freelancer theo kỹ năng, kinh nghiệm, đánh giá hoặc ngân sách.",
                "Để đăng công việc mới, vào mục 'Đăng việc' và điền đầy đủ thông tin về dự án của bạn. Sau khi đăng, các freelancer phù hợp sẽ gửi đề xuất và bạn có thể lựa chọn người phù hợp nhất.",
                "Khi đánh giá freelancer, bạn nên xem xét các yếu tố: đánh giá từ khách hàng trước, tỷ lệ hoàn thành công việc, portfolio, và mức độ phù hợp của kỹ năng với nhu cầu của bạn."
        );

        int order = 0;
        for (String response : responses) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setResponseText(response);
            chatResponse.setDisplayOrder(order++);
            chatResponse.setIntent(intent);
            chatResponseRepository.save(chatResponse);
        }

        // Response with database query
        ChatResponse dbResponse = new ChatResponse();
        dbResponse.setResponseText("Hiện tại có {{count}} freelancer trong lĩnh vực {{category}}. Bạn có thể vào mục 'Tìm Freelancer' để xem chi tiết.");
        dbResponse.setDisplayOrder(order++);
        dbResponse.setIntent(intent);
        dbResponse.setRequiresDbQuery(true);
        dbResponse.setQueryTemplate("SELECT COUNT(f.id) as count, c.name as category FROM freelancer f JOIN category c ON f.category_id = c.id GROUP BY f.category_id");
        chatResponseRepository.save(dbResponse);
    }

    private void createSkillsIntent() {
        ChatIntent intent = new ChatIntent();
        intent.setIntentName("skills");
        intent.setDescription("Thông tin về kỹ năng và danh mục");
        intent = chatIntentRepository.save(intent);

        // Training phrases
        List<String> trainingPhrases = Arrays.asList(
                "Các kỹ năng phổ biến",
                "Danh mục công việc",
                "Lĩnh vực nào được trả lương cao nhất",
                "Kỹ năng nào đang có nhu cầu",
                "Những ngành nghề phổ biến nhất",
                "Công việc freelance phổ biến",
                "Kỹ năng nên học để kiếm việc freelance",
                "Ngành nghề nào kiếm tiền tốt nhất"
        );

        for (String phrase : trainingPhrases) {
            ChatTrainingPhrase trainingPhrase = new ChatTrainingPhrase();
            trainingPhrase.setPhraseText(phrase);
            trainingPhrase.setIsProcessed(true);
            trainingPhrase.setIntent(intent);
            chatTrainingPhraseRepository.save(trainingPhrase);
        }

        // Responses
        List<String> responses = Arrays.asList(
                "Các kỹ năng phổ biến trên Freelancer Hub bao gồm: lập trình web, thiết kế đồ họa, viết nội dung, dịch thuật, marketing số, phát triển ứng dụng di động, và SEO.",
                "Những lĩnh vực được trả lương cao nhất thường là phát triển blockchain, khoa học dữ liệu, AI/ML, phát triển phần mềm enterprise, và tư vấn chiến lược kinh doanh.",
                "Để tăng khả năng kiếm việc, bạn nên phát triển các kỹ năng có nhu cầu cao như lập trình (JavaScript, Python, React), thiết kế UI/UX, tối ưu hóa SEO, viết content marketing hoặc quản lý mạng xã hội."
        );

        int order = 0;
        for (String response : responses) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setResponseText(response);
            chatResponse.setDisplayOrder(order++);
            chatResponse.setIntent(intent);
            chatResponseRepository.save(chatResponse);
        }

        // Response with database query
        ChatResponse dbResponse = new ChatResponse();
        dbResponse.setResponseText("Dựa trên dữ liệu của chúng tôi, kỹ năng {{skill}} đang được yêu cầu trong {{count}} công việc. Đây là một trong những kỹ năng có nhu cầu cao trên nền tảng.");
        dbResponse.setDisplayOrder(order++);
        dbResponse.setIntent(intent);
        dbResponse.setRequiresDbQuery(true);
        dbResponse.setQueryTemplate("SELECT s.name as skill, COUNT(js.id) as count FROM job_skills js JOIN skills s ON js.skill_id = s.id GROUP BY js.skill_id ORDER BY count DESC LIMIT 1");
        chatResponseRepository.save(dbResponse);
    }

    private void createPasswordResetIntent() {
        ChatIntent intent = new ChatIntent();
        intent.setIntentName("password_reset");
        intent.setDescription("Hỗ trợ đặt lại mật khẩu");
        intent = chatIntentRepository.save(intent);

        // Training phrases
        List<String> trainingPhrases = Arrays.asList(
                "Tôi quên mật khẩu",
                "Làm sao để đặt lại mật khẩu",
                "Không thể đăng nhập",
                "Cách lấy lại mật khẩu",
                "Đổi mật khẩu",
                "Reset password",
                "Mất mật khẩu",
                "Khôi phục mật khẩu"
        );

        for (String phrase : trainingPhrases) {
            ChatTrainingPhrase trainingPhrase = new ChatTrainingPhrase();
            trainingPhrase.setPhraseText(phrase);
            trainingPhrase.setIsProcessed(true);
            trainingPhrase.setIntent(intent);
            chatTrainingPhraseRepository.save(trainingPhrase);
        }

        // Responses
        List<String> responses = Arrays.asList(
                "Để đặt lại mật khẩu, bạn có thể nhấn vào liên kết 'Quên mật khẩu' trên trang đăng nhập. Sau đó, nhập email đã đăng ký và hệ thống sẽ gửi cho bạn link đặt lại mật khẩu.",
                "Nếu bạn quên mật khẩu, vui lòng truy cập trang đăng nhập và nhấn vào 'Quên mật khẩu'. Bạn sẽ nhận được email hướng dẫn cách đặt lại mật khẩu trong vòng vài phút.",
                "Để bảo mật tài khoản, bạn nên đặt mật khẩu mạnh với ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt. Không nên sử dụng cùng một mật khẩu cho nhiều tài khoản khác nhau."
        );

        int order = 0;
        for (String response : responses) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setResponseText(response);
            chatResponse.setDisplayOrder(order++);
            chatResponse.setIntent(intent);
            chatResponseRepository.save(chatResponse);
        }
    }

    private void createHelpIntent() {
        ChatIntent intent = new ChatIntent();
        intent.setIntentName("help");
        intent.setDescription("Trợ giúp chung");
        intent = chatIntentRepository.save(intent);

        // Training phrases
        List<String> trainingPhrases = Arrays.asList(
                "Bạn có thể giúp gì cho tôi",
                "Tôi cần trợ giúp",
                "Hướng dẫn sử dụng",
                "Trung tâm hỗ trợ",
                "FAQ",
                "Câu hỏi thường gặp",
                "Hỗ trợ",
                "Help",
                "Giúp đỡ"
        );

        for (String phrase : trainingPhrases) {
            ChatTrainingPhrase trainingPhrase = new ChatTrainingPhrase();
            trainingPhrase.setPhraseText(phrase);
            trainingPhrase.setIsProcessed(true);
            trainingPhrase.setIntent(intent);
            chatTrainingPhraseRepository.save(trainingPhrase);
        }

        // Responses
        List<String> responses = Arrays.asList(
                "Tôi có thể giúp bạn về: Tìm kiếm công việc, tìm kiếm freelancer, quản lý hồ sơ, phương thức thanh toán, hoặc các vấn đề kỹ thuật khác. Bạn cần hỗ trợ về vấn đề gì?",
                "Bạn có thể truy cập Trung tâm Hỗ trợ của chúng tôi tại menu chính để xem các câu hỏi thường gặp hoặc tìm kiếm giải pháp cho vấn đề cụ thể.",
                "Nếu bạn cần hỗ trợ trực tiếp, bạn có thể liên hệ với đội ngũ hỗ trợ khách hàng qua email support@freelancerhub.example.com hoặc gọi điện đến số hotline 1900-xxxx trong giờ làm việc."
        );

        int order = 0;
        for (String response : responses) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setResponseText(response);
            chatResponse.setDisplayOrder(order++);
            chatResponse.setIntent(intent);
            chatResponseRepository.save(chatResponse);
        }
    }
}