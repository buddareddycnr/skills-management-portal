package co.uk.skills.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@RequiredArgsConstructor
@Setter
@Getter
public class ErrorDetails implements Serializable {
    private static final long serialVersionUID = -3436519393647875251L;
    private int errorCode;
    private String errorMessage;
}
