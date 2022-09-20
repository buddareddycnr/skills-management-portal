package co.uk.skills.util;

import co.uk.skills.dto.ErrorDetails;
import co.uk.skills.dto.Response;
import org.springframework.http.HttpStatus;

public final class CreateResponse {
    public static <T> Response<T> createResponse(T responseBody){
        var response = new Response<T>();
        if(null != responseBody)
        response.setResponse(responseBody);
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode(200);
        errorDetails.setErrorMessage("Save operation is successful");
        response.setErrorDetails(errorDetails);
        return response;
    }
    public static <T> Response<T> createResponse(Exception exception, HttpStatus httpStatus){
        var response = new Response<T>();
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode(httpStatus.value());
        errorDetails.setErrorMessage(exception.getMessage());
        response.setErrorDetails(errorDetails);
        return response;
    }
}
