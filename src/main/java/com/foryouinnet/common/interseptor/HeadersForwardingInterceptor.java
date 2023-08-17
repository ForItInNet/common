package com.foryouinnet.common.interseptor;

import com.foryouinnet.common.model.enumeration.CustomHeaderEnum;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class HeadersForwardingInterceptor implements RequestInterceptor {

    private final String[] HEADERS_TO_FORWARD = new String[] { CustomHeaderEnum.CLIENT_IDENTIFIER.toString() };

    private final HttpServletRequest httpServletRequest;

    @Override
    public void apply(RequestTemplate template) {

        addRequiredHeaders(template);
    }

    private void addRequiredHeaders(@NonNull RequestTemplate template) {
        for(String headerToForward: HEADERS_TO_FORWARD) {
            String header = httpServletRequest.getHeader(headerToForward);

            if(header != null) {
                Map<String, Collection<String>> headers = template.headers();
                headers.put(headerToForward, List.of(header));
                template.headers(headers);
            }
        }
    }
}
