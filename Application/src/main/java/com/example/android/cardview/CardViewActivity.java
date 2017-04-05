/*
* Copyright 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.cardview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

/**
 * Launcher Activity for the CardView sample app.
 * Activity生命周期的数据恢复 关注重点方法onCreate
 * onSaveInstanceState
 * onRestoreInstanceState
 */
public class CardViewActivity extends FragmentActivity {

    private static final String TAG = "cai";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, CardViewFragment.newInstance())
                    .commit();

            testViewDialogFragment();
        }

        if (savedInstanceState != null) {
            String value = savedInstanceState.getString("key");
            Log.d(TAG, "onCreate: " + value);
        }
//        Log.d(TAG, "onCreate: ");
    }


    //展示DialogFragment特性  转屏保存
    void testViewDialogFragment() {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getSupportFragmentManager(),"TAG");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: ");
    }

    /**
     * 在onDestroy之前调用；用于横竖屏的切换调用
     * or 当app进入后台时调用(按home键)
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", "value");
        Log.d(TAG, "onSaveInstanceState: ");
    }

    /**
     * 在onCreate后面调用
     *
     * @param savedInstanceState 这个bundlle和onCreate里的Bundle里的是一样的
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
//        Log.d(TAG, "onRestoreInstanceState: ");

        if (savedInstanceState != null) {
            String value = savedInstanceState.getString("key");
            Log.d(TAG, "onRestoreInstanceState: " + value);
        }
    }
}
