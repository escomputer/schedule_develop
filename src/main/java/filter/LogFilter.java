package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {
    private static final String[] WHITE_LIST = {"/","/api/users/register","/api/log/login","/api/log/logout"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException{
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String uri = httpRequest.getRequestURI();

        log.info("로그인 필터 로직 실행");

        if(!isWhiteList(uri)){
            HttpSession session = httpRequest.getSession();

            if(session != null || session.getAttribute("user") != null){
                log.warn("인증 실패");
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.getWriter().write("{\"error\": \"Unauthorized\"}");
                return;

            }
            log.info("인증에 성공하여 요청을 진행합니다.");


        }
        chain.doFilter(request, response);
    }

    private boolean isWhiteList(String uri) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, uri);
    }
}
