package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



@Component
public class LogInterceptor extends HandlerInterceptorAdapter{
	
	protected Log log = LogFactory.getLog(LogInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// TODO Auto-generated method stub
	            log.info("======================================           END          ======================================\n");

//		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		return super.preHandle(request, response, handler);
            log.info("======================================          START         ======================================");
            log.info(" Request URI \t:  " + request.getRequestURI());
        return super.preHandle(request, response, handler);
	}
	
}
