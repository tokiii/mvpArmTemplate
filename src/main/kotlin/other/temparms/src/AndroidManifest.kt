package other.temparms.src

import other.temparms.ArmsPluginTemplateProviderImpl

fun armsManifest(provider: ArmsPluginTemplateProviderImpl)= """
    
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
package="${provider.appPackageName.value}">
    <application>
        ${if (provider.isModule.value){
    """
        <activity android:name="${provider.activityPackageName.value}.${provider.pageName.value}Activity"
         android:screenOrientation="portrait"/>
	    
    """
}else{
    """
        <activity
	        android:name="${provider.activityPackageName.value}.${provider.pageName.value}Activity"
            android:screenOrientation="portrait"
	        />
    """
} }
    </application>
</manifest>
"""