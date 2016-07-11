package rbox.xposed.firetvmods;

import android.os.Parcel;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class HideLauncherAds implements IXposedHookLoadPackage{

	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable
	{
		if (lpparam.packageName.equals("com.amazon.kso.blackbird"))
		{
			XposedHelpers.findAndHookMethod("com.amazon.kso.blackbird.service.StaticImageAd", lpparam.classLoader, "writeToParcelImpl", Parcel.class, int.class, new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable
				{
						param.setResult(null);
				}
			});
		}
	}
