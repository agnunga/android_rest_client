package com.ag.timesheet.api;

import com.ag.timesheet.models.ActivitiesDto;
import com.ag.timesheet.models.CostCentre;
import com.ag.timesheet.models.CostCentresDto;
import com.ag.timesheet.models.MessageResponse;
import com.ag.timesheet.models.MessagesDto;
import com.ag.timesheet.models.Project;
import com.ag.timesheet.models.ProjectsDto;
import com.ag.timesheet.models.Result;
import com.ag.timesheet.models.UsersDto;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;



public interface APIService {

    @FormUrlEncoded
    @POST("register")
    Call<Result> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("gender") String gender);


    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );


    @GET("users")
    Call<UsersDto> getUsers();

    @GET("activities")
    Call<ActivitiesDto> getActivities();

    @GET("cost_centres")
    Call<CostCentresDto> getCostCentres();

    @GET("projects")
    Call<ProjectsDto> getProjectCall();

    @FormUrlEncoded
    @POST("sendmessage")
    Call<MessageResponse> sendMessage(
            @Field("from") int from,
            @Field("to") int to,
            @Field("title") String title,
            @Field("message") String message);

    @FormUrlEncoded
    @POST("update/{id}")
    Call<Result> updateUser(
            @Path("id") int id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("gender") String gender
    );

    //getting messages
    @GET("messages/{id}")
    Call<MessagesDto> getMessages(@Path("id") int id);
}
