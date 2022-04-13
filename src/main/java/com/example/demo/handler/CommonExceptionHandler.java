package com.example.demo.handler;

import com.example.demo.exception.CommonException;
import com.example.demo.vo.ResponseVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestControllerAdvice
public class CommonExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(CommonException.class)
	public ResponseVo handleRRException(CommonException e){
		ResponseVo r = new ResponseVo();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseVo handlerNoFoundException(Exception e) {
		logger.error(e.getMessage(), e);
		return ResponseVo.error(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseVo handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return ResponseVo.error("数据库中已存在该记录");
	}


	@ExceptionHandler(Exception.class)
	public ResponseVo handleException(Exception e){
		logger.error(e.getMessage(), e);
		return ResponseVo.error();
	}
}