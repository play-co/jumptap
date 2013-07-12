package com.tealeaf.plugin.plugins;

import com.tealeaf.logger;
import com.tealeaf.plugin.IPlugin;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Iterator;

import com.jumptap.adtag.JtAdWidgetSettingsFactory;
import com.jumptap.adtag.JtAdViewListener;
import com.jumptap.adtag.JtAdView;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.utils.JtException;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class JumptapPlugin implements IPlugin, JtAdViewListener {

	@Override
		public void onNoAdFound(JtAdView arg0, int arg1) {
			// TODO Auto-generated method stub

		}

	@Override
		public void onNewAd(JtAdView arg0, int arg1, String arg2) {
			// TODO Auto-generated method stub

		}

	@Override
		public void onInterstitialDismissed(JtAdView arg0, int arg1) {
			//adView.setVisibility(View.GONE); //just a suggestion

		}

	@Override
		public void onFocusChange(JtAdView arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub

		}

	@Override
		public void onAdError(JtAdView arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub

		}

	@Override
		public void onReturnFromActivity(JtAdView view, int arg1) {
		}

	@Override
		public void onLaunchActivity(JtAdView view, int arg1) {
		}

	@Override
		public void onBannerClicked(JtAdView view, int arg1) {
		}

	@Override
		public void onContract(JtAdView view, int arg1) {
		}

	@Override
		public void onExpand(JtAdView view, int arg1) {
		}

	@Override
		public void onHide(JtAdView view, int arg1) {
		}

	@Override
		public void onEndAdInteraction(JtAdView view, int arg1) {
		}

	@Override
		public void onBeginAdInteraction(JtAdView view, int arg1) {
		}

	JtAdView adView;

	public JumptapPlugin() {
	}

	public void onCreateApplication(Context applicationContext) {
	}

	public void onCreate(Activity activity, Bundle savedInstanceState) {
        PackageManager manager = activity.getPackageManager();
        String publisherId = "";
        try {
            Bundle meta = manager.getApplicationInfo(activity.getPackageName(), PackageManager.GET_META_DATA).metaData;
            if (meta != null) {
                publisherId = meta.get("JUMPTAP_PUBLISHER_ID").toString();
            }
        } catch (Exception e) {
            android.util.Log.d("EXCEPTION", "" + e.getMessage());
        }

		logger.log("{jumptap} Initializing from manifest with jumptapPublisherId=", publisherId);

		try {
			JtAdWidgetSettings s = JtAdWidgetSettingsFactory.createWidgetSettings();
			s.setPublisherId(publisherId);

			adView = new JtAdView(activity, s);
			adView.setAdViewListener(this);
		} catch (JtException e) {
            android.util.Log.d("EXCEPTION", "" + e.getMessage());
		}
	}

	public void onResume() {
	}

	public void onStart() {
	}

	public void onPause() {
	}

	public void onStop() {
	}

	public void onDestroy() {
	}

	public void onNewIntent(Intent intent) {
	}

	public void setInstallReferrer(String referrer) {
	}

	public void onActivityResult(Integer request, Integer result, Intent data) {
	}

	public boolean consumeOnBackPressed() {
		return true;
	}

	public void onBackPressed() {
	}
}
