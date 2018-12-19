package application.localisation;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class OptionResourceBundleUtils {

	public enum OptionResourceKeys {
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

	public static String getLangString(final ResourceBundle resourceBundle, final OptionResourceKeys key) {
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
		final String BUNDLE_BASENAME = "Option";
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.GERMANY));
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.UK));
	}

	private static void showTexts(final ResourceBundle resourceBundle) {
		
		final String txt_settings_Menu = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_settings_Menu);

		final String txt_language_Menu = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_language_Menu);

		final String txt_german_MenuItem = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_german_MenuItem);

		final String txt_english_MenuItem = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_english_MenuItem);

		final String txt_user_Menu = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_user_Menu);

		final String txt_logOut_MenuItem = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_logOut_MenuItem);
		
		final String txt_options_Lable = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_options_Lable);
		
		final String txt_edit_Button = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_edit_Button);
		
		final String txt_evaluation_Button = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_evaluation_Button);
		
		final String txt_viewEvaluation_Button = OptionResourceBundleUtils.getLangString(resourceBundle,
				OptionResourceKeys.txt_viewEvaluation_Button);
		
		
	}

}
