package co.uk.skills.exception;

import co.uk.skills.dto.Response;
import co.uk.skills.util.CreateResponse;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SkillManagementControllerAdvisor extends ResponseEntityExceptionHandler {

    /**
     *
     */
    public SkillManagementControllerAdvisor() {
        super();
    }

    @ExceptionHandler(ExceedMaximumAllowedSkillsException.class)
    public ResponseEntity<Response> exceedMaximumAllowedSkillsException(ExceedMaximumAllowedSkillsException exceedMaximumAllowedSkillsException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(exceedMaximumAllowedSkillsException,HttpStatus.BANDWIDTH_LIMIT_EXCEEDED),HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Response> customerNotFoundException(CustomerNotFoundException customerNotFoundException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(customerNotFoundException,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DeleteOperationFailedException.class)
    public ResponseEntity<Response> deleteOperationFailedException(DeleteOperationFailedException deleteOperationFailedException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(deleteOperationFailedException,HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(InvalidEmailIdPatternException.class)
    public ResponseEntity<Response> invalidEmailIdPatternException(InvalidEmailIdPatternException invalidEmailIdPatternException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(invalidEmailIdPatternException,HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidMobileNumberFormatException.class)
    public ResponseEntity<Response> invalidMobileNumberFormatException(InvalidMobileNumberFormatException invalidMobileNumberFormatException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(invalidMobileNumberFormatException,HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<Response> loginFailedException(LoginFailedException loginFailedException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(loginFailedException,HttpStatus.FORBIDDEN),HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(MandatoryFieldMissingException.class)
    public ResponseEntity<Response> mandatoryFieldMissingException(MandatoryFieldMissingException mandatoryFieldMissingException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(mandatoryFieldMissingException,HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<Response> organizationNotFoundException(OrganizationNotFoundException organizationNotFoundException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(organizationNotFoundException,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SaveOrUpdateOperationFailedException.class)
    public ResponseEntity<Response> saveOrUpdateOperationFailedException(SaveOrUpdateOperationFailedException saveOrUpdateOperationFailedException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(saveOrUpdateOperationFailedException,HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(SkillNotFoundException.class)
    public ResponseEntity<Response> skillNotFoundException(SkillNotFoundException skillNotFoundException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(skillNotFoundException,HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnknownException.class)
    public ResponseEntity<Response> unknownException(UnknownException unknownException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(unknownException,HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UnsupportedAccountStatusException.class)
    public ResponseEntity<Response> unsupportedAccountStatusException(UnsupportedAccountStatusException unsupportedAccountStatusException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(unsupportedAccountStatusException,HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnsupportedAreaOfInterestException.class)
    public ResponseEntity<Response> unsupportedAreaOfInterestException(UnsupportedAreaOfInterestException unsupportedAreaOfInterestException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(unsupportedAreaOfInterestException,HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnsupportedGenderException.class)
    public ResponseEntity<Response> unsupportedGenderException(UnsupportedGenderException unsupportedGenderException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(unsupportedGenderException,HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnsupportedTitleException.class)
    public ResponseEntity<Response> unsupportedTitleException(UnsupportedTitleException unsupportedTitleException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(unsupportedTitleException,HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnsupportedProficiencyLevelException.class)
    public ResponseEntity<Response> unsupportedProficiencyLevelException(UnsupportedProficiencyLevelException unsupportedProficiencyLevelException, WebRequest request){
        return new ResponseEntity<>(CreateResponse.createResponse(unsupportedProficiencyLevelException,HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpMediaTypeNotSupported(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpMediaTypeNotAcceptable(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMissingPathVariable(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMissingServletRequestParameter(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleServletRequestBindingException(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleConversionNotSupported(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleTypeMismatch(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpMessageNotReadable(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpMessageNotWritable(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMissingServletRequestPart(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleBindException(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleNoHandlerFoundException(ex, headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param webRequest
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
        return super.handleAsyncRequestTimeoutException(ex, headers, status, webRequest);
    }

    /**
     * @param ex
     * @param body
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
