package com.example.tailor.kandoraexpress.api;


import com.example.tailor.kandoraexpress.CRM.customer.modal.SellerCustomer;
import com.example.tailor.kandoraexpress.CRM.customer.modal.Sellercustomerpost;
import com.example.tailor.kandoraexpress.CRM.modal.CustomerDetail;
import com.example.tailor.kandoraexpress.CRM.modal.Customers;
import com.example.tailor.kandoraexpress.order.modal.OrderItem;
import com.example.tailor.kandoraexpress.products.addproducts.modal.Addproductmodal;
import com.example.tailor.kandoraexpress.products.addproducts.modal.Categories;
import com.example.tailor.kandoraexpress.products.modal.Product;
import com.example.tailor.kandoraexpress.user.forgotpassword.modal.Forgotmail;
import com.example.tailor.kandoraexpress.user.login.modal.Login;
import com.example.tailor.kandoraexpress.user.login.modal.User;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APICall {

    @POST("api/tailor/login")
    Observable<Response<User>> login(@Body Login login);


    @POST("api/tailor/forgotpassword")
    Observable<Response<User>> forgotmail(@Body Forgotmail forgotmail);

    @GET("api/tailor/productlist/{token}")
    Observable<Response<Product>> productlist(@Path("token") String token);

    @GET("api/tailor/categories")
    Observable<Response<Categories>> getCategory();


    @POST("api/tailor/productadd/{token}")
    Observable<Response<GeneralResponse>> addproduct(@Path("token") String token, @Body Addproductmodal addproductmodal);

    @POST("api/tailor/productupdate/{productId}/{token}")
    Observable<Response<GeneralResponse>> updateProduct(@Path("productId") String productId, @Path("token") String token, @Body Addproductmodal addproductmodal);

    @GET("api/tailor/productdelete/{productId}/{token}")
    Observable<Response<GeneralResponse>> deleteProduct(@Path("productId") String productId, @Path("token") String token);

    @GET("api/tailor/orders/{statuskey}/{token}")
    Observable<Response<OrderItem>>orderlist(@Path("statuskey")String statuskey, @Path("token") String token);

    @GET("api/tailor/orderdetaile/{orderId}/{token}")
    Observable<Response<OrderItem>>orderlistdetailsinfo(@Path("orderId")String orderId,@Path("token")String token);


    @GET("api/tailor/orderstatus/{orderId}/change/{statuskey}/{token}")
    Observable<Response<GeneralResponse>>orderststuschange(@Path("orderId")String orderId,@Path("statuskey")String statuskey,@Path("token")String token);


    @GET("api/tailor/sellercustomers/{token}")
    Observable<Response<Customers>>crmcustomerlist(@Path("token")String token);


    @GET("api/tailor/sellercustomer/info/{cid}/{token}")
    Observable<Response<CustomerDetail>>crmcustomerdetails(@Path("cid")String customerID, @Path("token")String token);


    @POST("api/tailor/create/sellercustomer/{token}")
    Observable<Response<GeneralResponse>>createsellercusstomer(@Path("token")String token, @Body Sellercustomerpost sellercustomerpost);


}


