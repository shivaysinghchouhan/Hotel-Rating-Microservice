package com.notification.service.email.service;

import com.notification.service.beans.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public void sendOrderConfirmation(OrderPlacedEvent event, String toEmail) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            // ✅ Use configured email
            helper.setFrom(new InternetAddress(senderEmail, "Order Support"));
            helper.setTo(toEmail);
            helper.setReplyTo(senderEmail);
            helper.setSubject("Order Confirmation - " + event.getOrderId());

            StringBuilder body = new StringBuilder();
            body.append("<html><body>");
            body.append("<h2 style='color:#2E86C1;'>Order Confirmation</h2>");
            body.append("<p>Dear <b>").append(event.getUserId()).append("</b>,</p>");
            body.append("<p>Thank you for shopping with us! Your order has been received successfully.</p>");
            body.append("<p><b>Order Details:</b></p>");
            body.append("<ul>");
            body.append("<li><b>Order ID:</b> ").append(event.getOrderId()).append("</li>");
            body.append("<li><b>Amount:</b> ").append(event.getAmount()).append(" ").append(event.getCurrency()).append("</li>");
            body.append("</ul>");

            body.append("<p><b>Items:</b></p><ul>");
            for (OrderPlacedEvent.Item item : event.getItems()) {
                body.append("<li>")
                        .append(item.getSku())
                        .append(" - Qty: ").append(item.getQty())
                        .append(" - Price: ").append(item.getPrice())
                        .append("</li>");
            }
            body.append("</ul>");

            body.append("<p><b>Order Date:</b> ").append(event.getCreatedAt()).append("</p>");
            body.append("<p><b>Trace ID:</b> ").append(event.getTraceId()).append("</p>");
            body.append("<br><p>We will notify you once your order is shipped.</p>");
            body.append("<p>Regards,<br><b>Order Support Team</b></p>");
            body.append("</body></html>");

            helper.setText(body.toString(), true);

            mailSender.send(message);
            log.info("✅ Email sent successfully to {} for Order {}", toEmail, event.getOrderId());

        } catch (Exception e) {
            log.error("❌ Failed to send email to {} for Order {}: {}", toEmail, event.getOrderId(), e.getMessage(), e);
        }
    }
}
