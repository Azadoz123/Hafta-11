package patika.dev.libraryControlSystem.core.config.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import patika.dev.libraryControlSystem.core.result.*;
import patika.dev.libraryControlSystem.core.exception.*;
import patika.dev.libraryControlSystem.core.utilies.*;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e){
        List<String> validationErrorList = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).collect(Collectors.toList());

        ResultData<List<String>> resultData = new ResultData<>(false, Msg.VALIDATE_ERROR,"400",validationErrorList);
        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }

    // not found exception
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> notFoundException(NotFoundException e){
        return new ResponseEntity<>(ResultHelper.notFoundError(e.getMessage()),HttpStatus.NOT_FOUND);
    }
    //not added animal exception
    @ExceptionHandler(NotAddedAnimalException.class)
    public ResponseEntity<Result> notAddedAnimalException(NotAddedAnimalException e){
        return new ResponseEntity<>(ResultHelper.notAddedAnimalError(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
    //not added appointment date exception
    @ExceptionHandler(NotAddedAppointmentDateException.class)
    public ResponseEntity<Result> notAddedAppointmentDateException(NotAddedAppointmentDateException e){
        return new ResponseEntity<>(ResultHelper.notAddedAppointmentDateError(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
    // not added available date exception
    @ExceptionHandler(NotAddedAvailableDateException.class)
    public ResponseEntity<Result> notAddedAvailableDateException(NotAddedAvailableDateException e){
        return new ResponseEntity<>(ResultHelper.notAddedAvailableDateError(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
    //not added customer exception
    @ExceptionHandler(NotAddedCustomerException.class)
    public ResponseEntity<Result> notAddedCustomerException(NotAddedCustomerException e){
        return new ResponseEntity<>(ResultHelper.notAddedCustomerError(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
    //not addded doctor-available date exception
    @ExceptionHandler(NotAddedDoctorAvailableDateException.class)
    public ResponseEntity<Result> notAddedDoctorAvailableDateException(NotAddedDoctorAvailableDateException e){
        return new ResponseEntity<>(ResultHelper.notAddedDoctorAvailableDateError(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
    //not added doctor exception
    @ExceptionHandler(NotAddedDoctorException.class)
    public ResponseEntity<Result> notAddedDoctorException(NotAddedDoctorException e){
        return new ResponseEntity<>(ResultHelper.notAddedDoctorError(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
    //not added vaccine exception
    @ExceptionHandler(NotAddedVaccineException.class)
    public ResponseEntity<Result> notAddedVaccineException(NotAddedVaccineException e){
        return new ResponseEntity<>(ResultHelper.notAddedVaccineError(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
    // not updated exception
    @ExceptionHandler(NotUpdatedException.class)
    public ResponseEntity<Result> notUpdatedAnimalException(NotUpdatedException e){
        return new ResponseEntity<>(ResultHelper.notUpdatedError(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
    // not deleted exception
    @ExceptionHandler(NotDeletedException.class)
    public ResponseEntity<Result> notDeletedAnimalException(NotDeletedException e){
        return new ResponseEntity<>(ResultHelper.notDeletedError(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
