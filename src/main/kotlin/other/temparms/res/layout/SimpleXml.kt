package other.temparms.res.layout

import other.temparms.ArmsPluginTemplateProviderImpl

fun simpleLayout(provider: ArmsPluginTemplateProviderImpl)= """
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:tools="http://schemas.android.com/tools"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:background="@color/white"
              android:fitsSystemWindows="true">

              <include layout="@layout/public_custom_toolbar"/>

</LinearLayout>
"""