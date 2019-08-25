package org.com.sbm.cadence.common.exceptions.controller_handlers;

import org.com.sbm.cadence.common.dto.ResponseDTO;
import org.com.sbm.cadence.common.exceptions.types.BusinessException;
import org.com.sbm.cadence.common.exceptions.types.ControllerException;
import org.com.sbm.cadence.common.exceptions.types.PumaServiceException;
import org.com.sbm.cadence.common.exceptions.types.RespositoryException;
import org.com.sbm.cadence.common.exceptions.types.ValidationException;
import org.com.sbm.cadence.common.exceptions.types.CadenceApplicationException;
import org.com.sbm.cadence.common.utilities.MessagesUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



/**
 * 
 * @author Haythem Alshaikh
 *
 */
@ControllerAdvice
@RestController
public class ControllerAdviceExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CadenceApplicationException.class)
	public final ResponseDTO doYesserException(CadenceApplicationException ex){
		return new ResponseDTO(ex.getErrorCode(), ex.getMessageEn(), 
				ex.getMessageAr(), null, null);
	}
	
	@ExceptionHandler(ControllerException.class)
	public final ResponseDTO doControllerException(ControllerException ex) {
		return new ResponseDTO(ex.getErrorCode(), ex.getMessageEn(), 
				ex.getMessageAr(), null, null);
	}
	
	@ExceptionHandler(BusinessException.class)
	public final ResponseDTO doBusinessException(BusinessException ex) {
		return new ResponseDTO(ex.getErrorCode(), ex.getMessageEn(), 
				ex.getMessageAr(), null, null);
	}
	
	@ExceptionHandler(RespositoryException.class)
	public final ResponseDTO doRespositoryException(RespositoryException ex) {
		return new ResponseDTO(ex.getErrorCode(), ex.getMessageEn(), 
				ex.getMessageAr(), null, null);
	}
	
	@ExceptionHandler(PumaServiceException.class)
	public final ResponseDTO doPumaServiceException(PumaServiceException ex) {
		return new ResponseDTO(ex.getErrorCode(), ex.getMessageEn(), 
				ex.getMessageAr(), null, null);
	}
	
	@ExceptionHandler(ValidationException.class)
	public final ResponseDTO doValidationException(ValidationException ex) {
		return new ResponseDTO(ex.getErrorCode(), ex.getMessageEn(), 
				ex.getMessageAr(), null, null);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
		String errorCode = ex.getBindingResult().getFieldError().getDefaultMessage();
		String messageEn = MessagesUtil.getMessageEn(errorCode);
		String messageAr = MessagesUtil.getMessageAr(errorCode);
		ResponseDTO responseDTO = new ResponseDTO(errorCode, messageEn, 
				messageAr, ex.getMessage(), ex.getMessage());
	    return new ResponseEntity<Object>(responseDTO, HttpStatus.BAD_REQUEST);
	} 
}