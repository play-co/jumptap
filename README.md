# Game Closure DevKit Plugin: Jumptap

This plugin allows you to collect analytics using the [Jumptap](http://www.jumptap.com/) toolkit.  Both iOS and Android targets are supported.

## Usage

Install the addon with `basil install jumptap`.

Include it in the `manifest.json` file under the "addons" section for your game:

~~~
"addons": [
	"jumptap"
],
~~~

To specify your game's Tracking ID, edit the `manifest.json "android" and "ios" sections as shown below:

~~~
	"android": {
		"versionCode": 1,
		"icons": {
			"36": "resources/icons/android36.png",
			"48": "resources/icons/android48.png",
			"72": "resources/icons/android72.png",
			"96": "resources/icons/android96.png"
		},
		"jumptapPublisherId": "12345"
	},
~~~

~~~
	"ios": {
		"bundleID": "mmp",
		"appleID": "568975017",
		"version": "1.0.3",
		"icons": {
			"57": "resources/images/promo/icon57.png",
			"72": "resources/images/promo/icon72.png",
			"114": "resources/images/promo/icon114.png",
			"144": "resources/images/promo/icon144.png"
		},
		"jumptapPublisherId": "12345"
	},
~~~

Note that the manifest keys are case-sensitive.

You can test for successful integration via the [Jumptap website](http://www.jumptap.com/) after successfully building and running your game on a network-connected device.  Also check the console for helpful debug messages.

#### Helpful Links

https://support.jumptap.com/index.php/File:JTIPHONESDK.zip
https://support.jumptap.com/index.php/File:JTANDROIDSDK.zip
