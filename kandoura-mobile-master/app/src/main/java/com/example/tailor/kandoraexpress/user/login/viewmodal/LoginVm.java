package com.example.tailor.kandoraexpress.user.login.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.ActivityLoginBinding;
import com.example.tailor.kandoraexpress.home.MainActivity;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.user.forgotpassword.ForgotActivity;
import com.example.tailor.kandoraexpress.user.login.modal.Login;
import com.example.tailor.kandoraexpress.user.login.modal.User;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;
import com.example.tailor.kandoraexpress.util.Util;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class LoginVm {

    Activity activity;

    MyProgressDialog myProgressDialog;
    Login login;
    ActivityLoginBinding binding;

    public LoginVm(Activity activity, Login login, ActivityLoginBinding binding) {
        this.activity = activity;
        this.login = login;
        this.binding = binding;
        myProgressDialog = new MyProgressDialog();
    }


    public void OnClickforgotpassword(View view) {
        activity.startActivity(new Intent(activity, ForgotActivity.class));
    }

    public void OnClicksignin(View view) {

        validation();

    }

    private void validation() {

        if (login.getUsername().trim().length() == 0 || !Patterns.EMAIL_ADDRESS.matcher(login.getUsername().trim()).matches()) {

            binding.loginEmail.setError("Please enter the Email Address");

        } else if (login.getPassword().trim().length() == 0) {

            binding.loginPassword.setError("Please enter the password");
        } else {

            loginAPICall();
        }
    }

    private void loginAPICall() {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<User>> observable = api.login(login);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        Log.e("response", "" + responses.code());

                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {
                            MySession.getInstance(activity).saveLoginStatus(true);
                            MySession.getInstance(activity).saveUser(responses.body());
                            navigateToNextScreen(responses.body());
                        } else {
                            if (responses.body() != null) {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.body().getMessage());
                            } else {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.errorBody().string());
                            }
                        }
                    }, throwable -> {
                        myProgressDialog.dismissDialog();
                        MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.something_went_wrong_while_retrieving_information));

                    });
        } else {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.no_internet));
        }
    }

    private void navigateToNextScreen(User body) {

        activity.startActivity(new Intent(activity, MainActivity.class));

    }

}
