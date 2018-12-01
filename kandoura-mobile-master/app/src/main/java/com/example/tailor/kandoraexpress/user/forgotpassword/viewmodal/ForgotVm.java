package com.example.tailor.kandoraexpress.user.forgotpassword.viewmodal;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.ActivityForgotpasswordBinding;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.user.forgotpassword.modal.Forgotmail;
import com.example.tailor.kandoraexpress.user.login.modal.User;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ForgotVm {
    Activity activity;
    Forgotmail forgotmail;
    MyProgressDialog myProgressDialog;
    ActivityForgotpasswordBinding binding;

    public ForgotVm(Activity activity, Forgotmail forgotmail, ActivityForgotpasswordBinding binding) {
        this.activity = activity;
        this.forgotmail = forgotmail;
        this.binding=binding;
        myProgressDialog = new MyProgressDialog();

    }


    public void OnClickforgotemail(View view) {

        validation();

    }

    private void validation() {

        if (forgotmail.getEmail().trim().length() == 0) {

            binding.forgotPasswordtext.setError("Please enter the  valid Email Address");

            //binding.forgotPasswordLayout.setError("Please enter the  valid Email Address");
        } else {
            forgotmailAPICall();
        }
    }

    private void forgotmailAPICall() {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<User>> observable = api.forgotmail(forgotmail);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        Log.e("response", "" + responses.code());

                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            MySnackBar.getInstance().showPositiveSnackBar(activity, responses.body().getMessage());

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
}
