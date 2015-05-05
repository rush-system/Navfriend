package com.nightfall.navfriend.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nightfall.navfriend.data.RequestSuccess;
import com.nightfall.navfriend.data.Travel;
import com.nightfall.navfriend.data.User;
import com.nightfall.navfriend.data.UserTravel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import us.monoid.json.JSONException;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

import static us.monoid.web.Resty.content;
import static us.monoid.web.Resty.put;

/**
 * Created by Dev on 05/05/2015.
 */
public class AddUserToTravel extends AsyncTask<UserTravel, Void, RequestSuccess> {

    Activity activity;

    public AddUserToTravel(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected RequestSuccess doInBackground(UserTravel... params) {
        UserTravel travel = params[0];




        RequestSuccess request;

        try {
            Gson gson = new Gson();
            String json = gson.toJson(travel);

            Resty resty = new Resty();

            JSONResource res = resty.json("http://192.168.201.116:8182/adduser", put(content(json)));
            request = gson.fromJson(res.toObject().toString(), RequestSuccess.class);

            return request;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(RequestSuccess success) {
        if(success.isStatus()){
            Toast.makeText(activity, "SURCESS", Toast.LENGTH_LONG);
        }else{
            Toast.makeText(activity, "SOTTERCESS", Toast.LENGTH_LONG);
        }
    }
}
