package co.uk.skills.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Response<T>{

    private T response;
    private ErrorDetails errorDetails;

}
