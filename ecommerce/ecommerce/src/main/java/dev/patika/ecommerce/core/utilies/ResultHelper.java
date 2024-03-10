package dev.patika.ecommerce.core.utilies;

import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.dto.response.CursorResponse;
import dev.patika.ecommerce.dto.response.category.CategoryResponseDto;
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

    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData){
        CursorResponse<T> cursorResponse = new CursorResponse<>();
        cursorResponse.setItems(pageData.getContent());
        cursorResponse.setPageNumber(pageData.getNumber());
        cursorResponse.setPageSize(pageData.getSize());
        cursorResponse.setTotalElements(pageData.getTotalElements());

        return ResultHelper.suceess(cursorResponse);
    }
}
