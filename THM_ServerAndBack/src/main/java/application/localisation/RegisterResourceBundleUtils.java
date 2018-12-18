package application.localisation;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class RegisterResourceBundleUtils {

	public enum RegisterResourceKeys {
		txt_register_Lable, txt_userName_Lable, txt_password1_Lable, txt_password2_Lable, 
		txt_userName_TextField, txt_password1_PasswordField, txt_password2_PasswordField, 
		txt_back_Button, txt_register_Button
	}

	private static final String INDICATOR_MISSING_RESOURCE = "?";
	private static final String INDICATOR_MISSING_KEY = "??";

	public static String getLangString(final ResourceBundle resourceBundle, final RegisterResourceKeys key) {
		if (resourceBundle != null) {
			try {
				return resourceBundle.getString(key.name());
			} catch (final MissingResourceException e) {
				return INDICATOR_MISSING_KEY + key;
			}
		}
		return INDICATOR_MISSING_RESOURCE + key;
	}

	public static void main(final String[] args) throws MissingResourceException {
		System.out.println("Current Locale: " + Locale.getDefault());
		final String BUNDLE_BASENAME = "Register";
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.GERMANY));
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.UK));
	}

	private static void showTexts(final ResourceBundle resourceBundle) {
		final String txt_register_Lable = RegisterResourceBundleUtils.getLangString(resourceBundle,
				RegisterResourceKeys.txt_register_Lable);

		final String txt_userName_lable = RegisterResourceBundleUtils.getLangString(resourceBundle,
				RegisterResourceKeys.txt_userName_Lable);

		final String txt_password1_Lable = RegisterResourceBundleUtils.getLangString(resourceBundle,
				RegisterResourceKeys.txt_password1_Lable);

		final String txt_password2_Lable = RegisterResourceBundleUtils.getLangString(resourceBundle,
				RegisterResourceKeys.txt_password2_Lable);

		final String txt_userName_TextField = RegisterResourceBundleUtils.getLangString(resourceBundle,
				RegisterResourceKeys.txt_userName_TextField);

		final String txt_password1_PasswordField = RegisterResourceBundleUtils.getLangString(resourceBundle,
				RegisterResourceKeys.txt_password1_PasswordField);
		
		final String txt_password2_PasswordField = RegisterResourceBundleUtils.getLangString(resourceBundle,
				RegisterResourceKeys.txt_password2_PasswordField);
		
		final String txt_back_Button = RegisterResourceBundleUtils.getLangString(resourceBundle,
				RegisterResourceKeys.txt_back_Button);
		
		final String txt_register_Button = RegisterResourceBundleUtils.getLangString(resourceBundle,
				RegisterResourceKeys.txt_register_Button);
		
		
	}

}
