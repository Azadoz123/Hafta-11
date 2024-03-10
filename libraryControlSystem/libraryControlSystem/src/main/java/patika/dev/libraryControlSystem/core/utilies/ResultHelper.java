package patika.dev.libraryControlSystem.core.utilies;
import patika.dev.libraryControlSystem.core.result.*;


import org.springframework.data.domain.Page;

public class ResultHelper {
    public static <T> ResultData<T> created(T data){
        return new  ResultData<>(true,Msg.CREATED,"201",data);
    }


    public static <T> ResultData<T> validateError(T data){
        return new  ResultData<>(false,Msg.VALIDATE_ERROR,"400",data);

    }

    public static <T> ResultData<T> suceess(T data){
        return new  ResultData<>(true,Msg.OK,"200",data);

    }

    public static Result ok(){
        return new Result(true,Msg.OK,"200");
    }

    public static Result notFoundError(String msg){
        return new  Result(false,msg,"404");

    }
    public static Result notAddedAnimalError(String msg){
        return new  Result(false,msg,"400");

    }

    public static Result notAddedAppointmentDateError(String msg){
        return new  Result(false,msg,"400");

    }
    public static Result notAddedAvailableDateError(String msg){
        return new  Result(false,msg,"400");

    }

    public static Result notAddedCustomerError(String msg){
        return new  Result(false,msg,"400");

    }
    public static Result notAddedDoctorAvailableDateError(String msg){
        return new  Result(false,msg,"400");

    }

    public static Result notAddedDoctorError(String msg){
        return new  Result(false,msg,"400");

    }
    public static Result notAddedVaccineError(String msg){
        return new  Result(false,msg,"400");

    }
    public static Result notUpdatedCustomerError(String msg){
        return new  Result(false,msg,"400");

    }
    public static Result notUpdatedError(String msg){
        return new  Result(false,msg,"400");

    }

    public static Result notDeletedError(String msg){
        return new  Result(false,msg,"400");

    }

}
