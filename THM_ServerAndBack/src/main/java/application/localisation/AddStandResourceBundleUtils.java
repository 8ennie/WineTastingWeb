package application.localisation;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class AddStandResourceBundleUtils {

	public enum AddStandResourceKeys {
		txt_settings_Menu, 
		txt_language_Menu,
		txt_german_MenuItem,
		txt_english_MenuItem,
		txt_user_Menu,
		txt_logOut_MenuItem,
		txt_options_Lable,
		txt_edit_Button,
		txt_evaluation_Button,
		txt_viewEvaluation_Button
	}

	private static final String INDICATOR_MISSING_RESOURCE = "?";
	private static final String INDICATOR_MISSING_KEY = "??";

	public static String getLangString(final ResourceBundle resourceBundle, final AddStandResourceKeys key) {
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
		final String BUNDLE_BASENAME = "AddStand";
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.GERMANY));
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.UK));
	}

	private static void showTexts(final ResourceBundle resourceBundle) {
		
		final String txt_settings_Menu = AddStandResourceBundleUtils.getLangString(resourceBundle,
				AddStandResourceKeys.txt_settings_Menu);

		
		
	}

}
