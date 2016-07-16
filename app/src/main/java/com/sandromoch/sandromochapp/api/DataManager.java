package com.sandromoch.sandromochapp.api;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sandromoch.sandromochapp.CoreApp;
import com.sandromoch.sandromochapp.R;
import com.sandromoch.sandromochapp.models.monument.Memorials;
import com.sandromoch.sandromochapp.models.monument.MonumentResponse;
import com.sandromoch.sandromochapp.util.Logger;
import com.sandromoch.sandromochapp.util.Validator;

import java.io.IOException;
import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Responsible for management of all the app's requests.
 * Also manages app's data here.
 */
public class DataManager {

    public static final String TAG = "DataManager";

    public static final String EMPTY_SERVER_MESSAGE = "";
    private static final int ERROR_NULL_RESPONSE_OBJECT = 1;

    private OnResponseListener mResponseListener;
    private RetrofitRequest request;

    public DataManager(RetrofitRequest retrofitRequest) {
        this.request = retrofitRequest;
    }

    /**********************************************************************************************/
    /***************************************** SET UP *********************************************/
    /**********************************************************************************************/

    /**
     * Delivers response to listener, manages all the possible statuses of AppResponse object.
     * Generates response messages if failed.
     *
     * @param response - AppResponse
     */
    public boolean deliverResponse(Response<?> response, String requestTag) {
        CoreApp.getInstance().showLoadingDialog();
        if (Validator.isObjectValid(mResponseListener)) {
            if (Validator.isObjectValid(response)) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    mResponseListener.onResponseSuccess(response, requestTag);
                    CoreApp.getInstance().closeLoadingDialog();
                    return true;
                } else {
                    try {
                        String message = new Gson().fromJson(response.errorBody().string(), String.class);
                        if (Validator.isObjectValid(message)) {
                            notifyFailed(generateFailMessage(response.code()), message);
                        }
                    } catch (IOException | JsonSyntaxException | IllegalStateException e) {
                        notifyFailed(generateFailMessage(response.code()), EMPTY_SERVER_MESSAGE);
                        Logger.e("DataManager", e.toString());
                    }
                    CoreApp.getInstance().closeLoadingDialog();
                    return false;
                }
            } else {
                CoreApp.getInstance().closeLoadingDialog();
                notifyFailed(ERROR_NULL_RESPONSE_OBJECT, EMPTY_SERVER_MESSAGE);
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Notifies that response has failed
     *
     * @param statusIntMessage    - resources id
     * @param statusStringMessage - string message
     */
    private void notifyFailed(int statusIntMessage, String statusStringMessage) {
        if (Validator.isObjectValid(mResponseListener)) {
            mResponseListener.onResponseFail(statusIntMessage, statusStringMessage);
        }
    }

    private void notifyNoNetwork() {
        if (Validator.isObjectValid(mResponseListener)) {
            mResponseListener.onNoNetwork();
        }
    }


    /**
     * Registers Response Listener
     *
     * @param listener - Listener
     */
    public void registerResponseListener(OnResponseListener listener) {
        this.mResponseListener = listener;
    }

    /**
     * Generates string resource identifier of response basing on status code.
     *
     * @param statusCode - int status code
     */
    private int generateFailMessage(int statusCode) {
        int failMsg = -1;
        switch (statusCode) {
            case HttpURLConnection.HTTP_BAD_REQUEST:
                failMsg = R.string.http_bad_request;
                break;
            case HttpURLConnection.HTTP_FORBIDDEN:
                failMsg = R.string.http_forbidden;
                break;
            case HttpURLConnection.HTTP_NOT_FOUND:
                failMsg = R.string.http_not_found;
                break;
            case HttpURLConnection.HTTP_INTERNAL_ERROR:
                failMsg = R.string.http_server_error;
                break;
        }
        return failMsg;
    }

    /**
     * Logs onFail callback
     *
     * @param throwable - Throwable
     */
    private void logException(Throwable throwable) {
        if (Validator.isObjectValid(throwable)) {
            Logger.e(TAG, throwable.toString());
        }
    }

    /**
     * Checks whether Throwable is of IOException - meaning that there's no Internet connection
     *
     * @param t - Throwable
     * @return - true if IOException
     */
    private boolean isNoNetworkException(Throwable t) {
        if (t instanceof IOException) {
            notifyNoNetwork();
            return true;
        } else {
            logException(t);
            return false;
        }
    }

    /**
     * Listener to deliver response to
     */
    public interface OnResponseListener {
        //Notifies response is success
        void onResponseSuccess(Response<?> response, String pendingRequestTag);

        //Notifies response failed
        void onResponseFail(int statusMessage, String serverMessage);

        //Notifies listener of No Internet issue
        void onNoNetwork();
    }

    /**********************************************************************************************/
    /**************************************** Requests ********************************************/
    /**********************************************************************************************/


    public void getMonuments() {

        request.getMonuments(new Callback<MonumentResponse>() {
            @Override
            public void onResponse(Call<MonumentResponse> call, Response<MonumentResponse> response) {
                deliverResponse(response, "");
            }

            @Override
            public void onFailure(Call<MonumentResponse> call, Throwable t) {

            }
        });
    }

    public void getMemorials() {

        request.getMemorials(new Callback<Memorials>() {
            @Override
            public void onResponse(Call<Memorials> call, Response<Memorials> response) {
                deliverResponse(response, "");
            }

            @Override
            public void onFailure(Call<Memorials> call, Throwable t) {

            }
        });
    }


    /**********************************************************************************************/
    /************************************** Local Requests ****************************************/
    /**********************************************************************************************/

}
