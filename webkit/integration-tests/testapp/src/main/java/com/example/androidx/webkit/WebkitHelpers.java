/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.androidx.webkit;

import android.app.Activity;
import android.content.pm.PackageInfo;

import androidx.webkit.WebViewCompat;

/**
 * Static utility methods for the Webkit demo app.
 */
public final class WebkitHelpers {
    /**
     * Inserts the {@link android.webkit.WebView} version in the current Activity title. This
     * assumes the title has already been set to something interesting, and we want to append the
     * WebView version to the end of the title.
     */
    public static void appendWebViewVersionToTitle(Activity activity) {
        PackageInfo webViewPackage = WebViewCompat.getCurrentWebViewPackage(activity);

        final String webViewVersion = webViewPackage != null
                ? webViewPackage.versionName
                : activity.getResources().getString(R.string.not_updateable_webview);

        final String oldTitle = activity.getTitle().toString();
        final String newTitle = oldTitle + " (" + webViewVersion + ")";
        activity.setTitle(newTitle);
    }

    // Do not instantiate this class.
    private WebkitHelpers() {}
}
