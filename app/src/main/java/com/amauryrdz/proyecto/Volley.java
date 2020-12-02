package com.amauryrdz.proyecto;

import android.content.Context;

import com.android.volley.RequestQueue;

public class Volley {
    private static Volley mVolley = null;
    private RequestQueue mResquestQueue;

    private Volley(Context context)
    {
        mResquestQueue = com.android.volley.toolbox.Volley.newRequestQueue(context);
    }
    public static Volley getInstance(Context context)
    {
        if (mVolley == null)
        {
            mVolley = new Volley(context);
        }
        return mVolley;
    }
    public RequestQueue getmResquestQueue()
    {
        return mResquestQueue;
    }
}
